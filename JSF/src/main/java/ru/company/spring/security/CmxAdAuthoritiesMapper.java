package ru.company.spring.security;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

public class CmxAdAuthoritiesMapper implements GrantedAuthoritiesMapper {

    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Set<MyAuthority> roles = EnumSet.noneOf(MyAuthority.class);

        for (GrantedAuthority a: authorities) {
            if ("Employees".equals(a.getAuthority())) {
                roles.add(MyAuthority.ROLE_USER);
            }
        }
        return roles;
    }
}

enum MyAuthority implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER;

    public String getAuthority() {
        return name();
    }
}