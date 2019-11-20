package Ej_3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Utiles.Salieri;

public class Cliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Salieri ex = new Salieri();
		String host = "localhost";
		int puerto = 6000;
		Socket cliente= new Socket(host,puerto);
		
		DataOutputStream fs = new DataOutputStream(cliente.getOutputStream());
		fs.writeUTF(""+ex.controlaenteroSt("Numero a elevar al cuadrado"));
		DataInputStream in = new DataInputStream(cliente.getInputStream());
		System.out.println(in.readUTF());
		fs.close();
		in.close();
		cliente.close();
	}

}
