package br.com.bank.domain.bank.account.statement;

/**
 * Created by rafael on 30/08/17.
 */
public enum TrackedStatementType {

    WITHDRAW("Withdrew"), DEPOSIT("Deposited"), EXECUTED_TRANSFER("Executed Transfer of"), RECEIVED_TRANSFER("Received Transfer of");

    private String operationAction;

    TrackedStatementType(final String operationAction) {
        this.operationAction = operationAction;
    }

    public String getOperatioAction() {
        return operationAction;
    }
}
