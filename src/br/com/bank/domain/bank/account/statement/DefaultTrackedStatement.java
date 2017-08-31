package br.com.bank.domain.bank.account.statement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by rafael on 30/08/17.
 */
public class DefaultTrackedStatement {

    private final TrackedStatementType type;

    private final LocalDateTime operationDate;

    private final BigDecimal operationValue;

    public DefaultTrackedStatement(final TrackedStatementType type, final LocalDateTime operationDate, final BigDecimal operationValue) {
        this.type = type;
        this.operationDate = operationDate;
        this.operationValue = operationValue;
    }

    public String toString() {
        return "Client " + type.getOperatioAction() + " " + operationValue.toString() + "reais.";
    }
}
