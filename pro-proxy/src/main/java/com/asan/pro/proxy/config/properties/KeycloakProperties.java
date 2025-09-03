package com.asan.pro.proxy.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Keycloak 관련 설정을 담는 클래스
 * application.yml의 'keycloak' 접두사를 가진 속성들을 매핑합니다.
 */
@ConfigurationProperties(prefix = "keycloak")
public record KeycloakProperties(
        String authServerUrl,
        String realm,
        String clientId,
        String clientSecret
) {
}
