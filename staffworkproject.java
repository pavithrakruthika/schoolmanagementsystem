package javaclass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class staffworkproject {
	void staffwork() throws Exception{
		String stusername,stpassword;
		Scanner obj=new Scanner(System.in);
		String url="jdbc:mysql://localhost/admin";
        String user="root";
        String pass="";
		System.out.println("Enter staff Username:");
		stusername=obj.next();
		System.out.println("Enter staff password:");
		stpassword=obj.next();
		String qry=("SELECT * FROM staff WHERE username=? and password=?");
        Connection con=DriverManager.getConnection(url,user,pass);
        PreparedStatement stmt=con.prepareStatement(qry);
        stmt.setString(1, stusername);
        stmt.setString(2, stpassword);
        ResultSet rst=stmt.executeQuery();
        int y=1;
           while(y==1) {
            if(rst.next());{
        	int choice;
        	System.out.println("Enter 1 : if you want to view staff details");
        	System.out.println("Enter 2 : if you want to update student data");
        	choice=obj.nextInt();
        	if(choice==1) {
        		String qry1=("SELECT * FROM staff WHERE username=? and password=?");
                Connection con1=DriverManager.getConnection(url,user,pass);
                PreparedStatement stmt1=con.prepareStatement(qry1);
                stmt1.setString(1, stusername);
                stmt1.setString(2, stpassword);
                ResultSet rst1=stmt1.executeQuery();
                System.out.println("view results");
                System.out.println("ID\t\tstaffname\t\t\tsubjecthandiling\t\salary\t\tsalarystatus");    
      	        System.out.print(rst.getInt(1));
      	        System.out.print("\t\t"+rst.getString(2));
      	        System.out.print("\t\t"+rst.getString(3));
      	        System.out.print("\t\t"+rst.getDouble(6));
      	        System.out.print("\t\t"+rst.getString(7));
      	        System.out.println();
        	  }
        	  else if(choice==2) {
        		System.out.println("Update Student Data");
        		int rollno;
        		System.out.println("Enter the roll number of the student:");
        		rollno=obj.nextInt();
        		String qry1=("SELECT * FROM student WHERE rollnumber=?");
        	    Connection con1=DriverManager.getConnection(url,user,pass);
        	    PreparedStatement stmt1=con1.prepareStatement(qry1);
        	    stmt1.setInt(1, rollno);
        	    ResultSet rst1=stmt1.executeQuery();
        	    if(rst1.next()) {
        	       double m1,m2,m3,m4,m5,total,avg;
        	       System.out.println(" mark1 :");
                   m1=obj.nextDouble();
                   System.out.println("mark2 :");
                   m2=obj.nextDouble();
                   System.out.println(" mark3 :");
                   m3=obj.nextDouble();
                   System.out.println(" mark4 :");
                   m4=obj.nextDouble();
                   System.out.println(" mark5 :");
                   m5=obj.nextDouble();
                   total=m1+m2+m3+m4+m5;
                   System.out.println("Total:"+total);
                   avg=total/5;
                   System.out.println("average:"+avg);
	               String qry2=("UPDATE student SET mark1=?,mark2=?,mark3=?,mark4=?,mark5=?,total=?,average=? where rollnumber=?");
	               Class.forName("com.mysql.jdbc.Driver");
	               Connection con2=DriverManager.getConnection(url,user,pass);
	               PreparedStatement stmt2=con.prepareStatement(qry2);
	               stmt2.setDouble(1,m1);
	               stmt2.setDouble(2,m2);
	               stmt2.setDouble(3,m3);
	               stmt2.setDouble(4,m4);
	               stmt2.setDouble(5,m5);
	               stmt2.setDouble(6, total);
	               stmt2.setDouble(7,avg);
	               stmt2.setDouble(8,rollno);
	               stmt2.executeUpdate();
	               System.out.println("Updated");
	               stmt2.close();
		           con2.close();
        	        }	
        	}
        } 
        System.out.println("press 1 if you want to continue:");
        y=obj.nextInt();
        }
      }
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        staffworkproject p=new staffworkproject();
        p.staffwork();
	}
}
