package persistencia;

import java.util.ArrayList;

public class DadosCombates {

	private ArrayList<String> linha;
	
	public DadosCombates() {
		linha = new ArrayList<String>();
	}
	
	public ArrayList<String> getDados(){
		return linha;
	}
	public void add(String numero) {
		linha.add(numero);
	}
	
}
