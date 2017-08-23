package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.Main;
import control.ControleFase;

public class Fase extends JPanel{

	private static final long serialVersionUID = 1L;

	private ControleFase controleFase;

	private boolean host;

	private ArrayList<Point> tirosInimigo;

//	private ImageIcon personagemImagem;
	private ImageIcon personagemTiroImagem;
//	private ImageIcon inimigoImagem;
	private ImageIcon inimigoTiroImagem;
	private ImageIcon backGroundImagem;
	
	private  BufferedImage[] personagemSprites;
	private  BufferedImage[] inimigoSprites;
	
	private BufferedImage spriteSheet;
	
	private int personagemAparencia = 0;
	private int inimigoAparencia  = 0;
	
	public Fase(boolean host) {
		this.host = host;
		
		personagemSprites = new BufferedImage[8];
		inimigoSprites = new BufferedImage[8];
		
		try {
			spriteSheet = ImageIO.read(getClass().getResource("/PersonagemSprite.png"));
		} catch (IOException e1) {
			System.out.println("No se pudo cargar el Sprite del personaje");
			JOptionPane.showMessageDialog(this, "No se pudo cargar el Sprite del personaje");
			e1.printStackTrace();
		}
		
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 1; j++) {
				personagemSprites[(i * 1) + j] = spriteSheet.getSubimage(i * 40, j * 40, 40, 40);
			}
		}
		
		
		try {
			spriteSheet = ImageIO.read(getClass().getResource("/InimigoSprite.png"));
		} catch (IOException e) {
			System.out.println("No se pudo cargar la Sprite del Enemigo");
			JOptionPane.showMessageDialog(this, "No se pudo cargar la Sprite del Enemigo");
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 1; j++) {
				inimigoSprites[(i * 1) + j] = spriteSheet.getSubimage(i * 40, j * 40, 40, 40);
			}
		}
		
//		personagemImagem = new ImageIcon(getClass().getResource("/Personagem.png"));
		personagemTiroImagem = new ImageIcon(getClass().getResource("/TiroPersonagem.png"));

//		inimigoImagem = new ImageIcon(getClass().getResource("/Inimigo.png"));
		inimigoTiroImagem = new ImageIcon(getClass().getResource("/TiroInimigo.png"));

		backGroundImagem = new ImageIcon(getClass().getResource("/BackGround.png"));

		controleFase = new ControleFase(this);

		setSize(1124,358);
		setOpaque(false);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		
		/**
		 *Dibujo del personaje (Tank Verde)
		 */

		g.drawImage(personagemSprites[personagemAparencia],Main.personagem.getX(), Main.personagem.getY(),null);

		for(Point ponto : Main.personagem.getTirosUsuario()){
			g.drawImage(personagemTiroImagem.getImage(),ponto.x, ponto.y,null);
		}

		/**
		 * Dibujo del Enemigo (Tank Azul)
		 */

		g.drawImage(inimigoSprites[inimigoAparencia],Main.inimigo.getX(), Main.inimigo.getY(),null);

		for(Point ponto : Main.inimigo.getTirosInimigo()){
			g.drawImage(inimigoTiroImagem.getImage(),ponto.x, ponto.y,null);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(backGroundImagem.getImage(), 0, 0, this);
		super.paintComponent(g);
	}
	
	/**
	 * Gets
	 */
	
	public ControleFase getControleFase() {
		return controleFase;
	}

	public boolean isHost() {
		return host;
	}

	public ArrayList<Point> getTirosInimigo() {
		return tirosInimigo;
	}

	public int getPersonagemAparencia() {
		return personagemAparencia;
	}

	public void setPersonagemAparencia(int personagemAparencia) {
		this.personagemAparencia = personagemAparencia;
	}

	public int getInimigoAparencia() {
		return inimigoAparencia;
	}

	public void setInimigoAparencia(int inimigoAparencia) {
		this.inimigoAparencia = inimigoAparencia;
	}

	
	
}