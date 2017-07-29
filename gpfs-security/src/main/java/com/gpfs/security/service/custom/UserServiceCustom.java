package com.gpfs.security.service.custom;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.google.common.collect.ImmutableMap;
import com.gpfs.core.dto.UserInfo;
import com.gpfs.core.service.GpfsJpaServiceCustom;
import com.gpfs.security.model.User;
import com.querydsl.core.types.Path;

public interface UserServiceCustom extends GpfsJpaServiceCustom<User, UserInfo>, UserDetailsService {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.<String, Path<?>>builder()
                .build();
    }

    UserInfo findInfoByUserName(String userName);

}
