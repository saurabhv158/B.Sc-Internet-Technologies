package saurabh2;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Saurabh2 {
    public static void main(String[] args)throws SQLException {
        Scanner s=new Scanner(System.in);
        String quey="select*from student";
        char choice = 'y';
        do {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement st=con.createStatement();
            ResultSet re=st.executeQuery(quey);
            System.out.println("enter your choies:");
            System.out.println("1 insert row");
            System.out.println("2 show table");
            System.out.println("3 delele row");
            int ch=s.nextByte();
            switch (ch) {
                case 1:
                    System.out.println("Name");
                    String name=s.next();
                    System.out.println("Roll No");
                    int rollno=s.nextInt();
                    System.out.println("Age");
                    int age=s.nextInt();
                    System.out.println("Subject");
                    String sub=s.next();
                    String query1="insert into student values('"+name+"','"+rollno+"','"+age+"','"+sub+"')";
                    st.executeUpdate(query1);
                    System.out.println("insert successfully!");
                    break;
                case 2:
                    while(re.next()){
                        System.out.println(re.getString(1)+" "+re.getInt(2)+" "+re.getInt(3)+" "+re.getString(4));
                    }
                    break;
                case 3:
                    //st.executeUpdate("DELETE FROM student WHERE roll_no = 11752;");
                    System.out.println("Enter roll_no who delelt data");
                    int x=s.nextInt();
                    PreparedStatement stt = con.prepareStatement("DELETE FROM student WHERE roll_no = ?;");
                    stt.setInt(1,x);
                    //String sql="DELETE FROM student WHERE rollno = " + x + ";";
                    stt.executeUpdate();
                    System.out.println("delete successfully!");
                    break;
                default:
                    System.out.println("Wrong choice!");
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        System.out.println("Press 'Y' to continue, any other key to exit.");
            choice=s.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }}
    