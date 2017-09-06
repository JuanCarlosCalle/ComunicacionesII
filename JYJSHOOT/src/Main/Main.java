package Main;

import connection.Cliente;
import connection.Server;
import model.Enemigo;
import model.Personaje;
import view.TelaInfo;
import view.TelaInicio;

public class Main {
	
	public static Cliente cliente;
	public static Server server;
	public static TelaInfo telaInfo;
	
	public static Personaje personagem = new Personaje(5);
	public static Enemigo inimigo = new Enemigo(1080);
	
	public static void main(String[] args) {
		new TelaInicio();
	}
}
