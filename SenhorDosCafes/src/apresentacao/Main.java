package apresentacao;

import persistencia.DadosCombatentesDAO;
import regrasNegocio.Jogo;

public class Main {

	public static long consumoMemoria() {
		Runtime rt = Runtime.getRuntime();
		long memoria = rt.totalMemory();
		return memoria;
	}

	public static long consumoTempo() {
		long tempo = System.currentTimeMillis();
		return tempo;
	}

	public static void main(String[] args) {
		Interface inter = new Interface();

		long somatorioMemoria=0;
		long somatorioTempo=0;
		long mb = 1024 * 1024;
		for (int i = 0; i < 50; i++) {

			long memoriaInicial = consumoMemoria();
			long tempoInicial = consumoTempo();

			Jogo j = new Jogo();
			j.iniciar();
			DadosCombatentesDAO d = new DadosCombatentesDAO();
			

			long memoriaFinal = consumoMemoria();
			long tempoFinal = consumoTempo();

			
			System.out.println("Memoria gasta: " + (int) (memoriaFinal - memoriaInicial) / mb + " MB");
			System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + " milisegundos");
		
			
			 somatorioMemoria+=(memoriaFinal - memoriaInicial)/mb;			
			 somatorioTempo+=(tempoFinal - tempoInicial); 
		}
		System.out.println("Media final da memoria: "+ (int) (somatorioMemoria/50));
		System.out.println("Media final do tempo: "+  (somatorioTempo)/50);
	}

}
