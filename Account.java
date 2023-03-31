import java.math.BigDecimal;

public abstract class Account {
    String ID;
    BigDecimal balance = BigDecimal.ZERO;

    public Account(String ID, BigDecimal balance ){
        this.ID = ID;
        this.balance = balance;
    } // constructor with ID and balance

    public BigDecimal getBalance() {
        return balance;
    } // getBalance

    public String getID() {
        return ID;
    } // getID
    
    public void deposit(BigDecimal amount) {
            if (amount.compareTo(new BigDecimal("0")) > 0) //  we have to have not a negative one
            balance = balance.add(amount); 
            else throw new IllegalArgumentException("Deposit is equal to 0 or negative, please change the value"); // exception thrown
    }
    public abstract void withdraw(BigDecimal amount); // withdraw the money amount
}







