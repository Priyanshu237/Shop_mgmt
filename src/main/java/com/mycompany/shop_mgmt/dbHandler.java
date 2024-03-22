/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_mgmt;
import java.sql.*;
import java.util.ArrayList;
import oracle.net.aso.i;
/**
 *
 * @author priya
 */
public class dbHandler {
   public static String id,pass; 
    public dbHandler(String id, String pass){
       
            this.id=id;
            this.pass=pass;
    }
    
    public void search(String product)throws SQLException, ClassNotFoundException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt"); 
        Statement stmt=con.createStatement();  
        //step4 execute query  
        ResultSet rs=stmt.executeQuery("select * from producttb where product="+product);
     
        
    }
    public String[][] getsalesRecord(String date) throws SQLException, ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt");  
  
        //step3 create the statement object  
        Statement stmt=con.createStatement();  
        //step4 execute query  
        System.out.println(date);
        ResultSet rs=stmt.executeQuery("select * from sales where datee='"+date+"'"); 
     int i=0;
        String[][] lists=new String [rs.getFetchSize()][5];
        while(rs.next()){  
            lists[i][0]=rs.getString(1);
            lists[i][1]=rs.getString(2);
            lists[i][2]=rs.getString(3);
            lists[i][3]=rs.getString(4);
            lists[i][4]=rs.getString(5);
           i++;
           for(int j=0;j<5;j++)
               System.out.println(lists[i][j]);
        }
        
        con.close();
        
      return lists;
    }
    public void insertSalesRecords(String date, String costId,String pId,String amount,String Qty) throws SQLException, ClassNotFoundException{
         Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt");  
  
        //step3 create the statement object  
        Statement stmt=con.createStatement();  
        //step4 execute query  
        ResultSet rs=stmt.executeQuery("Insert Into sales values('"+
                date+   "','"+
                costId+ "',"+
                pId+    ","+
                amount+ ","+
                Qty+    ")"); 
        con.commit();
        con.close();
    }
    public String[] getProductList() throws ClassNotFoundException, SQLException{
    
        Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt");  
  
        //step3 create the statement object  
        Statement stmt=con.createStatement();  
        //step4 execute query  
        ResultSet rs=stmt.executeQuery("select * from products"); 
        ArrayList<String> arr=new ArrayList<String>();
        
        while(rs.next()){  
            arr.add(rs.getString("product_name"));
        }
        String[] lists=new String [arr.size()];
        for(int i=0;i<arr.size();i++){
            lists[i]=arr.get(i);
            System.out.println(lists[i]);
        }
        
        con.close();
        
      return lists;
    }
    public String[] getItemDetails(String pName) throws ClassNotFoundException, SQLException{
        
        Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt");  
  
        //step3 create the statement object  
        Statement stmt=con.createStatement();  
        //step4 execute query  
        System.out.println(pName);
        ResultSet rs=stmt.executeQuery("select * from products where product_name='"+pName+"'"); 
        
        String[] arr=new String[4];
        rs.next();
        for(int i=0; i<4;i++)
            arr[i]=rs.getString(i+1);
            
        
        con.close();
        return arr;
    }
   public void uploadCostomrtDeltail(String name, String id, String phone,String address,String gender,String email ) throws ClassNotFoundException, SQLException{
         Class.forName("oracle.jdbc.driver.OracleDriver");  
  
       //step3 create the statement object
       try ( //step2 create  the connection object
               Connection con = DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt")) {
           //step3 create the statement object
           Statement stmt=con.createStatement();
           //step4 execute query
           String qu="insert into costomer values('"+id+"','"+name+"','"+phone+"','"+email+"','"+gender+"','"+address+"')";
           System.out.println(qu);
           stmt.executeQuery(qu);
           con.commit();
       }
   }
    

    
    public static boolean checkUser() throws SQLException, ClassNotFoundException  
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","shop","mgmt");  
  
        //step3 create the statement object  
        Statement stmt=con.createStatement();  
        //step4 execute query  
        ResultSet rs=stmt.executeQuery("select * from adminLogin"); 
        String chid,chpass;
        
        
        
        boolean ret = false;
        while(rs.next()){  
            chid=rs.getString("id");
            chpass=rs.getString("pass");
            System.out.println(chid+"   ,   "+chpass+"   ,  "+id+"    ,  "+pass);
            if(chid.equals(id) &&  chpass.equals(pass)){
                 ret=true;
            }  
        }
        System.out.println("Checked");
            return ret;
        
          
    }
}

    
    
    
  
