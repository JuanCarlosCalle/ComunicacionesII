package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Main.Main;
import view.TelaDaFase;

public class ControleTelaDaFase implements ActionListener{

	private TelaDaFase telaDaFase;
	private Timer time;

	public ControleTelaDaFase(TelaDaFase telaDaFase) {
		this.telaDaFase = telaDaFase;
		time = new Timer(10, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		telaDaFase.getPainelUsuario().setHp(Main.personagem.getHp());
		telaDaFase.getPainelInimigo().setHp(Main.inimigo.getHp());
	}

}
