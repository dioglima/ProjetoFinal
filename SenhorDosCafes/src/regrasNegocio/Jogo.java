package regrasNegocio;

import java.io.File;
import java.util.ArrayList;
import persistencia.DadosCombates;
import persistencia.Leitura;

public class Jogo {

	public Leitura ler;

	private ArrayList<CombateIndividual> combatesIndividuais;

	public Jogo() {
		combatesIndividuais = new ArrayList<CombateIndividual>();
		ler = new Leitura();

	}

	public ArrayList<CombateIndividual> getCombatesIndividuais() {
		return combatesIndividuais;
	}

	private void montarCombatesIndividuais(String caminho) {

		FabricaPersonagens fabrica = new FabricaPersonagens();
		Personagem p1;
		Personagem p2;
		ArrayList<String> linha;
		CombateIndividual combate;

		ler.ler(caminho);

		for (DadosCombates d : ler.getDadosCombates()) {
			linha = d.getDados();

			p1 = fabrica.criarPrimeiroPersonagem(linha);
			p1.verificarSuperAtaque();

			p2 = fabrica.criarSegundoPersonagem(linha);
			p2.verificarSuperAtaque();

			int idBatalha = Integer.parseInt(linha.get(1));
			int idCombate = Integer.parseInt(linha.get(2));

			combate = new CombateIndividual(p1, p2, idBatalha, idCombate);
			combate.computarLuta();
			combatesIndividuais.add(combate);
		}
	}

	public void iniciar() {

		// Todos os arquivos de entrada estao nestas pastas.
		String caminho = "dados/";
		// O nome do arquivo que vai ser processado.
		String nomeDoArquivo;
		// O caminho do arquivo e o seu nome.
		String nomeDoArquivoMaisCaminho = null;
		File diretorio = new File(caminho);
		// Obtém a lista de arquivos neste diretório, como o próprio método
		// "listFiles()" diz,
		// não existe uma garantia em que ordem os arquivos serão retornados.
		File[] listaDeArquivos = diretorio.listFiles();

		for (int i = 0; i < listaDeArquivos.length; i++) {

			if (listaDeArquivos[i].isFile()) {
				nomeDoArquivo = listaDeArquivos[i].getName();
				if (nomeDoArquivo.endsWith(".csv") && !nomeDoArquivo.contains("resposta")) {
					try {
						nomeDoArquivoMaisCaminho = caminho + nomeDoArquivo;
						String nomeReposta = nomeDoArquivoMaisCaminho.replace(".csv", "_resposta.csv");
						montarCombatesIndividuais(nomeDoArquivoMaisCaminho);
						Relatorio relatorio = new Relatorio(combatesIndividuais, nomeReposta);
						relatorio.gerarRelatorioFinal();

					} catch (Exception e) {

					}
				}
			}

		}
	}

}
