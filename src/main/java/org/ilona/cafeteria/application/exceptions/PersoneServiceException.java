package org.ilona.cafeteria.application.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersoneServiceException extends RuntimeException {
    public PersoneServiceException(String message) {
        super(message);
    }

    public PersoneServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        log.info("Instance {}",getCause().getClass());
        log.info(getCause().getLocalizedMessage());
        return super.getMessage();
    }
}
