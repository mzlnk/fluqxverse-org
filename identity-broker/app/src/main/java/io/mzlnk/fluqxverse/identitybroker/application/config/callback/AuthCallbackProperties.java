package io.mzlnk.fluqxverse.identitybroker.application.config.callback;

import lombok.Data;

@Data
public class AuthCallbackProperties {

    private CookieDetails cookie;

    @Data
    public static class CookieDetails {

        private String name;
        private String domain;
        private String path;
        private String sameSite;
        private Long maxAge;
        private Boolean secure;
        private Boolean httpOnly;

    }

}