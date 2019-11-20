package Ej_3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000;
		Socket cliente= new Socket(host,puerto);
		DataInputStream in = new DataInputStream(cliente.getInputStream());
		String cadena = in.readUTF();
		System.out.println(cadena);
		in.close();
		/*
		DataOutputStream fs = new DataOutputStream(cliente.getOutputStream());
		fs.writeUTF(cadena.toLowerCase());
		
		fs.close();*/
		cliente.close();
	}

}
