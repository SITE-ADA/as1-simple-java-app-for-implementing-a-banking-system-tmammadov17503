import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banking {
    private List<Customer> customers;

public Banking () {
    this.customers = new ArrayList<>();
} // List

public void addCustomer(Customer customer) {
    customers.add(customer);
} // addCustomer

public void removeCustomer(Customer customer) {
    customers.remove(customer);
} // removeCustomer

public List<Customer> getCustomers() {
    return customers;
} // returns the bank's list of customers

public void removeCustomer(String customerId) {
    for (Customer customer : customers) {
        if (customer.getCustomerId().equals(customerId)) {
            customers.remove(customer);
            break;
        }
    }
} // removes the customer with the specified ID from the bank's list of customers

public Customer getCustomer(String customerId) {
    for (Customer customer : customers) {
        if (customer.getCustomerId().equals(customerId)) {
            return customer;
        }
    }
    return null;
} // returns the customer with the specified ID from the bank's list of customers

public CheckingAccount createCheckingAccount(Customer customer, BigDecimal balance, BigDecimal overdraftLimit) {
    CheckingAccount account = new CheckingAccount(balance, overdraftLimit);
    customer.addAccount(account);
    return account;
} // creates a new checking account for the specified customer with the specified initial balance and overdraft limit

public SavingAccount createSavingAccount(Customer customer, BigDecimal balance, BigDecimal interestRate) {
    SavingAccount account = new SavingAccount(balance, interestRate);
    customer.addAccount(account);
    return account;
} // creates a new savings account for the specified customer with the specified initial balance and interest rate
}
