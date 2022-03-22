package io.mzlnk.fluqxverse.identitybroker.application.security.auth.authz;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface AuthZService {

    List<? extends GrantedAuthority> fetchAuthorities(String token) throws AuthZException;

}