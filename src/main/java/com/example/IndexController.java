/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lijoe
 */

@Controller
public class IndexController {
    private Connection con;
    @RequestMapping("index")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        System.out.println("workins control");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Statement st = con.createStatement();
             String weblng = "EN";
             Temp[] arr = new Temp[5];
             arr[0] = new Temp("06", "EMM");
             arr[1] = new Temp("58", "INQM");
             arr[2] = new Temp("107", "ESTMS");
             arr[3] = new Temp("124", "PRJMS");
             arr[4] = new Temp("92", "BPM");
             
             for(int i=0;i<arr.length;i++)
             {
                 Setquery(arr[i],weblng,request );
             }                 
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
             
        }
    public void Setquery(Temp i,String str,HttpServletRequest req) throws SQLException
    {    String s1 = i.getLoc();
        String sq= "select * from Field_Text where FLDID ='"+i.getId()+"' and LNGID ='"+str+"'";
        System.out.println("select * from Field_Text where FLDID ='"+i.getId()+"' and LNGID ='"+str+"'");
                PreparedStatement pst = con.prepareStatement(sq);
                ResultSet rs = pst.executeQuery();
                System.out.println('"'+s1+'"');
                  while(rs.next()){
                      System.out.println("available");
                req.setAttribute(s1,rs.getString("FLDTXT"));
                  }
        
    }
    public class Temp {
    private String id;
    private String loc;

    Temp(String id, String name)
    {
        this.id = id;
        this.loc = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    
    
}
}
