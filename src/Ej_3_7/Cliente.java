package Ej_3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Utiles.Salieri;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		try {
		Salieri ex = new Salieri();
		String host = "localhost";
		int puerto = 6000;
		Socket cliente= new Socket(host,puerto);
		int entrada = 1;
		ObjectOutputStream fs = new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
		do {
		
			entrada = ex.controlaenteroSt("Introduzca un numero, 0 para terminar");
			Numero n = new Numero(entrada,0,0);
			fs.writeObject(n);
			
			System.out.println("Respuesta del servidor: "+in.readObject());
			
		}while(entrada > 0);
		System.out.println("Saliendo...");
		in.close();
		fs.close();
		cliente.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
