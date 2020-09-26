package com.example.gatewaydemo.config;

import com.example.gatewaydemo.component.ApiAccessDeniedHandler;
import com.example.gatewaydemo.component.ApiAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/26 16:45
 * @Version 1.0
 **/
@Configuration
@EnableWebFluxSecurity
public class GateSecurityConfig {


    @Autowired
    private AccessManager accessManager;

    @Autowired
    private TokenStore tokenStore;


    //自定义返回结果：没有权限访问时
    @Autowired
    private ApiAccessDeniedHandler apiAccessDeniedHandler;

    //自定义返回结果：没有登录或token过期时
    @Autowired
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;

    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception{
        //token管理器
        ReactiveAuthManager tokenAuthenticationManager = new ReactiveAuthManager(tokenStore);
        //认证过滤器
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(tokenAuthenticationManager);
        authenticationWebFilter.setServerAuthenticationConverter(new ServerBearerTokenAuthenticationConverter());

      /*  http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .anyExchange().access(accessManager)
                .and()
                // 跨域过滤器
                //oauth2认证过滤器
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION);*/



        http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeExchange()  //进行处理
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .anyExchange().access(accessManager)//配置自定义的鉴权管理器
                .and().exceptionHandling()  //异常处理
                .accessDeniedHandler(apiAccessDeniedHandler)//处理未授权
                .authenticationEntryPoint(apiAuthenticationEntryPoint)//处理未认证
                .and()
                .addFilterBefore(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable();

        return http.build();
    }

}
