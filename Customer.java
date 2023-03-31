import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String fullName;
    private List<Account> accounts; // a customer can have many accounts, so we create a list to store them 

    public Customer(String customerId, String fullName) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    } // constructor for a customer with a specified ID and name 

    public String getCustomerId() {
        return customerId;
    } // get the customer ID

    public String getFullName() {
        return fullName;
    } // get the customer name

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    } // set the customer ID

    public void setCustomerName(String fullName) {
        this.fullName = fullName;
    } // set the customer name

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    } // set the customer's list of accounts

    public void addAccount(Account account) {
        accounts.add(account);
    } // add an account to the customer's list of accounts

    public void removeAccount(Account account) {
        if (!accounts.contains(account)) {
            throw new IllegalArgumentException("Account not found for this customer"); 
        }
        accounts.remove(account);
    } // remove an account from the customer's list of accounts, throwing an exception if it's not found

    public void removeAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getID().equals(accountId)) {
                accounts.remove(account);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found for this customer");
    } // remove an account with the specified ID from the customer's list of accounts, throwing an exception if it's not found

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account account : accounts) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    } // get the total balance across all of the customer's accounts

    public List<Account> getAccounts(String accountType) {
        List<Account> res = new ArrayList<>();
        for (Account account : accounts) {
            if (accountType.equals("checking") && account instanceof CheckingAccount) {
                res.add(account);
            } else if (accountType.equals("saving") && account instanceof SavingAccount) {
                res.add(account);
            }
        }
        return res;
    } // get a list of the customer's accounts of a specified type
} // returns the list of accounts for customers based on the type: checking or saving
