package com.system.po;

/**
 * Userlogin扩展类
 */
public class UserloginCustom extends User {

    private Role obRole;

    public void setRole(Role obRole) {
        this.obRole = obRole;
    }

    public Role getObRole() {
        return obRole;
    }

}
