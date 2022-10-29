/*
 Q8. Write a java program that computes the area of a circle,
     rectangle and a Cylinder using function overloading.
 */
package javapractical;

import java.util.Scanner;

/**
 *
 * @author SH
 */
public class Q8 {
    public static void main(String args[]){
        while(true){
            newmain();
        }
    }
    public static void newmain(){
        Shape s=new Shape();
        Scanner sc=new Scanner(System.in);
        System.out.println("for rectangle :Enter 1\nfor Cylinder :Enter 2\nfor circle :Enter anything else");
        int res=sc.nextInt();
        if(res==1){
            System.out.print("Enter lengh: ");
            int l=sc.nextInt();
            System.out.print("Enter bredth: ");
            int b=sc.nextInt();
            System.out.println(s.area(l,b));
        }
        else if(res==2){
            System.out.print("Enter radious: ");
            int r=sc.nextInt();
            System.out.print("Enter height: ");
            int h=sc.nextInt();
            System.out.println(s.area(r,h,true));
        }
        else{
            System.out.print("Enter radious: ");
            int r=sc.nextInt();
            System.out.println(s.area(r));
        }
    }
    
}
class Shape{
    Shape(){}
    public float area(float l,float b){
        return l*b;
    }
    public double area(float r){
        return Math.PI*r*r;
    }
    public double area(float r,float h,boolean isCyliner){
        return 2*Math.PI*r*h;
    }
}
