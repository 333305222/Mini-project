import java.util.*;
import java.util.regex.*;

class Account{
  
  private String name;
  private String accountNumber;
  private String password;
  private String contact;
  private double balance; 
 
  private List<String> transactions = new ArrayList<>();
  
public Account(String name,String accountNumber,String password,String contact,double initialDeposit){
   
   this.name = name;
   this.accountNumber = accountNumber;
   this.password = password;
   this.contact = contact;
   this.balance = initialDeposit;

   transactions.add("Account created with initial deposit: "+ initialDeposit);

  }

public String getAccountNumber(){
   
  return accountNumber;

  }

public boolean authentication(String pass){
   
  return password.equals(pass);

  }

public void updateDetails(String name,String contact){
    
    this.name = name;
    this.contact = contact;
    transactions.add("Details updated successfully!");

  }

public void Deposit(double amount){
   
    if(amount <= 0){
      System.out.println("Invalid deposit amount!");
      return;
    }

    balance += amount;
    transactions.add("Deposited: " + amount + "| Balance: " + balance);
    System.out.println("Deposit successful! new Balance: " + balance);

  }

public void Withdraw(double amount){
    
    if(amount <= 0){
      System.out.println("Invalid withdraw amount!");
      return;
    }

    if(amount > balance){
      System.out.println("Insufficient funds!");
      return;
    }

    balance -= amount;

    transactions.add("Withdraw: " + amount + " | Balance:" + balance);
    System.out.println("withdraw successfull! New Balance: " + balance);

    }

  public void Transfer(Account receiver,double amount){
      
      if(amount <= 0){
        System.out.println("Invalid transfer amount!");
        return;
      }

      if(amount > balance){
        System.out.println("Insufficient transfer money!");
        return;
      }

      this.balance -= amount;
      receiver.balance += amount;

      this.transactions.add("Transferred " + amount + " to " + receiver.accountNumber + " | Balance: " + balance);
      receiver.transactions.add("Received " + amount + " from " + this.accountNumber + "| Balance: " + receiver.balance);

      System.out.println("Transacton Successfull!");

    }

  public void showStatement(){
      
      System.out.println("\n----Account Statement----" );
      System.out.println("Name : " + name);
      System.out.println("Account Number : " + accountNumber);
      System.out.println("Contact : " + contact);
      System.out.println("Balance : " + balance);
      System.out.println("Transactions :");
      
      for(String t : transactions){
        System.out.println("-"+ t);
      }

    }

}

public class BankingSystem {

    private static Scanner sc = new Scanner(System.in);
    private static Map <String,Account> accounts = new HashMap<>();
 public static void main(String[] args) {
    
    while(true){

      System.out.println(" \n ===== Banking System =====\n");
      System.out.println("1.Register");
      System.out.println("2.Login");
      System.out.println("3.exit");
      System.out.println("Choose your option: ");
    
      
      int choice = sc.nextInt();
      sc.nextLine();
      
      
      switch (choice) {
        case 1 : Register();
         break;
        case 2 : Login();
         break;
        case 3 : System.out.println("Thanks for visiting!");
         System.out.println("Good bye!");
         return;
        default : 
           System.out.println("Invalid choice"); 
      
       } 
     }  
  }        
    
private static void Register(){

    System.out.println("Enter your name:");
    String name = sc.nextLine();

    if(!checkName(name)){
       System.out.println("Enter valid name!");
       return;
    }

    System.out.println("Enter your bank account number:");
    String accNo = sc.nextLine();

    if(!checkAccNo(accNo)){
       System.out.println("Enter valid account number!");
       return;
    }
    
    if(accounts.containsKey(accNo)){
        System.out.println("Account already exists!");
        return;
    }

    System.out.println("Set password: ");
    String pass = sc.nextLine();
 
    if(!checkPassword(pass)){
       System.out.println("Enter valid password!");
       return;
    }

    System.out.println("Enter your contact number:");
    String contact = sc.nextLine();

     if(!checkContact(contact)){
       System.out.println("Enter valid contact number!");
       return;
    }

    System.out.println("Enter initial deposit:");
    Double deposit = sc.nextDouble();
   
    if(deposit >= 1000){
    Account acc = new Account(name,accNo,pass,contact,deposit);
     accounts.put(accNo,acc);
    }
    else{
      System.out.println("Enter valid initial deposit!");
    }
    
   System.out.println("Registration completed Succesfully!");

  }

private static void Login(){

    System.out.println("Enter account number:");
    String accNo = sc.nextLine();

    if(!checkAccNo(accNo)){
       System.out.println("Enter valid account number!");
       return;
    }

    if(!accounts.containsKey(accNo)){
        System.out.println("Account doesn't exists!");
        return;
    }

    System.out.println("Enter password: ");
    String pass = sc.nextLine();

    if(!checkPassword(pass)){
       System.out.println("Enter valid password!");
       return;
    }

    Account acc = accounts.get(accNo);
    
    if(!acc.authentication(pass)){
      System.out.println("Wrong password:");
      return;
    }

    System.out.println("Login successful!");
   
    showAccountMenu(acc);

  }
    
private static void showAccountMenu(Account acc){

    while(true){

        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Transfer");
        System.out.println("4.Update details");
        System.out.println("5.View Statement");
        System.out.println("6.Logout");

        System.out.println("Choose your option: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
          
          case 1 : System.out.println("Enter amount:");
          acc.Deposit(sc.nextDouble());
          sc.nextLine();
          break;
          
          case 2 : System.out.println("Enter amount:");
          acc.Withdraw(sc.nextDouble());
          sc.nextLine();
          break;
          
          case 3 : System.out.println("Enter recipient account number:");
          String toAcc = sc.nextLine();
          if(!accounts.containsKey(toAcc)){
            System.out.println("Recipient account not found!");
            break;
          }
          System.out.println("Enter amount: ");
          double amt = sc.nextDouble();
          sc.nextLine();
          acc.Transfer(accounts.get(toAcc),amt);
          break;
          
          case 4 : System.out.println("Enter new name: ");
          String name = sc.nextLine();
          
          if(!checkName(name)){
          System.out.println("Enter valid name!");
          return;
          }

          System.out.println("Enter new contact: ");
          String contact = sc.nextLine();

          if(!checkContact(contact)){
          System.out.println("Enter valid contact number!");
          return;
          }

          acc.updateDetails(name,contact);
          System.out.println("Details updated!");
          break;
          
          case 5 : acc.showStatement();
          break;
          
          case 6 : return;
          
          default:
           System.out.println("Invalid choice!");
        }
      }
   }

   public static boolean checkName(String name){
    
    String regex = "^[A-Za-z\\s-]{2,50}$";
    
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(name);
   
    if(matcher.matches())
     return true;
    else
     return false;

  }

  public static boolean checkAccNo(String accNo){
     
    String regex = "^\\d{10,12}$";
    
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(accNo);
   
    if(matcher.matches())
     return true;
    else
     return false;

  }

   public static boolean checkPassword(String pass){
     
    String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).*{8,}$";
    
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(pass);
   
    if(matcher.matches())
     return true;
    else
     return false;

  }

   public static boolean checkContact(String contact){
     
    String regex = "^[6-9]\\d{9}$";
    
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(contact);
   
    if(matcher.matches())
     return true;
    else
     return false;

  }

}  
          
        



    
  
      
    
    
    
    
