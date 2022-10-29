/*
Q12. Create a base class called Shape. It should contain 2 methods getcoord() and showcorrd () to accept X 
     and Y coordinates and to display the same respectively. Create a sub class called Rect. 
     It should also contain a method to display the length and breadth of the rectangle
     called showCorrd(). In main method, execute the showCorrd() method of the Rect 
     class by applying the dynamic method dispatch concept.
 */
package javapractical;

/**
 *
 * @author SH
 */
public class Q12 {
     public static void main(String args[]){
        shape sh;//sh of type shape
        sh=new shape(2,3);
        sh.showcorrd();
        sh=new Rect(2,3);//referenced as object Rect
        sh.showcorrd();
    }
}
class Rect extends shape{
    int length,breadth;
    Rect(int length,int breadth){
        super(0,0);
        this.length=length;
        this.breadth=breadth;
    }
    public void showcorrd(){
        System.out.println("length = "+this.length);
        System.out.println("bradeth = "+this.breadth);
    }
}
class shape{
    int x,y;
    shape(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void getcoord(int x,int y){}
    public void showcorrd(){
         System.out.println("x = "+this.x);
         System.out.println("y = "+this.y);
    }
}
