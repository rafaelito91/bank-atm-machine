package br.com.bank.domain.bank.account;

import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.bank.account.exception.InsufficientFundsException;
import br.com.bank.domain.bank.account.statement.DefaultTrackedStatement;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rafael on 30/08/17.
 */
public class Account {

    private Client client;

    private String accountId;

    private BigDecimal balance;

    private List<DefaultTrackedStatement> trackedOperations = new LinkedList<>();

    public Account(final Client client, final String accountId, final BigDecimal balance) {
        this.client = client;
        this.accountId = accountId;
        this.balance = balance;
    }

    public BigDecimal getBalance () {
        return new BigDecimal(balance.doubleValue());
    }

    public BigDecimal withdraw(final BigDecimal value) throws AccountException {
        if(balance.compareTo(value) < 0) {
            throw new InsufficientFundsException();
        }
        balance.subtract(value);
        return value;
    }

    public BigDecimal deposit(final BigDecimal value) {
        return balance.add(value);
    }

    // Melhoria: lancar domain event
    public void transfer(final BigDecimal value, final Account recipient) throws AccountException {
        withdraw(value);
        recipient.deposit(value);
    }

    public boolean hasId(final String id) {
        return this.accountId.equals(id);
    }

    public List<DefaultTrackedStatement> getStatements() {
        return Collections.unmodifiableList(trackedOperations);
    }

    public String getClientName() {
        return client.getName();
    }
}
