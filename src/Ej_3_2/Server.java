package Ej_3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		ServerSocket server = new ServerSocket(puerto);
		System.out.println("Escuchando en puerto: "+server.getLocalPort()+" ...");
		Socket cliente1= server.accept();
		System.out.println("Puerto remoto del cliente 1: "+cliente1.getPort());
		System.out.println("Puerto local del cliente 1: "+cliente1.getLocalPort());
		Socket cliente2 = server.accept();
		System.out.println("Puerto remoto del cliente 2: "+cliente2.getPort());
		System.out.println("Puerto local del cliente 2: "+cliente2.getLocalPort());
	}

}
