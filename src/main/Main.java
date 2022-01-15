package main;
import cola.ColaEstaticaSimple;
import cola.IColaEstatica;

public class Main {

	public static void main(String[] args) {
		IColaEstatica<Object> cola = new ColaEstaticaSimple<Object>(3);
		cola.agregar(1);
		cola.agregar(2);
		cola.agregar(3);
		cola.agregar(4);
		System.out.println(cola);
		System.out.println(cola.quitar());
		System.out.println(cola);
	}
}
