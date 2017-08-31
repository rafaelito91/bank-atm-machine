package br.com.bank.domain.machine;

import java.math.BigDecimal;

/**
 * Class comments go here...
 *
 * @author focus
 * @version 1.0 31/08/2017
 */
public enum BallotType {

    ONE_HUNDRED(BigDecimal.valueOf(100)), FIFTY(BigDecimal.valueOf(50)), TWENTY(BigDecimal.valueOf(20)), TEN(BigDecimal.valueOf(10));

    private BigDecimal value;

    BallotType(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
