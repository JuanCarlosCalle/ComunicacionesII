package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;

public class PainelInformacao extends JPanel{
	private static final long serialVersionUID = 1L;

	private JLabel iconeDireita;

	private JLabel iconeEsquerda;

	private JProgressBar barraDeVida;

	private ImageIcon icone;

	private Image backGround;

	public PainelInformacao(String lado) {
		backGround = new ImageIcon(getClass().getResource("/PainelInformacaoBackground.png")).getImage();
		setSize(1124,171);
		setOpaque(false);
		setLayout(null);

		barraDeVida = new JProgressBar();
		barraDeVida.setBackground(Color.BLACK);
		barraDeVida.setForeground(Color.RED);
		barraDeVida.setBounds(398, 45, 329, 69);
		barraDeVida.setBorder(new LineBorder(new Color(0, 0, 0), 2));


		add(barraDeVida);

		setBorder(new LineBorder(new Color(0, 0, 0), 5));


		switch (lado){
		case "Esquerdo":{
			icone = new ImageIcon(getClass().getResource("/PersonagemIcon.png"));
			iconeEsquerda = new JLabel(icone);
			iconeDireita = new JLabel("");
			break;
		}
		case "Direito":{
			icone = new ImageIcon(getClass().getResource("/InimigoIcon.png"));
			iconeEsquerda = new JLabel();
			iconeDireita = new JLabel(icone);
			break;
		}
		}


		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 17, 340, 143);
		add(panel);

		panel.add(iconeEsquerda);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(774, 17, 340, 143);
		add(panel_1);

		panel_1.add(iconeDireita);
		panel_1.setLayout(new CardLayout(0, 0));

		switch (lado){
		case "Esquerdo":{
			panel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
			break;
		}
		case "Direito":{
			panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 2));
			break;
		}
		}
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, this);
		super.paintComponent(g);
	}

	public void setHp(int hp) {
		this.barraDeVida.setValue(hp);
	}
}
