package br.com.bank.domain.machine;

import br.com.bank.config.exception.IllegalMenuIndexException;

/**
 * Created by rafael on 30/08/17.
 */
public enum MenuItem {

    CONSULT(1, "Consult"), WITHDRAW(2, "Withdraw"), DEPOSIT(3, "Deposit"), TRANSFER(4, "Transfer"), STATEMENT(5, "Statements"), EXIT(6, "Exit");

    private Integer index;

    private String operationName;

    MenuItem(final Integer index, final String operationName) {
        this.index = index;
        this.operationName = operationName;
    }

    public Integer getIndex() {
        return index;
    }

    public String getOperationName() {
        return operationName;
    }

    public static MenuItem getMenuOperationByIndex(final Integer index) throws IllegalMenuIndexException {
        for (final MenuItem menuOperation : values()) {
            if (menuOperation.getIndex().equals(index)) {
                return menuOperation;
            }
        }
        throw new IllegalMenuIndexException();
    }
}
