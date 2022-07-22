package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class DadosCombatentesDAO {
	
	public DadosCombatentesDAO() {
		
	}
		
		public boolean inserir(DadosCombates a) {
			
			int valor = 0;
			try {
				Connection conexao = (Connection) new Conexao().getConexao();

				PreparedStatement result = conexao.prepareStatement(
						"INSERT INTO dados (tipo, nome, ataque , defesa) VALUES (?,?,?,?,?,?,?,?)");

				
				result.setString(1, a.getDados().get(4) );
				result.setString(2, a.getDados().get(8));
				result.setString(3, a.getDados().get(5));
				result.setString(4, a.getDados().get(9));
				result.setString(5, a.getDados().get(6));
				result.setString(6, a.getDados().get(7));
				result.setString(7, a.getDados().get(11));
				result.setString(8, a.getDados().get(12));
				valor = result.executeUpdate();
				conexao.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			if (valor == 1) {
				return true;
			}else {
				return false;
			
		}
		

		

		
	}
}

