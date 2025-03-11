package com.example.webSale.service.impl;

import com.example.webSale.dto.MyUser;
import com.example.webSale.entity.GroupPermissionEntity;
import com.example.webSale.entity.PermissionEntity;
import com.example.webSale.entity.RoleEntity;
import com.example.webSale.entity.UsersEntity;
import com.example.webSale.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity userEntity = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        RoleEntity roles = userEntity.getRoleId();
        authorities.add(new SimpleGrantedAuthority(roles.getCode()));
        for (GroupPermissionEntity groupPmEntity : roles.getGroupPmEntities()){
            authorities.add(new SimpleGrantedAuthority(groupPmEntity.getCode()));
            for (PermissionEntity permissionEntity : groupPmEntity.getPermissionEntities()){
                authorities.add(new SimpleGrantedAuthority(permissionEntity.getCode()));
            }
        }
        return new MyUser(userEntity.getEmail()
                ,userEntity.getPassword()
                ,true,true,true,true,authorities,userEntity.getId(),userEntity.getName());

    }
}
