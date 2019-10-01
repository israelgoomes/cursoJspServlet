package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer conexão com o banco de dados
 * @author Israel Gomes
 *
 */
public class SingleConnection {
		private static String banco = "jdbc:postgresql://localhost:5432/posjava";
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
				//se for == null, irá fazer a conexão, caso contrário irá retornar a conexão que já existe
				if(connection == null){
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(banco, user, senha);
					//faz com que a modificação não seja commitada de forma automática, somente quando quiser 
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
