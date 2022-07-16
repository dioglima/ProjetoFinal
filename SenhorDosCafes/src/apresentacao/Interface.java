package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class Interface extends JFrame {
	
	public Interface() {
		organizador();
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public void organizador() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		Teclado teclado = new Teclado();
		Botao botao = new Botao("Salvar",Color.GRAY);
		add(display,BorderLayout.NORTH);
		add(teclado,BorderLayout.CENTER);
		add(botao,BorderLayout.SOUTH);
	}

}
