package Ej_3_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Utiles.Salieri;

public class Main {

	public static void main(String[] args) {
		Salieri ex = new Salieri();
		InetAddress[] direcciones = null;
		String dir = ex.controlaStringSt("Introduzca el nómbre de la máquina o direccion ip:");
		try {
			direcciones = InetAddress.getAllByName(dir);
			System.out.println("Direcciones ip de : "+dir);
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println(direcciones[i].toString());
				System.out.println("-----------------------------------");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
