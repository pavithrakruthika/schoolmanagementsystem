package javaclass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class adminworkproject {
	void work() throws Exception{
	   int choice,x=1;
	   String admusern="pavithra",admuserp="pavi123";
	   Scanner obj=new Scanner(System.in);
	   System.out.println("ENTER ADMIN USERNAME:");
	   admusern= obj.next();
	   System.out.println("ENTER ADMIN PASSWORD:");
	   admuserp=obj.next();
	   if(admusern.equals("pavithra") && admuserp.equals("pavi123") ) {
		  String url="jdbc:mysql://localhost/admin";
          String user="root";
          String pass="";
           while(x==1) {
             System.out.println("Enter the choice:");
    		 choice=obj.nextInt();
    		 if(choice==1) {
		        String staffname;
			    System.out.println("Staff data:");
			    System.out.println("Enter staffname:");
	            staffname=obj.next();
			    String qry=("SELECT * FROM staff WHERE Staffname=?");
			    Connection con=DriverManager.getConnection(url,user,pass);
	            PreparedStatement stmt=con.prepareStatement(qry);
	            stmt.setString(1, staffname);
	            ResultSet rst=stmt.executeQuery();
	            if(rst.next()) {
	              String salarystatus="salary credited";
	              String qry1="UPDATE staff SET salarystatus='salary credited'";
	              Class.forName("com.mysql.jdbc.Driver");
	              Connection con1=DriverManager.getConnection(url,user,pass);
	              PreparedStatement stmt1=con.prepareStatement(qry1);
	              stmt1.executeUpdate();
	              System.out.println("SALARY Updated");
	              stmt1.close();
		          con1.close();
	            }
	            else {
            	 System.out.println("invalid staff");
            	 String subjecthandling,username,password,salarystatus;
                 double salary;
                 System.out.println("enter the staffname:");
                 staffname=obj.next();
                 System.out.println("subject handled by the staff:");
                 subjecthandling=obj.next();
                 System.out.println("enter the username of the staff:");
                 username=obj.next();
                 System.out.println("enter the password of the staff:");
                 password=obj.next();
                 System.out.println("enter the salary :");
                 salary=obj.nextDouble();
                 System.out.println("Salary status:");
                 salarystatus=obj.next();
                 String qry1="INSERT INTO staff( Staffname, subjecthandling, username, password, salary, salarystatus) VALUES(?,?,?,?,?,?)";
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con1=DriverManager.getConnection(url,user,pass);
                 PreparedStatement stmt1=con.prepareStatement(qry1);
                 stmt1.setString(1, staffname);
                 stmt1.setString(2,subjecthandling);
                 stmt1.setString(3, username);
                 stmt1.setString(4, password);
                 stmt1.setDouble(5, salary);
                 stmt1.setString(6, salarystatus);
                 stmt1.executeUpdate();
                 System.out.println("Records inserted");
                 stmt1.close();
                 con1.close();
            }
            System.out.println("Do you want to delete any staff details:");
            String sd;
            sd=obj.next();
            if(sd.equals("yes")) {
            	System.out.println("Enter staff id to be deleted:");
            	staffname=obj.next();
            	String qry1= "DELETE FROM staff where Staffname=?";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con1=DriverManager.getConnection(url,user,pass);
                PreparedStatement stmt1=con.prepareStatement(qry1);
                stmt1.setString(1, staffname);
                stmt1.executeUpdate();
                System.out.println("Records deleted");
                stmt1.close();
                con1.close();
            }
		             }
           	else if(choice==2) {
			System.out.println("Student data:");
            String studentname,susername,spassword;
            System.out.println("Enter rollnumber:");
            int rollnumber=obj.nextInt();
		    String qry=("SELECT * FROM student WHERE rollnumber=?");
            Connection con=DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement(qry);
            stmt.setInt(1, rollnumber);
            ResultSet rst=stmt.executeQuery();
            if(rst.next()) {
            	System.out.println("Existing user");
            }
            else {
            	
                double m1,m2,m3,m4,m5,total,avg;
                	System.out.println("Student data:");
               	    System.out.println("enter the studentname:");
                    studentname=obj.next();
                    System.out.println("student rollnumber:");
                    rollnumber=obj.nextInt();
                    System.out.println("enter the username of the student:");
                    susername=obj.next();
                    System.out.println("enter the password of the student:");
                    spassword=obj.next();
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
                    String qry2="INSERT INTO student(studentname, rollnumber, username, password , mark1, mark2 , mark3 ,mark4 ,mark5,total, average) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con2=DriverManager.getConnection(url,user,pass);
                    PreparedStatement stmt2=con.prepareStatement(qry2);
                    stmt2.setString(1, studentname);
                    stmt2.setInt(2,rollnumber);
                    stmt2.setString(3, susername);
                    stmt2.setString(4, spassword);
                    stmt2.setDouble(5, m1);
                    stmt2.setDouble(6, m2);
                    stmt2.setDouble(7, m3);
                    stmt2.setDouble(8, m4);
                    stmt2.setDouble(9, m5);
                    stmt2.setDouble(10,total);
                    stmt2.setDouble(11,avg);
                    stmt2.executeUpdate();
                    System.out.println("Records inserted");
                    stmt2.close();
                    con2.close();
            }
            System.out.println("Do you want to delete any student details:");
            String sd;
            sd=obj.next();
            if(sd.equals("yes")) {
            	System.out.println("Enter rollnumber to be deleted:");
            	rollnumber=obj.nextInt();
            	String qry2= "DELETE FROM STUDENT where ROLLNUMBER=?";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con2=DriverManager.getConnection(url,user,pass);
                PreparedStatement stmt2=con.prepareStatement(qry2);
                stmt2.setInt(1, rollnumber);
                stmt2.executeUpdate();
                System.out.println("Records deleted");
                stmt2.close();
                con2.close();
            }
            System.out.println("ENTER 1 IF YOU WANT TO ADD DATA:");
	             x=obj.nextInt();       
		  }		             
		}
	  }
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		adminworkproject a=new adminworkproject();
		a.work();
	}
}
