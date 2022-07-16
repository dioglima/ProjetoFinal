package regrasNegocio;

public enum TiposPersonagens {

	MOR("MOR", 7), 
	COP("COP", 2), 
	CAF("CAF", 5) ,
	NEO("NEO", 6), 
	ORC("ORC", 4), 
	TRI("TRI", 3);

	private String nome;
	private int numeroEspecial;
	

	TiposPersonagens(String nome, int numeroEspecial) {
		this.nome = nome;
		this.numeroEspecial = numeroEspecial;
		 
	}
	
	public int getNumeroEspecial() {
		return numeroEspecial;
	}

	
	
}
