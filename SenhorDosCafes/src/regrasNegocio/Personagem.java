package regrasNegocio;

import java.util.ArrayList;

public abstract class Personagem {

	private String nome;
	private int pontuacao;
	private boolean estaVivo;
	private TiposPersonagens tipo;
	private int forcaAtaque;
	private int forcaDefesa;
	private ArrayList<Integer> listaAtaques;
	private ArrayList<Integer> listaDefesas;
	private boolean superPoder = false;

	protected Personagem(TiposPersonagens tipo) {
		this.tipo = tipo;
		listaAtaques = new ArrayList<Integer>();
		listaDefesas = new ArrayList<Integer>();
	}

	public boolean isSuperPoder() {
		return superPoder;
	}

	public String getNome() {
		return nome;
	}

	public TiposPersonagens getTipo() {
		return tipo;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setNome(String nome) {
		if (!nome.equals(""))
			this.nome = nome;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public ArrayList<Integer> getAtaques() {
		return listaAtaques;
	}

	public ArrayList<Integer> getDefesas() {
		return listaDefesas;
	}
	
	public int getForcaAtaque() {
		return forcaAtaque;
	}

	public void setForcaAtaque(int forcaAtaque) {
		this.forcaAtaque = forcaAtaque;
	}

	public int getForcaDefesa() {
		return forcaDefesa;
	}

	public void setForcaDefesa(int forcaDefesa) {
		this.forcaDefesa = forcaDefesa;
	}

	public void addAtaque(int ataque) {
		if (ataque > 0 && ataque <= 50)
			this.listaAtaques.add(ataque);
	}

	public void addDefesa(int defesa) {
		if (defesa > 0 && defesa <= 50)
			this.listaDefesas.add(defesa);
	}

	public int tamanhoListaAcoes() {

		return listaAtaques.size();
	}

	public void verificarSuperAtaque() {

		for (int i = 0; i < listaAtaques.size(); i++) {
			if (superPoder) {
				listaAtaques.set(i, listaAtaques.get(i) * 2);
			}
			if (tipo.getNumeroEspecial() == listaAtaques.get(i)) {
				superPoder = true;
			}
		}
	}

}
