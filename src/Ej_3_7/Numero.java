package Ej_3_7;

import java.io.Serializable;

public class Numero implements Serializable {
	
	int numero;
	long cuadrado;
	long cubo;
	
	public Numero(int numero, long cuadrado, long cubo) {
		super();
		this.numero = numero;
		this.cuadrado = cuadrado;
		this.cubo = cubo;
	}
	public Numero() {
		
	}
	
	@Override
	public String toString() {
		return "Numero [numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + "]";
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public long getCuadrado() {
		return cuadrado;
	}
	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}
	public long getCubo() {
		return cubo;
	}
	public void setCubo(long cubo) {
		this.cubo = cubo;
	}
	
}
