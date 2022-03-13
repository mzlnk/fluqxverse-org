package io.mzlnk.identitybroker.server.api;

import io.mzlnk.identitybroker.server.api.dto.IdentityProviderDetails;
import io.mzlnk.identitybroker.server.api.dto.IdentityProviderMapper;
import io.mzlnk.identitybroker.server.domain.identityprovider.IdentityProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/identity-providers")
public class IdentityProviderController {

    private final IdentityProviderMapper identityProviderMapper;
    private final IdentityProviderService identityProviderService;

    @GetMapping
    public ResponseEntity<List<IdentityProviderDetails>> listIdentityProviders() {
        var providers = identityProviderService.listIdentityProviders().stream()
                .map(identityProviderMapper::toIdentityProviderDetails)
                .toList();

        return ResponseEntity.ok(providers);
    }

}
