import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerClass {
    private String ID;
    private String fullName;
    private List<Account> accounts; // customer can have many accounts thats why we create this 

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
            throw new IllegalArgumentException("Customer account was not found"); // removeAccount using the exception 
        }
        accounts.remove(account);
    } 

    public void removeAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getID().equals(accountId)) { 
                accounts.remove(account);
                break; 
            }
        }
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account account : accounts) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    }

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
}
