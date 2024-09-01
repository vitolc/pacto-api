package com.vitulc.pactotestapi.utilities;

import com.vitulc.pactotestapi.config.security.DbUserDetails;
import com.vitulc.pactotestapi.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static User loggedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        return ((DbUserDetails) authentication.getPrincipal()).getUser();
    }
}
