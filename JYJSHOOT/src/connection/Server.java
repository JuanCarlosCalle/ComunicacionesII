package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import Main.Main;
import model.Inimigo;
import model.Personagem;
import view.TelaDaFase;

public class Server extends Thread{

	private static ServerSocket serverSocket;

	private static Socket socket;

	private static ObjectOutputStream objectOutPS = null;

	private static ObjectInputStream objectInPS = null;

	private int port;

	private static boolean conectado = false;

	private static Loop loop;
	
	public Server(int port) {
		this.port = port;
	}

	public void run() {
		try {

			serverSocket = new ServerSocket(port);

			Main.telaInfo.trocaVisibilidade();

			conectado = true;

			Main.telaInfo.setAreaInfo("Server Creado");
			Main.telaInfo.setAreaInfo("Esperando Adversario");

		} catch (IOException e) {
			e.printStackTrace();
			conectado = false;
			JOptionPane.showMessageDialog(null, "No se puede conectar a Port: "+port+"\nPruebe otra vez");
		}

		try {

			socket = serverSocket.accept();

			Main.telaInfo.setAreaInfo("Conectando con: " +socket.getLocalAddress().getHostAddress());
			Main.telaInfo.setAreaInfo("Adversario Conectado con éxito;");

			new TelaDaFase(true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			objectInPS = new ObjectInputStream(socket.getInputStream());
			objectOutPS = new ObjectOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		loop = new Loop();
		loop.start();

		super.run();
	}

	public class Loop extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					if(socket.isConnected()){
						Inimigo inimigoRecebido = (Inimigo) objectInPS.readObject();
						if(inimigoRecebido!=null){
							Main.inimigo = inimigoRecebido;
							System.out.println("---------------------------------------------------------------------");
							System.out.println("ENEMIGO RECIBIDO");
							System.out.println("X :"+inimigoRecebido.getX());
							System.out.println("Y :"+inimigoRecebido.getY());
							System.out.println("HP : "+inimigoRecebido.getHp());
							System.out.println("---------------------------------------------------------------------"+"\n\n");
						}else {System.out.println("ENEMIGO NO RECIBIDO\n\n");}
					}else{
						Main.telaInfo.setAreaInfo("Adversario Desconectado");
						JOptionPane.showMessageDialog(null, "Adversario Desconectado");
						System.exit(0);
					}
				}catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
		

	public static void  enviarPersonagem(){

		Personagem personagemEnviar = Main.personagem;
		System.out.println("---------------------------------------------------------------------");
		System.out.println("PERSONALIZACIÓN ENVIAR");
		System.out.println("X :"+personagemEnviar.getX());
		System.out.println("Y :"+personagemEnviar.getY());
		System.out.println("Hp :"+personagemEnviar.getHp());
		System.out.println("---------------------------------------------------------------------"+"\n\n");

		try {
			objectOutPS.writeObject(personagemEnviar);
			objectOutPS.flush();
			objectOutPS.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void parar(){
		loop.stop();
	}
	
	public static void fecharConexao(){
		try {
			objectOutPS.close();
			objectInPS.close();
			socket.close();
			serverSocket.close();
			System.out.println("Servidor cerrado");
			Main.telaInfo.setAreaInfo("Cerrado.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se puede cerrar el servidor");
		}
	}

	public ObjectOutputStream getObjectOutPS() {
		return objectOutPS;
	}

	public ObjectInputStream getObjectInPS() {
		return objectInPS;
	}

	public static boolean isConectado() {
		return conectado;
	}

}