package br.com.bank.domain.machine.operation;

import br.com.bank.config.UserToken;
import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.exception.AccountException;

import java.math.BigDecimal;

/**
 * Class comments go here...
 *
 * @author focus
 * @version 1.0 31/08/2017
 */
public class DepositOperationHandler extends OperationHandler {

    public DepositOperationHandler(final Bank bank) {
        super(bank);
    }

    @Override
    public String executeOperation(final OperationParameters operationParameters) throws AccountException {
        return null;
    }
}
