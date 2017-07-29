package com.gpfs.security.service.custom;

import com.google.common.collect.ImmutableMap;
import com.gpfs.core.dto.UserProfileInfo;
import com.gpfs.core.service.GpfsJpaServiceCustom;
import com.gpfs.security.model.UserProfile;
import com.querydsl.core.types.Path;

/**
 * Created by jbvillanueva on 5/21/17.
 */
public interface UserProfileServiceCustom extends GpfsJpaServiceCustom<UserProfile, UserProfileInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.<String, Path<?>>builder()
                .build();
    }

    UserProfileInfo findByUsernameInfo(String userName);
}
