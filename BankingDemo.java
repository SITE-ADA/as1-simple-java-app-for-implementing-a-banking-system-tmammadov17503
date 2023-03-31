import java.math.BigDecimal;

public class BankingDemo {

    public static void main(String[] args) {
        Banking kapitalBank = new Banking(); // Creation of a new bank 

        Customer c = new Customer("New Customer of Kapital Bank"); // new customer
        kapitalBank.addCustomer(c); // new customer
        
        System.out.println("Newly created account: " + kapitalBank.getCustomer(c.getCustomerId()).getFullName()); // print customer name
        
        Customer tom = new Customer("Tom Smith");
        Customer ann = new Customer("Ann Smith"); // creating of two new customers Tom and Ann

        kapitalBank.addCustomer(tom);
        kapitalBank.addCustomer(ann); // Adding the two new customers Checking

        CheckingAccount tomChecking = kapitalBank.createCheckingAccount(tom, new BigDecimal("6000"), new BigDecimal("700"));
        SavingAccount tomSaving = kapitalBank.createSavingAccount(tom, new BigDecimal("8500"), new BigDecimal("70")); // creating an account for the customer - Tom
        
        CheckingAccount annChecking = kapitalBank.createCheckingAccount(ann, new BigDecimal("4000"), new BigDecimal("1250"));
        SavingAccount annSaving = kapitalBank.createSavingAccount(ann, new BigDecimal("4500"), new BigDecimal("8")); // creating an account for the customer - Ann

        tom.addAccount(new SavingAccount(new BigDecimal("647"), new BigDecimal("4")));
        ann.addAccount(new SavingAccount(new BigDecimal("836"), new BigDecimal("6"))); // now adding the accounts for the customer - Ann and Tom

        tomChecking.deposit(new BigDecimal("175")); 
        tomChecking.withdraw(new BigDecimal("750")); 
        tomSaving.deposit(new BigDecimal("1750")); 
        tomSaving.withdraw(new BigDecimal("3450")); 
        annChecking.deposit(new BigDecimal("900")); // Deposit and withdraw the amount of setted money without exceptions occurrence
        
        try{
            annChecking.withdraw(new BigDecimal("4000"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } // IllegalArgumentException exception is thrown
    
        try{
            tomChecking.deposit(new BigDecimal("-560"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } // IllegalArgumentException exception is thrown
    
        System.out.println("The customers of KapitalBank are here:");
        for (Customer customer : kapitalBank.getCustomers()) {
            System.out.println(customer.getFullName());
        } // Customers of KapitalBank are here

        System.out.println(tom.getFullName() + " checking the balance of account: " + tomChecking.getBalance()); 
        System.out.println(tom.getFullName() + " savings of the balance on the account: " + tomSaving.getBalance()); 
        System.out.println(ann.getFullName() + " checking the balance of account: " + annChecking.getBalance());
        System.out.println(ann.getFullName() + " savings of the balance on the account: " + annSaving.getBalance()); // Printing the balances of the accounts

        System.out.println(tom.getFullName() + " total balance: " + tom.getTotalBalance()); 
        System.out.println(ann.getFullName() + " total balance: " + ann.getTotalBalance()); // The customer's total balance is given here
        
        System.out.println(tom.getFullName() + " checking accounts: " + tom.getAccounts("checking"));
        System.out.println(tom.getFullName() + " saving accounts: " + tom.getAccounts("saving"));
        System.out.println(ann.getFullName() + " checking accounts: " + ann.getAccounts("checking"));
        System.out.println(ann.getFullName() + " saving accounts: " + ann.getAccounts("saving"));  // The needs of the customers

        tom.removeAccount(tomSaving);
        System.out.println(tom.getFullName() + " accounts result after deleting savings account: " + tom.getAccounts("saving")); // Deletion of the saving account from the customer that is shown
        
        try{
            kapitalBank.removeCustomer(ann);}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        System.out.println("Bank's customers after removal: " + kapitalBank.getCustomers()); // Just Remove a customer from the bank and the end
}
}
