package regrasNegocio;

import java.util.ArrayList;

public class CombateIndividual {

	private Personagem personagem1;
	private Personagem personagem2;
	private int codigo;
	private Batalha batalha;

	public CombateIndividual(Personagem m, Personagem c, int codigoCobate, int codigoBatalha) {
		this.personagem1 = m;
		this.personagem2 = c;
		this.codigo = codigoCobate;
		batalha = new Batalha(codigoBatalha);
	}

	public Personagem getPersonagem1() {
		return personagem1;
	}

	public Personagem getPersonagem2() {
		return personagem2;
	}

	public int getCodigo() {
		return codigo;
	}

	private void lutar(Personagem atacante, Personagem defensor) {

		ArrayList<Integer> deltas = new ArrayList<Integer>();
		for (int i = 0; i < atacante.getAtaques().size(); i++) {
			deltas.add(atacante.getAtaques().get(i) - defensor.getDefesas().get(i));
		}

		int atacantePontuacao = 0;
		int defesaPontuacao = 0;
		for (Integer d : deltas) {
			if (d > 0) {
				atacantePontuacao += d;
				defesaPontuacao -= d;
			} else if (d < 0) {
				defesaPontuacao += (d * -1);
				atacantePontuacao -= (d * -1);
			}
		}
		atacante.setPontuacao(atacante.getPontuacao() + (atacantePontuacao));
		defensor.setPontuacao(defensor.getPontuacao() + (defesaPontuacao));

	}

	public void computarLuta() {

		lutar(personagem1, personagem2);
		lutar(personagem2, personagem1);
	}
}
