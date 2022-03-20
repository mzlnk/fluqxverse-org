package io.mzlnk.identitybroker.server.common.exception;

import lombok.Getter;

@Getter
public class InvalidEnumException extends RuntimeException {

    private final String value;

    public InvalidEnumException(String value, String message) {
        super(message);
        this.value = value;
    }

}
