package br.com.bank.domain.bank.account;

/**
 * Created by rafael on 30/08/17.
 */
public class Client {

    private final String name;

    public Client(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
