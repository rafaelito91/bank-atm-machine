package br.com.bank.domain.machine.operation;

import br.com.bank.config.UserToken;
import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.machine.ATM;

/**
 * Created by rafael on 31/08/17.
 */
public abstract class OperationHandler {

    private Bank bank;

    public OperationHandler(final Bank bank) {
        this.bank = bank;
    }

    public abstract String executeOperation(final OperationParameters operationParameters) throws AccountException;

    protected Bank getBank() {
        return bank;
    }
}
