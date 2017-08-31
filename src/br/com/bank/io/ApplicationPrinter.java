package br.com.bank.io;

import br.com.bank.config.Option;
import br.com.bank.domain.machine.MenuItem;

import java.util.List;

/**
 * Created by rafael on 30/08/17.
 */
public class ApplicationPrinter {

    public static void printLoginDisclaimer() {
        System.out.println("In order to use a account, please type its ID. In order to leave, type \"Exit\"");
    }

    public static void printLoggedUser(final String name) {
        System.out.println("Logged in as: " + name);
    }

    public static void printLoginFailed(final String accountId) {
        System.out.println("Account with id: " + accountId + " not found. System logging out...");
    }

    public static void printApplicationEnding() {
        System.out.println("Application is being finalized....");
        System.out.println("DDD Bank, where your dreams come true and your informations are ");
        System.out.println("encapsulated!");
    }

    public static void printHeader() {
        System.out.println("*********************************************************");
        System.out.println("************** Welcome to DDD Bank ATM ******************");
        System.out.println("*********************************************************");
    }

    public static void printMenu(final String clientName, List<Option> atmOptions) {
        System.out.println(clientName + ", please select one of the options below:");
        for (final MenuItem menuOperation : MenuItem.values()) {
            System.out.println("\tOption: " + menuOperation.getIndex() + " - for " + menuOperation.getOperationName());
        }
        System.out.print("Your option: ");
    }

    public static void printApplicationMainScreen(final String clientName, List<Option> atmOptions) {
        printHeader();
        printMenu(clientName, atmOptions);
    }

    public static void printInvalidMenuItem(final Integer chosenIndex) {
        System.out.println("Sorry, but the chosen menu item index \"" + chosenIndex + "\" is not valid");
    }

    public static void printInvalidOption() {
        System.out.println("Invalid Option, please choose again");
    }

}
