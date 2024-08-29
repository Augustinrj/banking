package com.aug.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */


@RequiredArgsConstructor
@Getter
public class OperationNonPermittedException extends RuntimeException{

    private final String errorMsg;

    private final String operationId;

    private final String source;

    private final String dependency;
}
