package com.gpfs.security.service.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gpfs.core.dto.UserInfo;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.security.model.User;
import com.gpfs.security.model.UserProfile;
import com.gpfs.security.service.UserProfileService;
import com.gpfs.security.service.UserService;
import com.gpfs.security.service.custom.UserServiceCustom;

public class UserServiceCustomImpl extends GpfsJpaServiceCustomImpl<User, UserInfo, UserService>
    implements UserServiceCustom {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceCustomImpl.class);

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = toDto(repo.findByUsername(username));
        if (null == user) {
            LOG.info("Failed login attempt. username={}", username);
            throw new UsernameNotFoundException("User not found with username= " + username);
        }

        UserProfile userProfile = userProfileService.findByUser_username(user.getUsername());
        if (userProfile.getUser().isDeleted()) {
            LOG.info("Failed login attempt. Username={} is disabled", username);
            throw new IllegalStateException("User is inactive");
        }
        LOG.info("Successful login attempt. username={}", username);
        return user;
    }

    @Override
    public UserInfo findInfoByUserName(String userName) {
        return toDto(repo.findByUsername(userName));
    }

}
