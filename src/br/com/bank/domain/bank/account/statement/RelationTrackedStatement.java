package br.com.bank.domain.bank.account.statement;

import br.com.bank.domain.bank.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by rafael on 30/08/17.
 */
public class RelationTrackedStatement extends DefaultTrackedStatement {

    private final Account recipient;

    public RelationTrackedStatement(final TrackedStatementType type, final LocalDateTime operationDate,
                                    final BigDecimal operationValue, final Account recipient) {
        super(type, operationDate, operationValue);
        this.recipient = recipient;
    }
}
