package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import Main.Main;
import connection.Cliente;
import model.Inimigo;

public class ControleInimigo extends KeyAdapter implements ActionListener{

	private Inimigo inimigo;
	private Timer time;
	
	public ControleInimigo(Inimigo inimigo) {
		this.inimigo = inimigo;
		time = new Timer(10, this);
		time.start();
	}

	public void checarDano(){
		try {
			for(int i = 0 ; i < Main.personagem.getTirosUsuario().size();i++){
				if(inimigo.getArea().intersects(Main.personagem.getTirosUsuario().get(i).getX(),Main.personagem.getTirosUsuario().get(i).getY(),37,13)){
					Main.personagem.getTirosUsuario().remove(i);

					inimigo.dano();

					System.out.println("Azul Acertó");

					Cliente.enviarInimigo();
				}
			}
		} catch (Exception e) {}
	}

	public void checarDanoPersonagem(){
		try {
			for(int i = 0 ; i < inimigo.getTirosInimigo().size();i++){
				if(Main.personagem.getArea().intersects(inimigo.getTirosInimigo().get(i).getX(),inimigo.getTirosInimigo().get(i).getY(),37,13) ){
					inimigo.getTirosInimigo().remove(i);
					System.out.println("Rojo Acertó");
					Cliente.enviarInimigo();
				}
			}
		} catch (Exception e) {}

	}

	public void moverTiros(){
		/**
		 * Mueve los tiros del enemigo (Bloque Rojo)
		 */
		if (inimigo.getTirosInimigo()!=null){
			try {
				for(Point pontos : inimigo.getTirosInimigo()){
					pontos.x=pontos.x - 5;
				}

			} catch (Exception e) {
				moverTiros();
			}

			Cliente.enviarInimigo();

			try {
				for(int i = 0 ; i < inimigo.getTirosInimigo().size();i++){
					if(inimigo.getTirosInimigo().get(i).x<=0 ){
						inimigo.getTirosInimigo().remove(i);
						Cliente.enviarInimigo();
					}
				}
			} catch (Exception e) {
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			inimigo.setY(inimigo.getY()+4);

			if(inimigo.getY()>314){
				inimigo.setY(inimigo.getY()-4);
			}

			Cliente.enviarInimigo();
		}

		if (e.getKeyCode()==KeyEvent.VK_UP){
			inimigo.setY(inimigo.getY()-4);

			if(inimigo.getY()<5){
				inimigo.setY(inimigo.getY()+4);
			}
		}

		Cliente.enviarInimigo();

	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if(inimigo.getTirosInimigo().size()<=10){
				inimigo.getTirosInimigo().add(new Point(inimigo.getX()-37, inimigo.getY()+14));
    
				Cliente.enviarInimigo();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		checarDanoPersonagem();
		moverTiros();
		checarDano();

	}
}
