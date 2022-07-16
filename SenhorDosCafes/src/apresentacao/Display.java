package apresentacao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel{
	
	private JLabel label;
	
	public Display() {
		
		label = new JLabel();
		label.setText("Cadastro de Informações");
		label.setFont(new Font("arial", Font.BOLD, 20));
		setBackground(Color.GREEN);
		add(label);
	}
	
	public void setLabel(String texto) {
		label.setText(texto);
	}

}
