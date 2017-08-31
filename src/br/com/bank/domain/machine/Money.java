package br.com.bank.domain.machine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>Money</code> is a value object that stores the quantity of money ballots a certain <code>ATM</code> has.
 */
public class Money {

    private final Map<BallotType, BigDecimal> ballotQuantity = new HashMap<>();

    public Money(Integer oneHundredReaisBallotQuantity, Integer fiftyReaisBallotQuantity, Integer twentyReaisBallotQuantity, Integer tenReaisBallotQuantity) {
        ballotQuantity.put(BallotType.ONE_HUNDRED, BigDecimal.valueOf(oneHundredReaisBallotQuantity));
        ballotQuantity.put(BallotType.FIFTY, BigDecimal.valueOf(fiftyReaisBallotQuantity));
        ballotQuantity.put(BallotType.TWENTY, BigDecimal.valueOf(twentyReaisBallotQuantity));
        ballotQuantity.put(BallotType.TEN, BigDecimal.valueOf(tenReaisBallotQuantity));
    }

    public BigDecimal getTotal() {
        final BigDecimal total = new BigDecimal(0);
        for (final BallotType type : ballotQuantity.keySet()) {
            total.add(getSumOfBallotType(type));
        }
        return total;
    }

    public void subtract(final BigDecimal) {

    }

    public Map<BallotType, BigDecimal> getComposition() {

    }

    private BigDecimal getSumOfBallotType(final BallotType type) {
        return ballotQuantity.get(type).multiply(type.getValue());
    }
}
