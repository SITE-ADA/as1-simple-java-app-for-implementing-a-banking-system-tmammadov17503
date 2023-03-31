import java.math.BigDecimal;
public class BankingDemo {
    public static void main(String[] args) {
        BankingClass KapitalBank = new BankingClass(); // Creation of a new bank 

        KapitalBank.addCustomer(new Customer("9273", "New Customer")); // new customer

        System.out.println("Newly created account: "+ KapitalBank.getCustomer("9273")); // it would give the name in form of hash code
        
        Customer Tom = new Customer("7465", "Tom Smith");
        Customer Ann = new Customer("6384", "Ann Smith"); // creating of two new customers Tom and Ann

        KapitalBank.addCustomer(Tom);
        KapitalBank.addCustomer(Ann); // Adding the two new customers Checking

        // Create some accounts for the customers
        CheckingAccount TomChecking = KapitalBank.createCheckingAccount(Tom, new BigDecimal("1000"), new BigDecimal("500"));
        SavingAccount DaddySaving = KapitalBank.createSavingAccount(Tom, new BigDecimal("5000"), new BigDecimal("0.1"));
        
        CheckingAccount MommyChecking = KapitalBank.createCheckingAccount(Ann, new BigDecimal("2000"), new BigDecimal("1000"));
        SavingAccount MommySaving = KapitalBank.createSavingAccount(Ann, new BigDecimal("6660"), new BigDecimal("1"));

        //Add accounts to the customers
        Tom.addAccount(new SavingAccount("145678", new BigDecimal("333"), new BigDecimal("0.1")));


        //Deposit and withdraw some money, without exceptions
        TomChecking.deposit(new BigDecimal("100")); // 1100
        TomChecking.withdraw(new BigDecimal("200")); // 900
        DaddySaving.deposit(new BigDecimal("1000")); // 6000
        DaddySaving.withdraw(new BigDecimal("2000")); // 4000
        MommyChecking.deposit(new BigDecimal("500")); // 2500
        
        //Exception
        try{
            MommyChecking.withdraw(new BigDecimal("5000"));}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
    
            }
    

        
        try{
            TomChecking.deposit(new BigDecimal("-100"));}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
    
            }
        


        System.out.println("The customers of PashaBank:");
        for (Customer c : KapitalBank.getCustomers()) {
            System.out.println(c.getFullName());
        }


        // Print out account balances
        System.out.println(Tom.getFullName() + " checking account balance: " + TomChecking.getBalance()); 
        System.out.println(Tom.getFullName() + " savings account balance: " + DaddySaving.getBalance()); 
        System.out.println(Ann.getFullName() + " checking account balance: " + MommyChecking.getBalance());
        System.out.println(Ann.getFullName() + " savings account balance: " + MommySaving.getBalance());

        // Get customer's total balance
        System.out.println(Tom.getFullName() + " total balance: " + Tom.getTotalBalance()); // 4000 + 900 + 333
        System.out.println(Ann.getFullName() + " total balance: " + Ann.getTotalBalance()); // 0 + 6600

        // Get customer's accounts based on type
        System.out.println(Tom.getFullName() + " checking accounts: " + Tom.getAccounts("checking"));
        System.out.println(Tom.getFullName() + " saving accounts: " + Tom.getAccounts("saving"));
        System.out.println(Ann.getFullName() + " checking accounts: " + Ann.getAccounts("checking"));
        System.out.println(Ann.getFullName() + " saving accounts: " + Ann.getAccounts("saving"));

        //Remove a saving account from a customer
        Tom.removeAccount(DaddySaving);
        System.out.println(Tom.getFullName() + " accounts after removing savings account: " + Tom.getAccounts("saving"));
        //System.out.println(Daddy.getFullName() + " checking accounts: " + Daddy.getAccounts("checking"));
        

        // Remove a customer from the bank
        try{
            KapitalBank.removeCustomer(Ann);}
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        System.out.println("Bank's customers after removing: " + KapitalBank.getCustomers());


        
}

}
