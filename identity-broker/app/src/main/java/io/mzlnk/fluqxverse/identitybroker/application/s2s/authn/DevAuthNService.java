package io.mzlnk.fluqxverse.identitybroker.application.s2s.authn;

import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.IdentityCreateRequest;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.IdentityDetails;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.UserCreateRequest;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.UserDetails;

import java.util.Collections;
import java.util.Optional;

public class DevAuthNService implements AuthNService {

    private long userIdSequence = 0L;

    @Override
    public UserDetails createUser(UserCreateRequest userCreateRequest) {
        return new UserDetails(++userIdSequence, userCreateRequest.getEmail(), Collections.emptyList());
    }

    @Override
    public Optional<UserDetails> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public IdentityDetails createIdentity(IdentityCreateRequest identityCreateRequest) {
        return new IdentityDetails(identityCreateRequest.getId(), identityCreateRequest.getProvider(), userIdSequence);
    }

}