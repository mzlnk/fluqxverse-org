package io.mzlnk.fluqxverse.authn.api.user.dto;

import io.mzlnk.fluqxverse.authn.domain.identity.IdentityProviderType;

import java.util.List;

public record UserResponse(Long id,
                           String email,
                           List<IdentityProviderType> linkedProviders) {

}