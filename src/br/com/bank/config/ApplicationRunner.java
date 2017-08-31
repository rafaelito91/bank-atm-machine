package br.com.bank.config;

import br.com.bank.config.exception.ApplicationEndedException;
import br.com.bank.config.exception.IllegalMenuIndexException;
import br.com.bank.domain.bank.Bank;
import br.com.bank.domain.bank.account.Account;
import br.com.bank.domain.bank.account.Client;
import br.com.bank.domain.bank.account.exception.AccountException;
import br.com.bank.domain.machine.ATM;
import br.com.bank.domain.machine.Money;
import br.com.bank.io.ApplicationPrinter;
import br.com.bank.io.ApplicationReader;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rafael on 30/08/17.
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        final ATM atm = initializeATM();
        while(true) {
            UserToken userToken = null;
            try {
                userToken = login(atm);
            } catch (final ApplicationEndedException e) {
                break;
            } catch (final AccountException e) {
                continue;
            }

            while(userToken.isLogged()) {
                ApplicationPrinter.printApplicationMainScreen(userToken.getName(), atm.getMenuOptions());
                final Integer selectedOption = ApplicationReader.readInteger();
                try {
                    atm.execute(selectedOption, userToken);
                } catch (IllegalMenuIndexException e) {
                    ApplicationPrinter.printInvalidOption();
                    continue;
                }
            }

            ApplicationPrinter.printUserLogout();
        }
    }

    private static UserToken login(final ATM atm) throws ApplicationEndedException, AccountException {
        ApplicationPrinter.printLoginDisclaimer();
        final String accountId = ApplicationReader.readString();
        checkIfApplicationEnded(accountId);

        try {
            return atm.login(accountId);
        } catch (AccountException e) {
            ApplicationPrinter.printLoginFailed(accountId);
            throw e;
        }
    }

    private static void checkIfApplicationEnded(String accountId) throws ApplicationEndedException {
        if (accountId.equalsIgnoreCase("Exit")) {
            ApplicationPrinter.printApplicationEnding();
            throw new ApplicationEndedException();
        }
    }

    private static ATM initializeATM() {
        final Client client1 = new Client("João da Silva");
        final Client client2 = new Client("Pedro Otávio Magalhães");
        final Client client3 = new Client("Maria Green");
        final Client client4 = new Client("Stephan Pereira");

        final List<Account> accountList = new LinkedList<>();
        accountList.add(new Account(client1, "54125-9", BigDecimal.valueOf(10854.78)));
        accountList.add(new Account(client2, "25214-8", BigDecimal.valueOf(1050.99)));
        accountList.add(new Account(client3, "88452-1", BigDecimal.valueOf(7696.00)));
        accountList.add(new Account(client4, "15935-7", BigDecimal.valueOf(412.13)));

        final Bank bank = new Bank(accountList);
        final Money money = new Money(5, 5, 2, 1);

        return new ATM(bank, money);
    }

}
