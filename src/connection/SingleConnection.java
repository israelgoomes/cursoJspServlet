package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer conexāo com o banco de dados
 * @author Israel Gomes
 *
 */
public class SingleConnection {
		private static String banco = "jdbc:postgresql://localhost:5432/postgres";
		private static String senha = "admin";
		private static String user = "postgres";
		private static Connection connection = null; 
		
		static {
			conectar();
		}
		
		public SingleConnection(){
			
		}
		
		private static void conectar(){
			try {
				//se for == null, ir� fazer a conex�o, caso contr�rio ir� retornar a conex�o que j� existe
				if(connection == null){
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(banco, user, senha);
					//faz com que a modifica��o n�o seja commitada de forma autom�tica, somente quando quiser 
					connection.setAutoCommit(false);
					System.out.println("Conectou com sucesso!");

				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao conectar com o banco de dados");
			}
		}
		public static Connection getConnection(){
			return connection;
		}
}
