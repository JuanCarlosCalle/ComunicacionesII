package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Main.Main;
import control.ControleInimigo;
import control.ControlePersonagem;
import control.ControleTelaDaFase;

public class TelaDaFase extends JFrame {

	private static final long serialVersionUID = 1L;

	private Fase fase;

	private PainelInformacao painelUsuario;
	private PainelInformacao painelInimigo;

	private ControlePersonagem controlePersonagem;

	private ControleInimigo controleInimigo;

	private ControleTelaDaFase controleTelaDaFase;


	public TelaDaFase (boolean host) {
		
		getContentPane().setLayout(null);

		painelUsuario = new PainelInformacao("Esquerdo");
		painelUsuario.setLocation(0, 0);

		fase = new Fase(host);
		fase.setLocation(0, 171);
		if(host){
			controlePersonagem = new ControlePersonagem(Main.personagem);
			addKeyListener(controlePersonagem);
		}else{
			controleInimigo = new ControleInimigo(Main.inimigo);
			addKeyListener(controleInimigo);
		}
		
		painelInimigo = new PainelInformacao("Direito");
		painelInimigo.setLocation(0, 529);

		controleTelaDaFase = new ControleTelaDaFase(this);

		getContentPane().add(painelUsuario);
		getContentPane().add(fase);
		getContentPane().add(painelInimigo);

		setSize(1124,700);
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);

	}

	public ControleTelaDaFase getControleTelaDaFase() {
		return controleTelaDaFase;
	}

	public Fase getFase() {
		return fase;
	}

	public PainelInformacao getPainelUsuario() {
		return painelUsuario;
	}

	public PainelInformacao getPainelInimigo() {
		return painelInimigo;
	}

}
