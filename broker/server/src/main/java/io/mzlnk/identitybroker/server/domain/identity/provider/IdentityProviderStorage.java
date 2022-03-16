package io.mzlnk.identitybroker.server.domain.identity.provider;

import io.mzlnk.identitybroker.server.application.auth.AuthProviderProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static io.mzlnk.identitybroker.server.application.auth.AuthProviderProperties.AuthProviderDetails;

@Service
public class IdentityProviderStorage {

    private final List<IdentityProvider> enabledIdentityProviders;

    public IdentityProviderStorage(AuthProviderProperties authProviderProperties) {
        this.enabledIdentityProviders = retrieveEnabledProviders(authProviderProperties.getProviders());
    }

    public List<IdentityProvider> listIdentityProviders() {
        return enabledIdentityProviders;
    }

    private List<IdentityProvider> retrieveEnabledProviders(Map<IdentityProviderType, AuthProviderDetails> providers) {
        return providers.entrySet().stream()
                .filter(entry -> entry.getValue().isEnabled())
                .map(entry -> {
                    IdentityProviderType type = entry.getKey();
                    String clientId = entry.getValue().getClientId();
                    String redirectUri = entry.getValue().getRedirectUri();

                    return new IdentityProvider(type, clientId, redirectUri);
                })
                .toList();
    }

}
