package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import Main.Main;
import connection.Cliente;
import connection.Server;
import view.Fase;


public class ControleFase  implements ActionListener{

	private Fase fase;
	private Timer time;
	
	private int personagemY;
	private int inimigoY;
	
	
	public ControleFase(Fase fase) {
		this.fase = fase;
		time = new Timer(10, this);
		time.start();
		personagemY = Main.personagem.getY();
		inimigoY = Main.inimigo.getY();
	}
	
	public void mudarAparencia(){
		
		if(personagemY<Main.personagem.getY()){
			fase.setPersonagemAparencia(fase.getPersonagemAparencia()+1);
			if (fase.getPersonagemAparencia()>=9) {
				fase.setPersonagemAparencia(0);
			}
			personagemY = Main.personagem.getY();
		}
		if(personagemY>Main.personagem.getY()){
			fase.setPersonagemAparencia(fase.getPersonagemAparencia()-1);
			if (fase.getPersonagemAparencia()<=0) {
				fase.setPersonagemAparencia(8);
			}
			personagemY = Main.personagem.getY();
		}
		
		
		
		
		if(inimigoY<Main.inimigo.getY()){
			fase.setInimigoAparencia(fase.getInimigoAparencia()+1);
			if (fase.getInimigoAparencia()>=9) {
				fase.setInimigoAparencia(0);
			}
			inimigoY = Main.inimigo.getY();
		}
		if(inimigoY>Main.inimigo.getY()){
			fase.setInimigoAparencia(fase.getInimigoAparencia()-1);
			if (fase.getInimigoAparencia()<=0) {
				fase.setInimigoAparencia(8);
			}
			inimigoY = Main.inimigo.getY();
		}
		
	}

	public void checarVencedor(){

		if(Main.personagem.getHp()<=0){
			if(fase.isHost()){
				Server.enviarPersonagem();
				Main.telaInfo.setAreaInfo("Tank Azul Venció");
				Server.parar();
				Server.fecharConexao();
			}else{
				Cliente.parar();
				Cliente.fecharConexao();
			}
			JOptionPane.showMessageDialog(fase, "Tanke Azul Venció");
			System.exit(0);
		}
		
		if(Main.inimigo.getHp()<=0){
			if(fase.isHost()){
				Server.enviarPersonagem();
				Main.telaInfo.setAreaInfo("Tanke Verde Vence");
				Server.parar();
				Server.fecharConexao();
			}else{
				Cliente.parar();
				Cliente.fecharConexao();
			}
			JOptionPane.showMessageDialog(fase, "Tanke Verde Vence");
			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		mudarAparencia();
		checarVencedor();
		fase.repaint();
	}
}