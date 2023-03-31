import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankingClass {
    private List<CustomerClass> customers;

    public BankingClass() {
        this.customers = new ArrayList<>();
    } // List

    public void addCustomer(CustomerClass customer) {
        customers.add(customer);
    } // addCustomer

    public void removeCustomer(CustomerClass customer) {
        customers.remove(customer);
    } // removeCustomer

    public List<CustomerClass> getCustomers() {
        return customers;
    } // returns the bank's list of customers

    public void removeCustomer(String customerId) {
        for (CustomerClass customer : customers) {
            if (customer.getID().equals(customerId)) {
                customers.remove(customer);
                break;
            }
        }
    } // removes the customer with the specified ID from the bank's list of customers

    public CustomerClass getCustomer(String customerId) {
        for (CustomerClass customer : customers) {
            if (customer.getID().equals(customerId)) {
                return customer;
            }
        }
        return null;
    } // returns the customer with the specified ID from the bank's list of customers

    public CheckingAccount createCheckingAccount(CustomerClass customer, BigDecimal balance, BigDecimal overDraftLimit) {
        String id = "CHK" + System.currentTimeMillis();
        CheckingAccount account = new CheckingAccount(id, balance, overDraftLimit);
        customer.addAccount(account);
        return account;
    } // creates a new checking account for the specified customer with the specified initial balance and overdraft limit

    public SavingAccount createSavingAccount(CustomerClass customer, BigDecimal balance, BigDecimal interestRate) {
        String id = "SAV" + System.currentTimeMillis();
        SavingAccount account = new SavingAccount(id, balance, interestRate);
        customer.addAccount(account);
        return account;
    }
} // creates a new savings account for the specified customer with the specified initial balance and interest rate
