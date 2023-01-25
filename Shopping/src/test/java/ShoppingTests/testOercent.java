package ShoppingTests;

import java.util.InputMismatchException;
import java.util.Scanner;

public class testOercent {
    private static Scanner keyboard = new Scanner(System.in);
    private static double number = 0;
 
    private static double amount()
    {
       boolean complete =true;
       while (complete)
       {
          System.out.println("Please enter the amount");
 
          try
          {
             number = keyboard.nextDouble();
             complete = false;
          }//try
 
          catch(InputMismatchException IME)
          {
             System.out.println("Whoops, you didn't enter a number.");
             keyboard.next();
 
          }//catch
 
       }//while
 
        //returning the value
        return number;
    }//amount
 
    private static void calculations()
    {
        double taxTotal, total;
 
        //Calculation
        taxTotal = number*0.20%100;
 
        total = number + taxTotal;
 
        System.out.println("The total tax to be added is £" + taxTotal);
        System.out.println(" ");
        System.out.println("The total with tax will be £" + total);
        System.out.println(" ");
    }//calculations()
 
    public static void main(String[] args)
    {
 
        int runAgain;
 
        System.out.println("Welcome to the UK tax calculator!");
 
        do
        {
            //calling methods
            amount();
            calculations();
 
            //Prompt to see if user would like to run again
            System.out.println("Would you like to run the program again?");
            System.out.println("Enter 1 for Yes");
            System.out.println("Enter 2 for No");
            runAgain = keyboard.nextInt();
        }//do
 
        while (runAgain!=2);
    }//main
}//class


