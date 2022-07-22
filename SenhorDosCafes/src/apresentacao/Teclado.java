package apresentacao;

import java.awt.GridLayout;

import javax.swing.*;

public class Teclado extends JPanel  {

    private Display display;

    JLabel tipo = new JLabel("Tipo do personagem:");
    JLabel nome = new JLabel("Nome do Personagem:");
    JLabel forca = new JLabel("Força: ");
    JLabel defesa = new JLabel("Defesa:");
    JLabel somatorioForca = new JLabel("Somatorio Força:");
    JLabel somatorioDefesa = new JLabel("Somatorio Defesa:");

    public Teclado(){

        setLayout(new GridLayout(6,2));

        add(tipo, "1");
        add(criarTexto("",5));

        add(nome);
        add(criarTexto("",5));

        add(forca);
        add(criarTexto("",5));

        add(defesa);
        add(criarTexto("",5));

        add(somatorioForca);
        add(criarTexto("",5));

        add(somatorioDefesa);
        add(criarTexto("",5));
    }

    public JTextField criarTexto(String texto, int tamanho) {
		JTextField t = new JTextField(null,texto,tamanho);
		return t;
	}
}
