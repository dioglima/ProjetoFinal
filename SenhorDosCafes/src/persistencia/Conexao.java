  package persistencia;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	
	public Conexao() {
			this.host = "127.0.0.1";
			this.banco = "prova";
			this.usuario = "root";
			this.senha = "";
	}

	public Connection getConexao() {
		
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
	
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
			// Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}