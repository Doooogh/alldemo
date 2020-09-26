package com.example.gatewaydemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/26 16:47
 * @Version 1.0
 **/

@Slf4j
@Component
public class AccessManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        List<String> needRoles = new ArrayList<>();
        return mono
                //验证是否已经认证通过
                .filter(Authentication::isAuthenticated)
                //获取该用户所有的角色
                .flatMapIterable(Authentication::getAuthorities)
                //获取角色
                .map(GrantedAuthority::getAuthority)
                //如果满足一个相等的角色就放行
                .any(needRoles::contains)
                .map(AuthorizationDecision::new)
                //如果最后没有 完成验证 不给验证通过
                .defaultIfEmpty(new AuthorizationDecision(false));

//        return null;
    }
}
