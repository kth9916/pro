package com.asan.pro.domain.auth.domain.service;

import com.asan.pro.domain.user.domain.entity.User;

public interface KeycloakSyncService {
    void syncUser(User user);
    // 필요에 따라 사용자 업데이트, 삭제 등 다른 동기화 메서드 추가
}
