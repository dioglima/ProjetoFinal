package regrasNegocio;

import java.util.ArrayList;

public class FabricaPersonagens {

	public Personagem getPersonagem(String tipos) {

		TiposPersonagens tipo = TiposPersonagens.valueOf(tipos);
		switch (tipo) {
		case MOR:
			return new Morfeu(tipo);
		case COP:
			return new Copinho(tipo);
		case CAF:
			return new Cafezito(tipo);
		case NEO:
			return new Neo(tipo);
		case ORC:
			return new Oraculo(tipo);
		case TRI:
			return new Trinity(tipo);

		default:
			return null;
		}

	}

	public Personagem criarPrimeiroPersonagem(ArrayList<String> linha) {

		Personagem p = this.getPersonagem(linha.get(3));
		p.setNome(linha.get(4));
		p.setForcaAtaque(Integer.parseInt(linha.get(5)));
		p.setForcaDefesa(Integer.parseInt(linha.get(6)));
		

		for (int i = 9; i < 19; i++) {
			p.addAtaque(Integer.parseInt(linha.get(i)) + p.getForcaAtaque());
		}

		for (int i = 19; i < 29; i++) {
			p.addDefesa(Integer.parseInt(linha.get(i)) + p.getForcaDefesa());
		}
		return p;
	}
	
	public Personagem criarSegundoPersonagem(ArrayList<String> linha) {

		Personagem p = this.getPersonagem(linha.get(5));
		p.setNome(linha.get(6));
		p.setForcaAtaque(Integer.parseInt(linha.get(7)));
		p.setForcaDefesa(Integer.parseInt(linha.get(8)));
		

		for (int i = 29; i < 39; i++) {
			p.addAtaque(Integer.parseInt(linha.get(i)) + p.getForcaAtaque());
		}

		for (int i = 39; i < 49; i++) {
			p.addDefesa(Integer.parseInt(linha.get(i)) + p.getForcaDefesa());
		}
		return p;
	}

}
