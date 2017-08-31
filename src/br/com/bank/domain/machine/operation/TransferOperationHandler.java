package br.com.bank.domain.machine.operation;

import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.exception.AccountException;

/**
 * Class comments go here...
 *
 * @author focus
 * @version 1.0 31/08/2017
 */
public class TransferOperationHandler extends OperationHandler {

    public TransferOperationHandler(final Bank bank) {
        super(bank);
    }

    @Override
    public String executeOperation(final OperationParameters operationParameters) throws AccountException {
        return null;
    }
}
