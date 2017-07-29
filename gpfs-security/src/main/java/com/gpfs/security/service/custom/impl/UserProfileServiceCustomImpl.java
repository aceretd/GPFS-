package com.gpfs.security.service.custom.impl;

import com.gpfs.core.dto.UserProfileInfo;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.security.model.UserProfile;
import com.gpfs.security.service.UserProfileService;
import com.gpfs.security.service.custom.UserProfileServiceCustom;

/**
 * Created by jbvillanueva on 5/21/17.
 */
public class UserProfileServiceCustomImpl
        extends GpfsJpaServiceCustomImpl<UserProfile, UserProfileInfo, UserProfileService>
        implements UserProfileServiceCustom {

    @Override
    public UserProfileInfo findByUsernameInfo(String username) {
        return toDto(repo.findByUser_username(username));
    }

}
