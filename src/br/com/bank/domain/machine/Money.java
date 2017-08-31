package br.com.bank.domain.machine;

/**
 * <code>Money</code> is a value object that stores the quantity of money ballots a certain <code>ATM</code> has.
 */
public class Money {

    private final Integer oneHundredReaisBallotQuantity;

    private final Integer fiftyReaisBallotQuantity;

    private final Integer twentyReaisBallotQuantity;

    private final Integer tenReaisBallotQuantity;

    public Money(Integer oneHundredReaisBallotQuantity, Integer fiftyReaisBallotQuantity, Integer twentyReaisBallotQuantity, Integer tenReaisBallotQuantity) {
        this.oneHundredReaisBallotQuantity = oneHundredReaisBallotQuantity;
        this.fiftyReaisBallotQuantity = fiftyReaisBallotQuantity;
        this.twentyReaisBallotQuantity = twentyReaisBallotQuantity;
        this.tenReaisBallotQuantity = tenReaisBallotQuantity;
    }
}
