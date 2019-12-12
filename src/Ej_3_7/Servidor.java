package Ej_3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
		int puerto = 6000;
		ServerSocket server = new ServerSocket(puerto);
		System.out.println("Escuchando en puerto: "+server.getLocalPort()+" ...");
		Socket cliente1= server.accept();
		Numero n =null;
		ObjectInputStream ent = new ObjectInputStream(cliente1.getInputStream());
		ObjectOutputStream fs = new ObjectOutputStream(cliente1.getOutputStream());
		do {
		//Entrada del cliente
				
				n = (Numero) ent.readObject();
				long cuadrado= (long) Math.pow(n.getNumero(), 2);
				long cubo = (long) Math.pow(n.getNumero(), 3);
				n.setCuadrado(cuadrado);
				n.setCubo(cubo);
		//Mensaje al cliente
		
		fs.writeObject(n);
		
		}while(n.getNumero()>0);
		System.out.println("Saliendo...");
		ent.close();
		fs.close();
		cliente1.close();
		server.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
