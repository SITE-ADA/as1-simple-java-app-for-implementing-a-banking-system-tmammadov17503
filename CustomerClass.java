import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerClass {
    private String ID;
    private String fullName;
    private List<Account> accounts; // customer can have many accounts that's why we create this 

    public CustomerClass(String ID, String fullName) {
        this.ID = ID;
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    } // constructor Customer with ID and fullName 

    public String getID() {
        return ID;
    } // getID

    public String getFullName() {
        return fullName;
    } // getFullName

    public void setID(String ID) {
        this.ID = ID;
    } // setID

    public void setFullName(String fullName) {
        this.fullName = fullName;
    } // setFullName

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    } // setAccounts

    public void addAccount(Account account) {
        accounts.add(account);
    } // addAccount

    public void removeAccount(Account account) {
        if (!accounts.contains(account)) {
            throw new IllegalArgumentException("Customer account was not found"); 
        }
        accounts.remove(account);
    } // remove account by throwing the exception 

    public void removeAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getID().equals(accountId)) { 
                accounts.remove(account);
                break; 
            }
        }
    } // removes the account with the specified ID from the customer's list of accounts

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account account : accounts) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    } // the total balance of the account is returned 

    public List<Account> getAccounts(String type) {
        List<Account> filteredAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (type.equals("checking") && account instanceof CheckingAccount) {
                filteredAccounts.add(account);
            } else if (type.equals("saving") && account instanceof SavingAccount) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
}
} // returns the list of accounts for customers based on the type: checking or saving
