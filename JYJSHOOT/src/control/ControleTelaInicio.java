package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaHost;
import view.TelaInicio;
import view.TelaJoin;

public class ControleTelaInicio implements ActionListener{

	private TelaInicio telaInicio;
	
	public ControleTelaInicio(TelaInicio telaInicio) {
		this.telaInicio = telaInicio;
		this.telaInicio.getHostButton().addActionListener(this);
		this.telaInicio.getJoinButton().addActionListener(this);
		this.telaInicio.getExitButton().addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==telaInicio.getHostButton()){
			new TelaHost();
			telaInicio.dispose();}
		
		if(e.getSource()==telaInicio.getJoinButton()){
			new TelaJoin();
			telaInicio.dispose();
		}
		
		if(e.getSource()==telaInicio.getExitButton()){System.exit(0);}
	}
	
	
	
	
	
	
}
