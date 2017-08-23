package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGround extends JPanel{

	private static final long serialVersionUID = 1L;

	private Image backGround;

	public BackGround(String localizacao) {
		backGround = new ImageIcon(getClass().getResource(localizacao)).getImage();
		 setOpaque(false);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, this);
		super.paintComponent(g);
	}
}
