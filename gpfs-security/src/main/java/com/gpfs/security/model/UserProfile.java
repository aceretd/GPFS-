package com.gpfs.security.model;


import javax.persistence.*;

import com.gpfs.core.dto.Name;
import com.gpfs.core.model.BaseEntity;

/**
 * Created by jbvillanueva on 5/21/17.
 */
@Entity(name = "user_profile")
public class UserProfile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Embedded
    private Name name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
