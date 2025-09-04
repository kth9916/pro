package com.asan.pro.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
@EnableJpaRepositories(basePackages = "com.asan.pro.proxy") // Repository 스캔 경로 지정
@EntityScan(basePackages = "com.asan.pro.proxy") // Entity 스캔 경로 지정
public class JpaConfig {
}