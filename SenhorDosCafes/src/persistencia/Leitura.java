package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {

	private ArrayList<DadosCombates> linhas;

	public Leitura() {
		linhas = new ArrayList<DadosCombates>();
	}

	public ArrayList<DadosCombates> getDadosCombates() {
		return linhas;
	}

	public void ler(String caminho) {
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(caminho));

			while (br.ready()) {

				String linha = br.readLine();
				if (linha.contains(";")) {
					// System.out.println("linha: " + linha + linha.contains(";"));
					linhas.add(splitLinha(linha));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void imprimir() {
	}

	public DadosCombates splitLinha(String linha) {

		DadosCombates dados = new DadosCombates();
		if (linha != null) {
			String[] splite = linha.split(";");

			for (int i = 0; i < splite.length; i++) {
				dados.add(splite[i]);
			}
		}
		return dados;
	}
}
