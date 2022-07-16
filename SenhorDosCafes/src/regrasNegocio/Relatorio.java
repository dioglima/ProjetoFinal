package regrasNegocio;

import java.util.ArrayList;
import persistencia.Escrita;

public class Relatorio implements GerarRelatorio {

	private ArrayList<CombateIndividual> combatesIndividuais;
	private String arquivoReposta;

	public Relatorio(ArrayList<CombateIndividual> combatesIndividuais, String arquivoReposta) {
		this.combatesIndividuais = combatesIndividuais;
		this.arquivoReposta = arquivoReposta;
	}

	public void gerarRelatorioFinal() {
		String resposta="";
		
		resposta+=
				computarNumeroBatalhas()+";"+
				computarNumeroCombateIndividuais()+";"+
				computarQuantidadePersonagens()+";"+
				computarPontuacaoPersonagens()+";"+
				computarQuantidadeSuperPoderes()+";"+
				computarPersonagensComSuperPoderes()+";"+
				computarPersonagensMortos()+";"+
				computarPersonagensVivos()+";"+
				computarListaPersonagensVivos()+";"+
				computarListaPersonagensMortos()+";";
				
		
		Escrita escrever= new Escrita();
		escrever.escrever(resposta,arquivoReposta );
		
	}

	@Override
	public int computarNumeroBatalhas() {
		int max = 0;

		for (CombateIndividual c : combatesIndividuais) {
			if (c.getCodigo() > max)
				max = c.getCodigo();
		}
		return max;
	}

	@Override
	public int computarNumeroCombateIndividuais() {
		return combatesIndividuais.size();
	}

	@Override
	public String computarQuantidadePersonagens() {

		int mor = 0, cop = 0, caf = 0, neo = 0, orc = 0, tri = 0;

		for (CombateIndividual c : combatesIndividuais) {
			TiposPersonagens p1 = c.getPersonagem1().getTipo();
			TiposPersonagens p2 = c.getPersonagem2().getTipo();
			if (p1 == TiposPersonagens.MOR || p2 == TiposPersonagens.MOR)
				mor++;
			if (p1 == TiposPersonagens.COP || p2 == TiposPersonagens.COP)
				cop++;
			if (p1 == TiposPersonagens.CAF || p2 == TiposPersonagens.CAF)
				caf++;
			if (p1 == TiposPersonagens.NEO || p2 == TiposPersonagens.NEO)
				neo++;
			if (p1 == TiposPersonagens.ORC || p2 == TiposPersonagens.ORC)
				orc++;
			if (p1 == TiposPersonagens.TRI || p2 == TiposPersonagens.TRI)
				tri++;

		}
		return "MOR=" + mor + ", COP= " + cop + ", CAF= " + caf + ", NEO= " + neo + ", ORC= " + orc + ", TRI= " + tri;
	}

	@Override
	public String computarPontuacaoPersonagens() {

		int mor = 0, cop = 0, caf = 0, neo = 0, orc = 0, tri = 0;
//		System.out.println(combatesIndividuais.size());
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();

			if (p1.getTipo() == TiposPersonagens.MOR)
				mor += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.MOR)
				mor += p2.getPontuacao();

			if (p1.getTipo() == TiposPersonagens.COP)
				cop += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.COP)
				cop += p2.getPontuacao();

			if (p1.getTipo() == TiposPersonagens.CAF)
				caf += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.CAF)
				caf += p2.getPontuacao();

			if (p1.getTipo() == TiposPersonagens.NEO)
				neo += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.NEO)
				neo += p2.getPontuacao();

			if (p1.getTipo() == TiposPersonagens.ORC)
				orc += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.ORC)
				orc += p2.getPontuacao();

			if (p1.getTipo() == TiposPersonagens.TRI)
				tri += p1.getPontuacao();

			if (p2.getTipo() == TiposPersonagens.TRI)
				tri += p2.getPontuacao();

		}

		return "MOR=" + mor + ", COP= " + cop + ", CAF= " + caf + ", NEO= " + neo + ", ORC= " + orc + ", TRI= " + tri;
	}

	@Override
	public int computarQuantidadeSuperPoderes() {

		int contador = 0;
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();

			if (p1.isSuperPoder())
				contador++;

			if (p2.isSuperPoder())
				contador++;
		}

		return contador;
	}

	@Override
	public String computarPersonagensComSuperPoderes() {
		String saida = "";

		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();

			if (p1.isSuperPoder())
				saida += p1.getNome();

			if (p2.isSuperPoder())
				saida += p2.getNome();
		}

		return saida;
	}

	@Override
	public int computarPersonagensVivos() {

		int vivos = 0;
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();

			if (p1.getPontuacao() >= 0)
				vivos++;
			
			if (p2.getPontuacao() >= 0)
				vivos++;
		}

		return vivos;
	}

	@Override
	public int computarPersonagensMortos() {
		int mortos = 0;
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();

			if (p1.getPontuacao() < 0)
				mortos++;
			
			if (p2.getPontuacao() < 0)
				mortos++;
		}

		return mortos;
	}

	@Override
	public String computarListaPersonagensVivos() {
	
		String vivos = "";
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();
			
			if (p1.getPontuacao() >= 0)
				vivos+=p1.getNome()+", ";
			
			if (p2.getPontuacao() >= 0)
				vivos+=p2.getNome()+", ";
		}

		return vivos;
	}

	@Override
	public String computarListaPersonagensMortos() {
		String mortos = "";
		for (CombateIndividual c : combatesIndividuais) {
			Personagem p1 = c.getPersonagem1();
			Personagem p2 = c.getPersonagem2();
			
			if (p1.getPontuacao() < 0)
				mortos+=p1.getNome()+", ";
			
			if (p2.getPontuacao() < 0)
				mortos+=p2.getNome()+", ";
		}

		return mortos;
	}

}
