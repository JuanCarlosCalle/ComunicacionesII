package view;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.ControleTelaHost;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class TelaHost extends JFrame{
	private static final long serialVersionUID = 1L;

	private String ip = "";

	private JTextField portField;

	private JLabel portLabel;

	private JButton connectButton;
	private JButton backButton;

	private BackGround backGroundPanel;

	private ControleTelaHost controleTelaHost;

	public TelaHost() {

		backGroundPanel = new BackGround("/TelaHostBackground.png");
		backGroundPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(backGroundPanel);
		backGroundPanel.setLayout(null);

		portLabel = new JLabel("Port:");
		portLabel.setForeground(Color.YELLOW);
		backGroundPanel.add(portLabel);
		portLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		portLabel.setBounds(10, 11, 45, 23);

		portField = new JTextField();
		portField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backGroundPanel.add(portField);
		portField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
				String caracteres = "0987654321";
				if (!caracteres.contains(ev.getKeyChar() + "")) {
					ev.consume();
				}
			}
		});
		portField.setBounds(65, 13, 105, 20);
		portField.setColumns(10);
		portField.setText("25255");

		connectButton = new JButton("Conectar");
		backGroundPanel.add(connectButton);
		connectButton.setBounds(186, 12, 85, 23);

		backButton = new JButton("Atras");
		backGroundPanel.add(backButton);
		backButton.setBounds(281, 12, 69, 23);

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No hay conexión a Internet o no se pudo encontrar la IP");
		} 

		setTitle("Servidor - "+ ip);
		getContentPane().setLayout(new CardLayout(0, 0));

		controleTelaHost = new ControleTelaHost(this);

		setSize(360,47);
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);

	}

	public ControleTelaHost getControleTelaHost() {
		return controleTelaHost;
	}

	public int getPortField() {
		return Integer.parseInt(portField.getText());
	}

	public void setPortField(JTextField portField) {
		this.portField = portField;
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public String getIp() {
		return ip;
	}


}
