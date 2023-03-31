import java.math.BigDecimal;

public class CheckingAccount extends Account{
    private BigDecimal overDraftLimit;

    public CheckingAccount(String ID, BigDecimal balance, BigDecimal overDraftLimit) {
        super(ID, balance);
        this.overDraftLimit = overDraftLimit;
    } // constructor with new value - overDraftLimit 

    public BigDecimal getOverDraftLimit() {
        return overDraftLimit;
    } // getOverDraftLimit

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(getBalance().add(overDraftLimit)) > 0) { // limit to get money amount 
            throw new IllegalArgumentException("Value that you want to withdraw must be greater than zero and at the same time not exceed the limit"); // exception message will appear because of the limit
        }

        BigDecimal newBalance = getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) { // we can not have a negative amount here
            overDraftLimit = overDraftLimit.add(newBalance);
            newBalance = BigDecimal.ZERO;
        }
        super.balance = newBalance; // updating the parent class 
    }
}

