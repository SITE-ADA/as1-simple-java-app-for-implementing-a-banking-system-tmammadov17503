import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankingClass {
    private List<CustomerClass> customers;

    public BankingClass() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(CustomerClass customer) {
        customers.add(customer);
    }

    public void removeCustomer(CustomerClass customer) {
        customers.remove(customer);
    }

    public void removeCustomer(String customerId) {
        for (CustomerClass customer : customers) {
            if (customer.getID().equals(customerId)) {
                customers.remove(customer);
                break;
            }
        }
    }

    public List<CustomerClass> getCustomers() {
        return customers;
    }

    public CustomerClass getCustomer(String customerId) {
        for (CustomerClass customer : customers) {
            if (customer.getID().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public CheckingAccount createCheckingAccount(CustomerClass customer, BigDecimal balance, BigDecimal overDraftLimit) {
        String id = "CHK" + System.currentTimeMillis();
        CheckingAccount account = new CheckingAccount(id, balance, overDraftLimit);
        customer.addAccount(account);
        return account;
    }

    public SavingAccount createSavingAccount(CustomerClass customer, BigDecimal balance, BigDecimal interestRate) {
        String id = "SAV" + System.currentTimeMillis();
        SavingAccount account = new SavingAccount(id, balance, interestRate);
        customer.addAccount(account);
        return account;
    }
}
