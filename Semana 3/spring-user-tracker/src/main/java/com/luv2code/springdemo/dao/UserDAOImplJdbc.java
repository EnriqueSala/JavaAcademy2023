package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.User;


@Repository
public class UserDAOImplJdbc implements UserDAO {
	
	@Autowired
	private DataSource dataSource;

	public UserDAOImplJdbc(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	@Override
	public List<User> getUsers(){
		
		List<User> users = new ArrayList<>();
		

		// create sql statement
		String sql = "select * from user order by apellido";
		try (Connection myConn= dataSource.getConnection()){
			Statement myStmt = myConn.createStatement();
			
			// execute query
			ResultSet myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String direccion = myRs.getString("direccion");
				String telefono = myRs.getString("telefono");
				
				// create new user object
				User tempUser = new User(id, nombre, apellido, correo, direccion, telefono);
				
				// add it to the list of users
				users.add(tempUser);				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;	
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void saveUser(User theUser){

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		if(theUser.getId() == 0) {
			try {
				// get db connection
				myConn = dataSource.getConnection();
				
				// create sql for insert
				String sql = "insert into user "
						   + "(nombre, apellido, correo, direccion, telefono) "
						   + "values (?, ?, ?, ?, ?)";
				myStmt = myConn.prepareStatement(sql);
				
				// set the param values for the user
				myStmt.setString(1, theUser.getNombre());
				myStmt.setString(2, theUser.getApellido());
				myStmt.setString(3, theUser.getCorreo());
				myStmt.setString(4, theUser.getDireccion());
				myStmt.setString(5, theUser.getTelefono());
				
				// execute sql insert
				myStmt.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				// clean up JDBC objects
				close(myConn, myStmt, null);
			}
		}else {
			try {
				// get db connection
				myConn = dataSource.getConnection();
				
				// create SQL update statement
				String sql = "update user "
							+ "set nombre=?, apellido=?, correo=?, direccion=?, telefono=? "
							+ "where id=?";
				
				// prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setString(1, theUser.getNombre());
				myStmt.setString(2, theUser.getApellido());
				myStmt.setString(3, theUser.getCorreo());
				myStmt.setString(4, theUser.getDireccion());
				myStmt.setString(5, theUser.getTelefono());
				myStmt.setInt(6, theUser.getId());
				
				// execute SQL statement
				myStmt.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				// clean up JDBC objects
				close(myConn, myStmt, null);
			}
			
		}
		
	}
	
	@Override
	public User getUser(int theUserId){

		User theUser = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int userId;
		
		try {
			// convert user id to int
			userId = theUserId;
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected user
			String sql = "select * from user where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String direccion = myRs.getString("direccion");
				String telefono = myRs.getString("telefono");
				
				// use the userId during construction
				theUser = new User(userId, nombre, apellido, correo, direccion, telefono);
			}
			else {
				throw new Exception("Could not find user id: " + userId);
			}				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
		return theUser;
	}

	@Override
	public void deleteUser(int theUserId){

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert user id to int
			int userId = theUserId;
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete user
			String sql = "delete from user where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute sql statement
			myStmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















