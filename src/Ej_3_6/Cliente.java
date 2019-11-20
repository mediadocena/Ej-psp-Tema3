package Ej_3_6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Utiles.Salieri;

public class Cliente {
	public static void main(String[]args) throws IOException {
		Salieri ex = new Salieri();

		DatagramSocket clientSocket=new DatagramSocket();
		
		InetAddress IPServidor=InetAddress.getLocalHost();
		int puerto=42345;
		String cadena="";
		do{
			cadena=ex.controlaStringSt("Introduce mensaje: ");
		
			byte[] enviados=new byte[1024];
			enviados=cadena.getBytes();
			
			DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPServidor,puerto);
			clientSocket.send(envio);

			byte[] recibidos=new byte[1024];
			DatagramPacket recibo=new DatagramPacket(recibidos, recibidos.length);
			System.out.println("Esperando datagrama...");
			clientSocket.setSoTimeout(4000);
			try{
				clientSocket.receive(recibo);
				String respuesta=new String(recibo.getData());
				System.out.println(respuesta);
			}catch (InterruptedIOException e) {
				System.out.println("Paquete no encontrado:(");
				cadena="*";
			}
		}while(!cadena.equalsIgnoreCase("*"));
	
		clientSocket.close();
	}
}
