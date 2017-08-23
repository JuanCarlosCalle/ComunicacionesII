package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class TelaInfo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField serverIpField;
	private JTextField portField;

	private BackGround backGroundPanel;

	private PainelStatus painelStatos;
	
	private JTextArea areaInfo;

	
	
	public TelaInfo(String ip, int port) {
		getContentPane().setLayout(new CardLayout(0, 0));

		backGroundPanel = new BackGround("/TelaInfoBackground.png");
		getContentPane().add(backGroundPanel, "name_13583885937509");
		backGroundPanel.setLayout(null);

		painelStatos = new PainelStatus();
		painelStatos.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		painelStatos.setBounds(10, 11, 424, 44);
		painelStatos.setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP:");
		lblServerIp.setBounds(10, 11, 75, 12);
		lblServerIp.setForeground(Color.YELLOW);
		lblServerIp.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		painelStatos.add(lblServerIp);

		serverIpField = new JTextField();
		serverIpField.setEditable(false);
		serverIpField.setBounds(80, 10, 109, 20);
		painelStatos.add(serverIpField);
		serverIpField.setColumns(10);
		serverIpField.setText(ip);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(236, 11, 46, 14);
		lblPort.setForeground(Color.YELLOW);
		lblPort.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		painelStatos.add(lblPort);

		portField = new JTextField();
		portField.setEditable(false);
		portField.setBounds(272, 10, 69, 20);
		painelStatos.add(portField);
		portField.setColumns(10);
		portField.setText(""+port);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 66, 424, 185);

		areaInfo = new JTextArea();
		areaInfo.setEditable(false);
		areaInfo.setBackground(Color.BLACK);
		areaInfo.setForeground(Color.GREEN);
		scrollPane.setViewportView(areaInfo);

		backGroundPanel.add(painelStatos);
		backGroundPanel.add(scrollPane);

		setResizable(false);
		setTitle("Informacion server");
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setSize(450,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
	
	
	private class PainelStatus extends JPanel{
		private static final long serialVersionUID = 1L;
		private Image backGround;
		public PainelStatus() {
			backGround = new ImageIcon(getClass().getResource("/TelaInfoPanelBackground.png")).getImage();
			 setOpaque(false);
		}
		public void paintComponent(Graphics g) {
			g.drawImage(backGround, 0, 0, this);
			super.paintComponent(g);
		}
	}

	public void trocaVisibilidade(){
		setVisible(!isVisible());
	}

	public void setServerIpField(String serverIpField) {
		this.serverIpField.setText(serverIpField);
	}

	public void setPortField(String portField) {
		this.portField.setText(portField);
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo.append("\n"+areaInfo);
	}

}
