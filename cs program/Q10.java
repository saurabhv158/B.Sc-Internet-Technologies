/*
Q10. Write a program that reads two integer numbers for the variables a and b. 
     If any other character except number (0-9) is entered then the error is caught
     by NumberFormatException object. After that ex.getMessage() prints the information
     about the error occurring causes.
 */
package javapractical;

import java.util.Scanner;
/**
 *
 * @author SH
 */
public class Q10 {
    static Scanner sc;
     public static void main(String args[]){
        sc=new Scanner(System.in);
        try{
           System.out.print("please input a:");
           String stra=sc.next();
           int a=Integer.parseInt(stra);
           System.out.print("please input b:");
           String strb=sc.next();
           int b=Integer.parseInt(stra); 
        }
        catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
}