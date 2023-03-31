import java.math.BigDecimal;
public class BankingDemo {
    public static void main(String[] args) {
        Banking KapitalBank = new Banking(); // Creation of a new bank 

        KapitalBank.addCustomer(new Customer("9273", "New Customer")); // new customer

        System.out.println("Newly created account: "+ KapitalBank.getCustomer("9273")); // it would give the name in form of hash code
        
        Customer Tom = new Customer("7465", "Tom Smith");
        Customer Ann = new Customer("6384", "Ann Smith"); // creating of two new customers Tom and Ann

        KapitalBank.addCustomer(Tom);
        KapitalBank.addCustomer(Ann); // Adding the two new customers Checking

        CheckingAccount TomChecking = KapitalBank.createCheckingAccount(Tom, new BigDecimal("1000"), new BigDecimal("500"));
        SavingAccount TomSaving = KapitalBank.createSavingAccount(Tom, new BigDecimal("5000"), new BigDecimal("0.1")); // creating an account for the customer - Tom
        
        CheckingAccount AnnChecking = KapitalBank.createCheckingAccount(Ann, new BigDecimal("2000"), new BigDecimal("1000"));
        SavingAccount AnnSaving = KapitalBank.createSavingAccount(Ann, new BigDecimal("6660"), new BigDecimal("1")); // creating an account for the customer - Ann

        Tom.addAccount(new SavingAccount(new BigDecimal("333"), new BigDecimal("0.1")));
        Ann.addAccount(new SavingAccount(new BigDecimal("333"), new BigDecimal("0.1"))); // now adding the accounts for the customer - Ann and Tom

        TomChecking.deposit(new BigDecimal("100")); 
        TomChecking.withdraw(new BigDecimal("200")); 
        TomSaving.deposit(new BigDecimal("1000")); 
        TomSaving.withdraw(new BigDecimal("2000")); 
        AnnChecking.deposit(new BigDecimal("500")); // Deposit and withdraw the amount of setted money without exceptions accurence
        
        try{
            AnnChecking.withdraw(new BigDecimal("5000"));}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } // IllegalArgumentException exception is thrown
    
        try{
            TomChecking.deposit(new BigDecimal("-100"));}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } // IllegalArgumentException exception is thrown
    
        System.out.println("The customers of KapitalBank are here");
        for (Customer c : KapitalBank.getCustomers()) {
            System.out.println(c.getFullName());
        }

        System.out.println(Tom.getFullName() + " checking account balance: " + TomChecking.getBalance()); 
        System.out.println(Tom.getFullName() + " savings account balance: " + TomSaving.getBalance()); 
        System.out.println(Ann.getFullName() + " checking account balance: " + AnnChecking.getBalance());
        System.out.println(Ann.getFullName() + " savings account balance: " + AnnSaving.getBalance()); // Printing the balances of the accounts

        System.out.println(Tom.getFullName() + " total balance: " + Tom.getTotalBalance()); 
        System.out.println(Ann.getFullName() + " total balance: " + Ann.getTotalBalance()); // The customer's total balance is given here
        
        System.out.println(Tom.getFullName() + " checking accounts: " + Tom.getAccounts("checking"));
        System.out.println(Tom.getFullName() + " saving accounts: " + Tom.getAccounts("saving"));
        System.out.println(Ann.getFullName() + " checking accounts: " + Ann.getAccounts("checking"));
        System.out.println(Ann.getFullName() + " saving accounts: " + Ann.getAccounts("saving")); // The needs of the customers

        Tom.removeAccount(TomSaving);
        System.out.println(Tom.getFullName() + " accounts after removing savings account: " + Tom.getAccounts("saving")); // Deletion of the saving account from the customer that is shown
        
        try{
            KapitalBank.removeCustomer(Ann);}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        System.out.println("Bank's customers after removing: " + KapitalBank.getCustomers()); // Just Remove a customer from the bank and the end
}
}
