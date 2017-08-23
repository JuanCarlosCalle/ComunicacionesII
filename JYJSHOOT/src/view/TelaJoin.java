package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.ControleTelaJoin;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class TelaJoin extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField ipField;
	private JTextField portField;

	private JLabel ipLabel;
	private JLabel portLabel;

	private JButton conectarButton;
	private JButton backButton;

	private BackGround backGroundPanel;

	private ControleTelaJoin controleTelaJoin;

	public TelaJoin() {

		backGroundPanel = new BackGround("/TelaJoinBackground.png");
		backGroundPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(backGroundPanel);
		backGroundPanel.setLayout(null);

		ipLabel = new JLabel("IP:");
		ipLabel.setForeground(Color.YELLOW);
		ipLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		ipLabel.setBounds(7, 7, 31, 20);

		ipField = new JTextField();
		ipField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ipField.setBounds(47, 8, 148, 20);
		ipField.setColumns(10);

		portLabel = new JLabel("Port:");
		portLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		portLabel.setForeground(Color.YELLOW);
		portLabel.setBounds(7, 29, 47, 31);

		portField = new JTextField();
		portField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		portField.setText("25255");
		portField.setBounds(47, 33, 86, 20);
		portField.setColumns(10);
		portField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
				String caracteres = "0987654321";
				if (!caracteres.contains(ev.getKeyChar() + "")) {
					ev.consume();
				}
			}
		});

		conectarButton = new JButton("Conectar");
		conectarButton.setBounds(106, 64, 89, 23);

		backButton = new JButton("Atras");
		backButton.setBounds(7, 64, 89, 23);

		setTitle("Unirse");
		getContentPane().setLayout(new CardLayout(0, 0));

		backGroundPanel.add(ipLabel);
		backGroundPanel.add(ipField);
		backGroundPanel.add(portLabel);
		backGroundPanel.add(portField);
		backGroundPanel.add(conectarButton);
		backGroundPanel.add(backButton);

		controleTelaJoin = new ControleTelaJoin(this);

		setSize(206,94);
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}

	public ControleTelaJoin getControleTelaJoin() {
		return controleTelaJoin;
	}

	public String getIpField() {
		return ipField.getText();
	}

	public int getPortField() {
		return Integer.parseInt(portField.getText());
	}

	public JButton getConectarButton() {
		return conectarButton;
	}

	public JButton getBackButton() {
		return backButton;
	}



}
