package view;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import control.ControleTelaInicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;

public class TelaInicio extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton hostButton;
	private JButton joinButton;
	private JButton exitButton;
	
	private BackGround backGroundPanel;
	
	private ControleTelaInicio controleTelaInicio;
	
	public TelaInicio() {
		
		setResizable(false);
		setSize(130,122);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		backGroundPanel = new BackGround("/TelaInicioBackground.png");
		backGroundPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(backGroundPanel, "name_12021345530869");
		
		
		hostButton = new JButton("Host");
		backGroundPanel.add(hostButton);
		hostButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		joinButton = new JButton("Unirse");
		backGroundPanel.add(joinButton);
		joinButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		exitButton = new JButton("Salir");
		backGroundPanel.add(exitButton);
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		controleTelaInicio = new ControleTelaInicio(this);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
	}

	public JButton getHostButton() {
		return hostButton;
	}

	public JButton getJoinButton() {
		return joinButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public ControleTelaInicio getControleTelaInicio() {
		return controleTelaInicio;
	}
	
	
}
