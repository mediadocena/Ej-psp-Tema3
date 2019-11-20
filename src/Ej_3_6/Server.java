package Ej_3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
	public static void main(String[] args) throws IOException {
		
		DatagramSocket socket=new DatagramSocket(42345);
		System.out.println("Servidor esperando datagrama...");
		DatagramPacket recibo;
		String mensaje="";
		do{
			byte[] bufer=new byte[1024];
			recibo=new DatagramPacket(bufer, bufer.length);
		
			socket.receive(recibo);

			mensaje=new String(recibo.getData()).trim();
			System.out.println("Servidor recibe: "+mensaje);
			
			
			InetAddress IPOrigen=recibo.getAddress();
			int puerto=recibo.getPort();
			
			String respuesta=mensaje.toUpperCase();
			byte[] enviados=new byte[1024];
			enviados=respuesta.getBytes();
			
			DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPOrigen,puerto);
			socket.send(envio);
		
		}while(!mensaje.equalsIgnoreCase("*"));
		
		System.out.println("Saliendo...");
		socket.close();
	}

}
