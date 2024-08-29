package com.aug.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {
    @Getter
    private final Set<String> violations;

    @Getter
    private final String violationSource;
}
