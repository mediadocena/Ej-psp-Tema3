package Ej_3_5;

import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		int nclientes = 0;
		int max=5;
		
		ArrayList<Socket>clientes = new ArrayList();
		ServerSocket server = new ServerSocket(puerto);
		System.out.println("Escuchando en puerto: "+server.getLocalPort()+" ...");
		
		do {
			nclientes++;
			Socket cliente=null;
			System.out.println("Esperando clientes...");
			cliente=server.accept();
			OutputStream sal= cliente.getOutputStream();
			DataOutputStream fs = new DataOutputStream(sal);
			fs.writeUTF("Nº Cliente: "+nclientes);
			sal.close();
			fs.close();
			cliente.close();
		
		}while(nclientes<max);
		
		
		/*
		//Entrada del cliente
		InputStream ent = null;
		ent = cliente1.getInputStream();
		DataInputStream dis = new DataInputStream(ent);
		System.out.println("Recibido mensaje del cliente: "+dis.readUTF());
		
		ent.close();
		dis.close();
		sal.close();
		fs.close();
		cliente1.close();*/
		server.close();
	
	}
}
