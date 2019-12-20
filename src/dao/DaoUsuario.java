package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BeanServlet;
import bean.BeanUsuarioTelefone;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvarUsuario(BeanServlet usuario)  {
		
		try {
		String sql = "insert into usuario(id_user, nome, email, senha) values(nextval('sq_usuario_01'), ?, ?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, usuario.getNome());
		insert.setString(2,  usuario.getEmail());
		insert.setString(3, usuario.getSenha());
		insert.execute();
		connection.commit();
		}catch (Exception e) {
			try {
			connection.rollback();
			}catch (Exception e2){
				e2.printStackTrace();
			}
			e.printStackTrace();
			
		}
	}
	
	public void sslvarTelefoneUsuario(BeanUsuarioTelefone telefone) {
		try {
			String sql = "insert into telefoneuser(id_telefone, residencial, celular, id_user) values(nextval('sq_telefone_user_01'), ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getResidencial());
			insert.setString(2, telefone.getCelular());
			insert.setLong(3, telefone.getIdUser());
			insert.execute();
			connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
			}catch (Exception e2) {
					e2.printStackTrace();
			}
			e.printStackTrace();
			}
	}
	
	public List<BeanServlet> listaUsuario() throws Exception{
		List<BeanServlet> lista = new ArrayList<BeanServlet>();
		String sql = "select u.*, t.celular, t.residencial\n" + 
				"from usuario u\n" + 
				"left join telefoneuser t on u.id_user = t.id_user";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();
		
		while(resultSet.next()) {
			BeanServlet beanCurso = new BeanServlet();
			beanCurso.setIdUser(resultSet.getLong("id_user"));
			beanCurso.setNome(resultSet.getString("nome"));
			beanCurso.setSenha(resultSet.getString("senha"));
			beanCurso.setEmail(resultSet.getString("email"));
			beanCurso.setCelular(resultSet.getString("celular"));
			beanCurso.setResidencial(resultSet.getString("residencial"));
			
			lista.add(beanCurso);
		}
		
		return lista;

	}
	
public List<BeanUsuarioTelefone> listarUsuarioTelefone() throws Exception{
	List<BeanUsuarioTelefone> lista = new ArrayList<BeanUsuarioTelefone>();
	String sql = "select usuario.nome, usuario.email, t.celular, t.residencial from telefoneuser t inner join usuario on t.id_user = usuario.id_user";
	PreparedStatement select = connection.prepareStatement(sql);
	ResultSet resultSet = select.executeQuery();
	
	while(resultSet.next()) {
		BeanUsuarioTelefone beanUserTel= new BeanUsuarioTelefone();
		
		beanUserTel.setCelular(resultSet.getString("celular"));
		beanUserTel.setResidencial(resultSet.getString("residencial"));
		
		lista.add(beanUserTel);
		
		
	}
	return lista;
}

public void delete (String idUser) {
	try {
	String sql = "delete from usuario where id_user = '" + idUser +"'";
	PreparedStatement delete = connection.prepareStatement(sql);
	delete.execute();
	connection.commit();
	}catch (Exception e) {
		e.printStackTrace();
		try {
		connection.rollback();
		}catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
		}
		
	}
	}

public BeanServlet consultar(String nome) throws SQLException {
	String sql = "select * from usuario where nome='" + nome + "'";
	PreparedStatement select = connection.prepareStatement(sql);
	ResultSet resultSet = select.executeQuery();
	
	if(resultSet.next()) {
		BeanServlet bean = new BeanServlet();
		bean.setIdUser(resultSet.getLong("id_user"));
		bean.setNome(resultSet.getString("nome"));
		bean.setSenha(resultSet.getString("senha"));
		bean.setEmail(resultSet.getString("email"));
		return bean;
	}
	return  null;
}

public void atualizar(BeanServlet usuario) {
	try {
	String sql = "update usuario set nome = ?, senha = ?, email = ? where id_user = " + usuario.getIdUser();
	PreparedStatement update = connection.prepareStatement(sql);
	update.setString(1, usuario.getNome());
	update.setString(2, usuario.getSenha());
	update.setString(3, usuario.getEmail());
	update.executeUpdate();
	connection.commit();
	}catch (Exception e) {
		e.printStackTrace();
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO: handle exception
	}
}
	
}
