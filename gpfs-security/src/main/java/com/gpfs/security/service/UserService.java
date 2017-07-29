package com.gpfs.security.service;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.security.model.User;
import com.gpfs.security.service.custom.UserServiceCustom;

public interface UserService extends GpfsJpaService<User>, UserServiceCustom {

    User findByUsername(String username);
    User findByEmail(String email);

}
