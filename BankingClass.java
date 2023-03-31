import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankingClass {
    private List<Customer> customers;

    public BankingClass() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void removeCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getID().equals(customerId)) {
                customers.remove(customer);
                break;
            }
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getID().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public CheckingAccount createCheckingAccount(Customer customer, BigDecimal balance, BigDecimal overDraftLimit) {
        String id = "CHK" + System.currentTimeMillis();
        CheckingAccount account = new CheckingAccount(id, balance, overDraftLimit);
        customer.addAccount(account);
        return account;
    }

    public SavingAccount createSavingAccount(Customer customer, BigDecimal balance, BigDecimal interestRate) {
        String id = "SAV" + System.currentTimeMillis();
        SavingAccount account = new SavingAccount(id, balance, interestRate);
        customer.addAccount(account);
        return account;
    }
}
