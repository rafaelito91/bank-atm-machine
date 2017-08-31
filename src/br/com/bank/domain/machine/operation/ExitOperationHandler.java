package br.com.bank.domain.machine.operation;

import br.com.bank.config.UserToken;
import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.machine.ATM;

/**
 * Created by rafael on 31/08/17.
 */
public class ExitOperationHandler extends OperationHandler {

    public ExitOperationHandler(final Bank bank) {
        super(bank);
    }

    @Override
    public String executeOperation(final OperationParameters operationParameters) throws AccountException {
        final UserToken userToken = operationParameters.getOrigin();
        userToken.logout();
        return "User " + userToken.getName() + " logged out";
    }
}
