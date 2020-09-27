package com.example.gatewaydemo.config;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/25 14:13
 * @Version 1.0
 **/
public class TokenAuthenticationManager /*implements ReactiveAuthenticationManager*/ {
/*

    private TokenStore tokenStore;

    public TokenAuthenticationManager(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }


//    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return   Mono.justOrEmpty(authentication)
                .filter(auth ->auth instanceof BearerTokenAuthenticationToken)
                .cast(BearerTokenAuthenticationToken.class)
                .map(BearerTokenAuthenticationToken::getToken)
                .flatMap((accessTokenValue -> {
                    //从redis获取token
                    OAuth2AccessToken accessToken = tokenStore.readAccessToken(accessTokenValue);

                    if(BeanUtil.isEmpty(accessToken)){
                        OAuth2Error error=new BearerTokenError(BearerTokenErrorCodes.INVALID_TOKEN,
                                HttpStatus.UNAUTHORIZED,"accessTokenValue","");
                        return   Mono.error(new OAuth2AuthenticationException(error,"Invalid access token: " + accessTokenValue));
                    }if (accessToken.isExpired()) {
                        tokenStore.removeAccessToken(accessToken);
                        OAuth2Error error = new BearerTokenError(
                                BearerTokenErrorCodes.INVALID_TOKEN,
                                HttpStatus.UNAUTHORIZED,
                                "Access token expired: " + accessTokenValue,
                                "https://tools.ietf.org/html/rfc6750#section-3.1");

                        return  Mono.error(new OAuth2AuthenticationException(error,"Access token expired: " + accessTokenValue));
                    }
                    OAuth2Authentication result = tokenStore.readAuthentication(accessToken);
                    if (result == null) {
                        return Mono.error(new InvalidTokenException("Invalid access token: " + accessTokenValue));
                    }
                    return Mono.just(result);
                })).cast(Authentication.class);

    }
*/

}
