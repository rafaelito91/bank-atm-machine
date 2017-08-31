package br.com.bank.config;

/**
 * Created by rafael on 31/08/17.
 */
public class UserToken {

    private final String clientName;

    private final String clientAccountId;

    private boolean logged;

    public UserToken(final String clientName, final String clientAccountId) {
        this.clientName = clientName;
        this.clientAccountId = clientAccountId;
        this.logged = true;
    }

    public String getName() {
        return clientName;
    }

    public String getId() {
        return clientAccountId;
    }

    public boolean isLogged() {
        return logged;
    }

    public void logout() {
        this.logged = false;
    }
}
