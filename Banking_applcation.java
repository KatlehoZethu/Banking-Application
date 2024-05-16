package com.mycompany.banking_applcation;

import java.util.ArrayList;
import java.util.Scanner;

public class Banking_applcation {

        static String nameList[] = {"Katleho", "Luna", "Gamba", "Mso"};
        static String passwordList[] = {"Katleho", "Luna", "Gamba", "Mso"};
        static int accNoList[] = {0, 1, 2, 3};
        static double balanceList[] = {7400, 5500, 4543, 4738};
        static String name[] = new String[5];
        static String password[] = new String[5];
        static int accNo[] = new int[5];
        static double balance[] = new double[5];
        static int dec, dec1 = 1, accNumber, accNumber1, x, option;
        static double loginAccNumber, initialBalance, a;
        static String  loginPassword ;
        static String createName, createPassword, confirmPassword, checkPassword;
        
        static void getDetails(){
            Scanner k = new Scanner(System.in);
            
            System.out.println("Would you like to, create an account(1), login(2), or opt out/ sign out(3)");
            dec = k.nextInt();
        }
        
        static void checking(){
            Scanner k = new Scanner(System.in);
            
            while(dec > 0){
                if(dec == 1){
                    System.out.println("Please enter your name");
                    createName = k.next();
                    
                    System.out.println("Please enter a password");
                    createPassword = k.next();
                    
                    System.out.println("Please confirm your password");
                    confirmPassword = k.next();
                    
                    if(createPassword.equals(confirmPassword)){
                        System.out.println("New user created");
                        
                        System.out.println("what is your initial balance?");
                        initialBalance = k.nextDouble();
                                
                        System.out.println("Your account number is 4");
                        
                        accNumber = 0;
                        name[0] = createName;
                        password[0] = createPassword;
                        balance[0] = initialBalance;
                        accNo[0] = accNumber;
                        dec = 0;
                    }else{
                        System.out.println("Passwords do not match please try again");
                        checking();
                    }
                }
                else if (dec == 2){
                    System.out.println("Enter account number");
                    loginAccNumber = k.nextDouble();
                    
                    System.out.println("Enter password");
                    loginPassword = k.next();
                    
                    for(int i=0; i < 5; i++){
                        if(loginAccNumber == accNoList[i] && loginPassword.equals(passwordList[i])){
                            System.out.println("How may we help you?");
                            
                            initialBalance = balanceList[i];
                            balance[0] += initialBalance;
                            dec = 0;
                            i = 5;
                        }else{
                            if(i == 5){
                                System.out.println("We could not find your account");
                                getDetails();
                            }
                        }
                    }
                }
                else if (dec == 3){
                    System.out.println("Thank you for using our banking application");
                    dec = 0;
                }
                else {
                    System.out.println("Invalid input please try again");
                    getDetails();
                }
            }
        }
        
        static void transactions(){
            Scanner k = new Scanner(System.in);
            
            ArrayList<String> history = new ArrayList<>();
                  
            while(dec1 > 0){
                x=0;
                System.out.println("What would you like to do (deposit(1), withdraw(2), check_balance(3), check_history(4), send_money(5), sign_out(6))?");
                option = k.nextInt();
                
                if(option == 1){                    
                    System.out.println("How much would you like to deposit?");
                    a = k.nextDouble();
                    
                    history.add("hello1");
                    
                    balance[accNumber] += a;
                    history.add(x, "Deposited: R" + a);
                    transactions();
                }
                else if(option == 2){
                    System.out.println("How much would you like to withdraw?");
                    a = k.nextDouble();
                    
                    if(balance[accNumber]> a){
                        balance[accNumber] -= a;
                        history.add(x, "Withdrew: R" + a);
                        transactions();
                    }
                    else {
                        System.out.println("insufficient balance please try another amount");
                        transactions();
                    }
                }
                else if (option == 3){
                    System.out.println("current balance R" + balance[accNumber]);
                    transactions();
                }
                else if (option == 6){
                    System.out.println("Thank you for using our banking application");
                    dec1 = 0;
                }
                else if (option == 5){
                    System.out.println("Which account would you like to send money to (0, 1, 2, 3)?");
                    accNumber1 = k.nextInt();
                    
                    System.out.println("Enter your account password to confirm the transaction");
                    checkPassword = k.next();
                    
                    if(checkPassword.equals(password[accNumber])){
                        System.out.println("How much would you like to send?");
                        a = k.nextDouble();
                        
                        if(balance[accNumber] > a){
                            balance[accNumber] -= a;

                            balanceList[accNumber1] += a;

                            history.add(x, "sent: R" +  a + "to " + nameList[accNumber1]);
                            transactions();
                        }
                        else {
                            System.out.println("insufficient balance please try another amount");
                            transactions();
                        }
                    }
                    else {
                        System.out.println("incorrect password, try again");
                        transactions();
                    }
                }
                else if (option == 4){
                    for(String display: history){
                        System.out.println(display);
                    }
                }
                else{
                    System.out.println("Enter a valid option");
                } 
                x++;
            }
        }
        
        public static void main(String[] args) {
            getDetails();
            checking();
            transactions();
        }
    
}
