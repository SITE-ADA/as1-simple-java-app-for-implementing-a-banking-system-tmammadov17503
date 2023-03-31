import java.math.BigDecimal;

public class SavingAccount extends Account {
    BigDecimal interestRate;

    public SavingAccount(String ID, BigDecimal balance, BigDecimal interestRate){
        super(ID, balance);
        this.interestRate = interestRate;
    } // constructor with a new value - interest rate 

    public BigDecimal getInterestRate() {
        return interestRate;
    } // getInterestRate 

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(getBalance()) > 0) { // look if it positive because we can not have negative
            throw new IllegalArgumentException("The value that you are trying to withdraw exceeds the amount that you have on your balance"); // exception thrown because the amount that we need to withdraw is greater that the balance
        }
        setBalance(getBalance().subtract(amount)); // setting the balance by subtracting the amount
    }

    private void setBalance(BigDecimal newBalance) {
        super.balance = newBalance; // set the new balance 
    }
}
