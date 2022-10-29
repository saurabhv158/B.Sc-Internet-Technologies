/*
Q6. Write a program to create an array of 10 integers.
    Accept values from the user in that array. 
    Input another number from the user and find out how many numbers are equal to the number passed,
    how many are greater and how many are less than the number passed.
 */
package javapractical;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Gaurav
 */
public class Q6 {
    static int[] Array=new int[10];
    static Scanner sc;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.print("Please Enter number at position "+i+" of Array[]-->");
            Array[i]=sc.nextInt();
        }
        System.out.print("Enter number For which to compare:-");
        int ch=sc.nextInt();
        int eq=0;
        int gr=0;
        int sm=0;
        for(int i=0;i<10;i++){
            if(ch==Array[i])eq++;
            else if(ch<Array[i])gr++;
            else if(ch>Array[i])sm++;
        }
        System.out.println("number equal to "+ch+" are "+eq);
        System.out.println("number smaller than "+ch+" are "+sm);
        System.out.println("number greater than "+ch+" are "+gr);
    }
    
}
