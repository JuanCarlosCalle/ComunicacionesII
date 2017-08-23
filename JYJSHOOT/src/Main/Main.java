package Main;

import connection.Cliente;
import connection.Server;
import model.Inimigo;
import model.Personagem;
import view.TelaInfo;
import view.TelaInicio;

public class Main {
	
	public static Cliente cliente;
	public static Server server;
	public static TelaInfo telaInfo;
	
	public static Personagem personagem = new Personagem(5);
	public static Inimigo inimigo = new Inimigo(1080);
	
	public static void main(String[] args) {
		new TelaInicio();
	}
}
