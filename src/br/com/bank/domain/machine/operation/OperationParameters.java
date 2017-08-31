package br.com.bank.domain.machine.operation;

import br.com.bank.config.UserToken;

import java.math.BigDecimal;

/**
 * Class comments go here...
 *
 * @author focus
 * @version 1.0 31/08/2017
 */
public class OperationParameters {

    private final UserToken origin;

    private final UserToken destination;

    private final BigDecimal value;

    public OperationParameters(final UserToken origin, final UserToken destination, final BigDecimal value) {
        this.origin = origin;
        this.destination = destination;
        this.value = value;
    }

    public UserToken getOrigin() {
        return origin;
    }

    public UserToken getDestination() {
        return destination;
    }

    public BigDecimal getValue() {
        return value;
    }
}
