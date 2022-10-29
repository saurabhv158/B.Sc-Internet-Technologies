/*
 Q11. Create a class called Fraction that can be used to represent the ratio of two integers. 
      Include appropriate constructors and methods. If the denominator becomes zero, throw and handle
      an exception.
 */
package javapractical;

/**
 *
 * @author SH
 */
public class Q11 {
     public static void main(String args[]){
         try{
         fraction fc=new fraction(18,9);
         System.out.println(fc.getNumerator()+"/"+fc.getDenominator());
         }catch(ArithmeticException e){
             System.out.print(e.getMessage());
         }
    }
}
class fraction{
    private int p,q;
    fraction(int p,int q){
        if(q==0)throw new ArithmeticException("Denominator is 0");
        this.p=p;
        this.q=q;
        if(this.p%this.q==0){
            this.p=this.p/this.q;
            this.q=1;
        }
    }
    public fraction add(int a,int b){
        return new fraction((a*this.q)+(b*this.p),b*this.q);
    }
    public int getNumerator(){return this.p;}
    public int getDenominator(){return this.q;}
}
