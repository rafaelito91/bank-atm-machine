package br.com.bank.domain.machine;


import br.com.bank.config.Option;
import br.com.bank.config.UserToken;
import br.com.bank.config.exception.IllegalMenuIndexException;
import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.machine.operation.ConsultOperationHandler;
import br.com.bank.domain.machine.operation.ExitOperationHandler;
import br.com.bank.domain.machine.operation.OperationHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <code>ATM</code> is a domain class that represents the actual ATM machine
 */
public class ATM {

    private final Money moneyCapacity;

    private final Bank myBank;

    private Map<MenuItem, OperationHandler> operations = new HashMap<>();

    public ATM(final Bank bank, final Money money) {
        this.myBank = bank;
        this.moneyCapacity = money;
        initializeOperations(bank);
    }

    public UserToken login(final String accountId) throws AccountException {
        return new UserToken(myBank.login(accountId), accountId);
    }

    public List<Option> getMenuOptions() {
        List<Option> menuOptions = new LinkedList<>();
        for (final MenuItem menuItem : MenuItem.values()) {
            menuOptions.add(new Option(menuItem.getIndex(), menuItem.getOperationName()));
        }
        return menuOptions;
    }

    public void execute(final Integer selectedOption, final UserToken userToken) throws IllegalMenuIndexException {
        final OperationHandler handler = operations.get(MenuItem.getMenuOperationByIndex(selectedOption));
        handler.executeOperation(userToken);
    }

    private void initializeOperations(final Bank bank) {
        operations.put(MenuItem.CONSULT, new ConsultOperationHandler(bank));
        operations.put(MenuItem.WITHDRAW, new );
        operations.put(MenuItem.DEPOSIT, new );
        operations.put(MenuItem.TRANSFER, new );
        operations.put(MenuItem.STATEMENT, new );
        operations.put(MenuItem.EXIT, new ExitOperationHandler(bank));
    }
}
