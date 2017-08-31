package br.com.bank.domain.machine.operation;

import br.com.bank.config.UserToken;

/**
 * Created by rafael on 31/08/17.
 */
public interface OperationHandler {

    void executeOperation(final UserToken userToken);
}
