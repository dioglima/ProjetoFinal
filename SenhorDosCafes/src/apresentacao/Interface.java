package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Interface extends JFrame implements ActionListener {
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
