package com.elsawaf.yakimbee.enumerations;


import static com.elsawaf.yakimbee.enumerations.Authority.*;

public enum RoleType {


    ROLE_USER(USER_AUTHORITIES),
    ROLE_HR(HR_AUTHORITIES) ,
    ROLE_MANAGER(MANAGER_AUTHORITIES) ,
    ROLE_ADMIN(ADMIN_AUTHORITIES) ,
    ROLE_SUPER_USER(SUPER_USER_AUTHORITIES);

    private String[] authorities;

    public String[] getAuthorities() {
        return authorities;
    }

    RoleType(String... authorities) {
        this.authorities=authorities;
    }
}
