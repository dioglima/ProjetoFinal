package apresentacao;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Botao extends JButton{
    public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("arial", Font.PLAIN,20));
	}
}
