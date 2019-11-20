package Ej_3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000;
		Socket cliente= new Socket(host,puerto);
		InetAddress i = cliente.getInetAddress();
		System.out.println("Puerto local: "+cliente.getLocalPort());
		System.out.println("Puerto remoto: "+cliente.getPort());
		System.out.println("Nombre del host/IP: "+cliente.getInetAddress());
		System.out.println("Host remoto: "+i.getHostName().toString());
		System.out.println("IP host remoto: "+i.getHostAddress().toString());
		cliente.close();
	}

}
