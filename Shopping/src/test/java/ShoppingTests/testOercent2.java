package ShoppingTests;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testOercent2 {
   
	

    public static void main(String[] args) {

        System.out.println("Welcome to the simple VAT Calculator.");
        System.out.println("To Calculate VAT Payable and the ex-VAT Cost type the total cost below:");
        System.out.println("----------");
        Scanner cost = new Scanner (System.in);
        double totalCost = cost.nextDouble();

        cost.close();

        System.out.println("----------");
        double exVat;
        exVat = (totalCost * 0.8);
            DecimalFormat df = new DecimalFormat("0.00");
            String exVatStr = df.format(exVat);
            exVat = Double.valueOf(exVatStr);


        double vat;
        vat = totalCost - exVat;
            DecimalFormat df2 = new DecimalFormat("0.00");
            String vatStr = df2.format(vat);
            vat = Double.valueOf(vatStr);

        System.out.println("The VAT payable is £" + vatStr);
        System.out.println("The ex-VAT Cost is £" + exVatStr);

    }
    
    
}//class


