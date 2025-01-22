import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.SQLException;

class MysqlCon {

   static void createtable(Connection con) throws SQLException {
      // create table user with name and email
      Statement stmt = con.createStatement();
      String sql = "CREATE TABLE REGISTRATION " +
            " (NAME VARCHAR(255), " +
            " EMAIL VARCHAR(255), " +
            " PASSWORD VARCHAR(255)) ";
      System.out.println(sql);
      stmt.executeUpdate(sql);
      System.out.println("created table in given database");
   }

   static void insertRecord(Connection con) throws SQLException {
      // TODO: remove name, email and password parameters from the function and initialize them inside the function: DONE 
      // insert a row with given name and email
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your Name:");
      String Name = scanner.nextLine();
      System.out.println("Enter your Email");
      String Email = scanner.nextLine();
      System.out.println("Enter the Password");
      String Password = scanner.nextLine();
      Statement stmt = con.createStatement();
      String sql = "INSERT INTO REGISTRATION VALUES ('" + Name + "','" + Email + "','" + Password + "')";
      System.out.println(sql);
      stmt.executeUpdate(sql);
      System.out.println("inserted records in database");
   }

   static void readTable(Connection con) throws SQLException {
      // read give table and print all records
      // TODO: print like (name=value, email=value, password=value) in single line:DONE
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Table name you want to read:");
      String Table = scanner.nextLine();
      String query = "select name , email , password from " + Table + " ";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         System.out.print("Name:" + rs.getString("name"));
         System.out.print("  Email:" + rs.getString("email"));
         System.out.print("  Password:" + rs.getString("password"));
         System.out.print("\n");

      }
   }

   static void deleteRecordByUser(Connection con) throws SQLException {
      // delete record where name = name parameter
      // TODO: delete by email not by name. email should not be parameter and initialized inside the function: DONE
      Statement stmt = con.createStatement();
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Email you want to delete:");
      String Email = scanner.nextLine();
      String sql = "delete from REGISTRATION" + " where Email = '" + Email + "' ";
      System.out.println(sql);
      stmt.executeUpdate(sql);

   }

   static void updateRecordByEmail(Connection con) throws SQLException {
      // update record by email;
      // TODO: remove NAME, EMAIL and PASSWORD parameters from the function and initialize them inside the function:DONE 
      // TODO: variables should be camelCase:DONE 
      // TODO: If name of password is empty in the user's input, it should not be updated
      Statement stmt = con.createStatement();
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Email to update name and password :");
      String Email = scanner.nextLine();
      System.out.println("Enter New Name :");
      String Name = scanner.nextLine();
      if (Name == "");
      
      System.out.println("Enter New password :");
      String Password = scanner.nextLine();
      String sql = "update REGISTRATION SET Name = '" + Name + "', Password = '" + Password + "' " + "WHERE Email = '"
            + Email + "' ";

      System.out.println(sql);
      stmt.executeUpdate(sql);
   }

   public static void main(String args[]) throws SQLException {
      try {
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
         System.out.println("Connection successful");
         // createtable(con);
        
         int choice;
         // TODO: Add read case in switch:DONE
         // TODO: Add case for exit in switch (0):DONE
         // TODO: Move try catch (exception handling) inside do while loop
         do {
            System.out.println("select the options given below :");
            System.out.println("\n 1.insert \n 2.update \n 3.delete \n 4.read \n 5.exit ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
               case 1:
                  insertRecord(con);
                  break;
               case 2:
                  updateRecordByEmail(con);
                  break;
               case 3:
                  deleteRecordByUser(con);
                  break;
               case 4:
                  readTable(con);
                  break;
               case 5:
                  System.out.print("Exiting....");
                  System.exit(0);
                  
               default:
                  System.out.println("invalid choice:");
            }
         } while (choice != 0);
         
         // Statement stmt = con.createStatement();
         // ResultSet rs = stmt.executeQuery("select * from emp");
         // while (rs.next())
         // System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
         // rs.getString(3));
         con.close();
      } catch (Exception e) {
         System.out.println("Connection failed:");
         System.out.println(e);
         }
   }
}