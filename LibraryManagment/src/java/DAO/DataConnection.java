/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOs.Book;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import POJOs.User;
import java.util.HashMap;

/**
 *
 * @author Vinod
 */
public class DataConnection {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarymangement?user=root");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public boolean checkValidUser(String username, String password) {
        try {
            Connection connection = getConnection();
            String sql = "select id from users where username = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

            connection.close();
        } catch (Exception ex) {
            System.err.print(ex);
        }

        return false;
    }
    
    public int addUser(User user) {
        int status = 0;

        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO  users ( name,username,enrollment,password,semester) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getEnrollment());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getSemester());
            
            status=preparedStatement.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
    
    
    public int addBook(Book book){
        int status=0;
        Connection connection=getConnection();
        
        String sql="insert into book(bookName,bookAuthor) values(?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookAuthor());
            status=preparedStatement.executeUpdate();               
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public HashMap<Integer,Book> getAllBooks(){
        Connection connection=getConnection();
        HashMap<Integer,Book> hashMap=new HashMap<>();
        String sql="select * from book";
        
       Statement s;
        try {
            s = connection.createStatement();
            ResultSet  resultSet=  s.executeQuery(sql);
            
            while(resultSet.next())
                hashMap.put(resultSet.getInt("id"), new Book(resultSet.getString("bookName"), resultSet.getString("bookAuthor")));
            
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return hashMap;
    }
    
    public int deleteBook(int key){
        Connection connection=getConnection();
        int status=0;
        String sql="delete from book where id=?";
        
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, key);
            status=preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int editBook(int key,Book book){
        Connection connection=getConnection();
        int status=0;
        String sql="update book set bookName = ? , bookAuthor = ? where id = ?";
        
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookAuthor());
            preparedStatement.setInt(3, key);
            status=preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    
}
