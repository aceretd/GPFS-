package com.gpfs.security.service;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.security.model.UserProfile;
import com.gpfs.security.service.custom.UserProfileServiceCustom;

/**
 * Created by jbvillanueva on 5/21/17.
 */
public interface UserProfileService extends GpfsJpaService<UserProfile>, UserProfileServiceCustom {

    UserProfile findById(Long id);
    UserProfile findByUser_username(String username);

}
