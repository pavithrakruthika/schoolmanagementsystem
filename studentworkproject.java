package javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class studentworkproject {
	void studentwork() throws SQLException {
		String susername,spassword;
		Scanner obj=new Scanner(System.in);
		String url="jdbc:mysql://localhost/admin";
        String user="root";
        String pass="";
		System.out.println("Enter your Username:");
		susername=obj.next();
		System.out.println("Enter your password:");
		spassword=obj.next();
        String qry=("SELECT * FROM student WHERE username=? and password=?");
        Connection con=DriverManager.getConnection(url,user,pass);
        PreparedStatement stmt=con.prepareStatement(qry);
        stmt.setString(1, susername);
        stmt.setString(2, spassword);
        ResultSet rst=stmt.executeQuery();
        if(rst.next()){
            System.out.println("view results");
            System.out.println("ID\t studentname\t rollnumber\t\tmark1\t\t mark2\t\t mark3\t\t mark4\t\t mark5\t\t total\t\t average\t\t");    
        	System.out.print(rst.getInt(1));
        	System.out.print("\t\t"+rst.getString(2));
        	System.out.print("\t\t"+rst.getInt(3));
        	System.out.print("\t\t"+rst.getDouble(6));
        	System.out.print("\t\t"+rst.getDouble(7));
        	System.out.print("\t\t"+rst.getDouble(8));
        	System.out.print("\t\t"+rst.getDouble(9));
        	System.out.print("\t\t"+rst.getDouble(10));
        	System.out.print("\t\t"+rst.getDouble(11));
        	System.out.print("\t\t"+rst.getDouble(12));
        	System.out.println();
        }
        else {
        	System.out.println("INVALID STUDENT LOGIN");
        }
        
        stmt.close();
        con.close();
		}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        studentworkproject s=new studentworkproject();
        s.studentwork();
	}

}
