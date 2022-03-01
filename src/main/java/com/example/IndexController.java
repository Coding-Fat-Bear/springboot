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
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lijoe
 */

@Controller
public class IndexController {
    private Connection con;
//    @Autowired
                    private temp[] arr;
                    private temp temp;
    @RequestMapping("index")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        System.out.println("workins control");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Statement st = con.createStatement();
             String weblng = "EN";
             arr = new temp[5];
             arr[0] = new temp("06", "EMM");
             arr[1] = new temp("58", "INQM");
             arr[2] = new temp("107", "ESTMS");
             arr[3] = new temp("124", "PRJMS");
             arr[4] = new temp("92", "BPM");
             
//             for(int i=0;i<arr.length;i++)
//             {
                 temp.Setquery(arr[0],weblng,request );
//             }                 
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
             
        }
   
        
    }