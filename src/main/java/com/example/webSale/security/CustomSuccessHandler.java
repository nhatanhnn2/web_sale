package com.example.webSale.security;

import com.example.webSale.service.RoleService;
import com.example.webSale.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler {
    @Autowired
    private RoleService roleService;

    private String redirectUrl(Long roleId){
        List<String> roles = roleService.findAllPermissionByRole(roleId);
        String url = "";
        if (isAdmin(roles)) {
            url = "/admin";
        } else {
            url = "/trang-chu";
        }

        return url;
    }
    private boolean isAdmin(List<String> roles) {
        if (roles.contains("SUPER") || roles.contains("SYS") ||
                roles.contains("SP") || roles.contains("SYS_USER")|| roles.contains("SP_NEW")) {
            return true;
        }
        return false;
    }
}
