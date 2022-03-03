/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lijoe
 */
@Component
public class temp {
    private  String id;
    private String loc;
    private java.sql.Connection con;
//    @Autowired
    public temp( String id, String name)
    {
        System.out.println("constructor");
        this.id = id;
        this.loc = name;
    }
    public temp( )
    {
        System.out.println("constructor hate");
    }
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
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
    
    public void setData(String id, String name)
    {
        this.id = id;
        this.loc = name;
    }
    
     public void Setquery(temp i,String str,HttpServletRequest req) throws SQLException
    {    
        String s1 = i.getLoc();
        String sq= "select * from Field_Text where FLDID ='"+i.getId()+"' and LNGID ='"+str+"'";
        System.out.println(s1);
                PreparedStatement pst = con.prepareStatement(sq);
                ResultSet rs = pst.executeQuery();
                System.out.println('"'+s1+'"');
                  while(rs.next()){
                req.setAttribute(s1,rs.getString("FLDTXT"));
                  }
}
}