package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.BeanServlet;
import connection.SingleConnection;

public class DaoLogin {

	
	private Connection 
	connection;
	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String email, String senha) throws Exception{
		String sql = "select * from usuario where email = '"+ email +"' and senha = '"+ senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		//verifica se o resultset retornou algum valor, se sim, entra no if.
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
