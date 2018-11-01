/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import object.Subject;

/**
 *
 * @author DuongSon
 */
public class GetDB {
    private Connection con ;
    private Statement st;
    private ResultSet rs;
    
    public GetDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hethongthitracnghiem","root","");
            st = con.createStatement();
        } catch (Exception exception){
            System.out.println(exception);
        }
    }    
    
    public ArrayList getListSubject(){ // lay du lieu cua subject cho vao mot danh sach arraylist
        ArrayList<Subject> listSubjects = new ArrayList<Subject>();
        try {
           String query = "select * from subjects";
            rs = st.executeQuery(query);
            while (rs.next()){                
                listSubjects.add(new Subject(rs.getInt("SubjectID"),rs.getString("SubjectName")));                
            }
        } catch (Exception e) {
        }
        return listSubjects;
    }
    
    
    public static void main(String[] args) {
        GetDB get = new GetDB();
        ArrayList<Subject> ar = get.getListSubject();
        System.out.println(ar.get(0).getSubjectName());
    }
}
