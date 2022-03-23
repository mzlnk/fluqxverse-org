package io.mzlnk.fluqxverse.identitybroker.application.s2s.authn;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.IdentityCreateRequest;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.IdentityDetails;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.UserCreateRequest;
import io.mzlnk.fluqxverse.identitybroker.application.s2s.authn.dto.UserDetails;

public interface AuthNApi {

    @RequestLine("GET /authn/api/v1/users/email/{email}")
    UserDetails getUserByEmail(@Param("email") String email);

    @RequestLine("POST /authn/api/v1/users")
    @Headers("Content-Type: application/json")
    UserDetails createUser(UserCreateRequest userCreateRequest);

    @RequestLine("POST /authn/api/v1/identities")
    @Headers("Content-Type: application/json")
    IdentityDetails createIdentity(IdentityCreateRequest identityCreateRequest);

}