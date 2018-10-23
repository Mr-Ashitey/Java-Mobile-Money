import java.util.Scanner;

public class Intro {
    Scanner sc = new Scanner(System.in);

    //variables to store pin
    private int scpin , confirmPin;
    private double balance;
    private double previousTransaction;
    private boolean sent = false;

    //a constructor to receive the input pin
    Intro(int scpin){
        this.scpin = scpin;
    }

   //deposit method
   void deposit(double amount){
        if(amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
        }

    //withdraw method
    void withdraw(double amount){
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //method for previous transaction
    void getPreviousTransaction(){
    if(sent == true){
        System.out.println("Sent: Ghc "+ previousTransaction);
    }
    else if(previousTransaction > 0){
        System.out.println("Deposited: Ghc "+ previousTransaction);
    }
    else if(previousTransaction < 0){
        System.out.println("Withdrawn: Ghc " + Math.abs(previousTransaction));
    }else System.out.println("No transaction occured");
    }

    //a message to display after all check is done
    public void msg() {
        System.out.println("Welcome To AirtelTigo Money\n");
        System.out.println("1. Send Cash(To all networks)");
        System.out.println("2.Buy Products");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Withdraw Cash");
        System.out.println("5. Balance");
        System.out.println("6. Previous Transaction");
        System.out.println("7. Approve");
        System.out.println("0. Exit");
        int input = sc.nextInt();

        //a switch statement to work on any chosen option
        switch (input) {
        case 1:
        System.out.println("Please Select");
        System.out.println("1. To AirtelTigo Number");
        System.out.println("2. To Other networks");
        int input2 = sc.nextInt();
            if(input2 == 1){
                System.out.println("Enter Mobile Number");
                int number = sc.nextInt();
                System.out.println("Enter Amount");
                double amount = sc.nextDouble();
                System.out.println("To confirm sending Ghc" + amount + " to phone number 0" + number + " enter your secret pin");
                confirmPin = sc.nextInt();
                //check if the user pin is the same as the pin used to create account
                if (confirmPin == scpin ) {
                    if (balance >= amount){
                    System.out.println("You sent Ghc " + amount + " to 0" + number);
                    balance -= amount;
                    previousTransaction = amount;
                    sent = true;
                    System.out.println("Current balance = "+balance+"\n");
                    msg();}else
                    System.out.println("\nYour balance is not sufficient for this transaction");
                    System.out.println("Current balance = "+balance+"\n");
                    msg();
                    } else {
                        System.out.println("Incorrect Pin \n Please restart the app\n");
                        msg();
                    }
            }else if(input2 == 2){
                System.out.println("The mobile money interoperability is still under work\n");
                msg();
            }else  System.out.println("Invalid input");msg();
        break;
        case 2:
        System.out.println("\nProducts would be uploaded soon");
        msg();
        break;
        case 3:
                System.out.println("------------------------------");
                System.out.println("Enter an amount to deposit ");
                System.out.println("------------------------------");
                double amount = sc.nextDouble();
                do{
                System.out.println("\nPlease enter your secret pin to confirm deposit of Ghc"+amount);
                confirmPin = sc.nextInt();
                //check if the user pin is the same as the pin used to create account
                if (confirmPin == scpin ) {
                    deposit(amount);
                    System.out.println("Deposited amount = "+ amount);
                    System.out.println("Current balance = "+balance);
                    System.out.println("\n");
                    }else System.out.println("Incorrect Pin");
                }while(confirmPin != scpin);
                    msg();
                break;
        case 4:
        if(balance <= 0){
                System.out.println("*********************************");
                System.out.println("Sorry your account is empty");
                System.out.println("*********************************");
                msg();
            }else{
            System.out.println("------------------------------");
            System.out.println("Enter an amount to withdraw");
            System.out.println("------------------------------");
            double amount2 = sc.nextDouble();
            do{
            System.out.println("\nPlease enter your secret pin to confirm withdrawal of Ghc"+amount2);
            confirmPin = sc.nextInt();
            //check if the user pin is the same as the pin used to create account
            if (confirmPin == scpin ) {
            if (amount2 > balance){
                System.out.println("You cannot witdraw more than your balance");
                System.out.println("Current balance = "+balance);
            }else{
            withdraw(amount2);
            System.out.println("Withdrawn amount = "+ amount2);
            System.out.println("Current balance = "+balance);
            System.out.println("\n");
            }
        }
      }while(confirmPin != scpin);
    }
        msg();
        break;
        case 5:
        System.out.println("------------------------------");
        System.out.println("Current Balance = "+balance);
        System.out.println("------------------------------");
        System.out.println("\n");msg();
        break;
        case 6:
        System.out.println("------------------------------");
        getPreviousTransaction();
        System.out.println("------------------------------");
        System.out.println("\n");msg();
        break;
        case 0:
        System.out.println("\nThank you for using AirtelTigo");
        break;
        default:
            System.out.println("Wrong Input try again");
            msg();
        }
    }
}