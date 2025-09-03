package com.asan.pro.proxy.auth;

import com.asan.pro.domain.user.domain.entity.User;

public interface KeycloakSyncService {
    void syncUser(User user, String password);
    // 필요에 따라 사용자 업데이트, 삭제 등 다른 동기화 메서드 추가
}
