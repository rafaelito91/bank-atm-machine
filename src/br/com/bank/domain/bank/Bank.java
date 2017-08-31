package br.com.bank.domain.bank;

import br.com.bank.domain.bank.account.Account;
import br.com.bank.domain.bank.account.statement.DefaultTrackedStatement;
import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.bank.account.exception.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>Bank</code> the bank represents the Bank which the <code>ATM</code> belongs to.
 */
public class Bank {

    List<Account> accounts = new LinkedList();

    public Bank(final List<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    public String login(final String accountId) throws AccountException {
        return getAccountById(accountId).getClientName();
    }

    public BigDecimal consultBalance(final String id) throws AccountException {
        return getAccountById(id).getBalance();
    }

    public BigDecimal withdraw(final String id, final BigDecimal value) throws AccountException {
        return getAccountById(id).withdraw(value);
    }

    public BigDecimal deposit(final String id, final BigDecimal value) throws AccountException {
        return getAccountById(id).deposit(value);
    }

    public void transfer(final String idAuthor, final String idRecipient, final BigDecimal value) throws AccountException {
        // Melhoria: lancar domain event
        getAccountById(idAuthor).transfer(value, getAccountById(idRecipient));
    }

    public List<DefaultTrackedStatement> getAccountStatements(final String id) throws AccountException {
        return getAccountById(id).getStatements();
    }
    private Account getAccountById(final String id) throws AccountException {
        final Account account = accounts.stream().filter(acc -> acc.hasId(id)).findFirst().get();
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }
}
