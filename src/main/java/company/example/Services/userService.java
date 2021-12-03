package com.walrusx.admin.services;

import com.walrusx.admin.manager.UserManager;
import javax.ws.rs.core.Response;

public class UserService {

    private final UserManager userManager;

    public getUserManager() throws ServerException {
        return new userManager();
    }

}
