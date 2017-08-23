package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import connection.Cliente;
import view.TelaInicio;
import view.TelaJoin;

public class ControleTelaJoin implements ActionListener{
	
	private TelaJoin telaJoin;
	
	public ControleTelaJoin(TelaJoin telaJoin) {
		this.telaJoin = telaJoin;
		this.telaJoin.getConectarButton().addActionListener(this);
		this.telaJoin.getBackButton().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==telaJoin.getConectarButton()){
			Main.cliente = new Cliente(telaJoin.getIpField(), telaJoin.getPortField());
			Main.cliente.start();
			telaJoin.dispose();
			
		}
		if(e.getSource()==telaJoin.getBackButton()){
			new TelaInicio();
			telaJoin.dispose();
		}
		
	}
}
