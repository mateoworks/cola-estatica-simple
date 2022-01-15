package cola;

/**
 * Clase que implementa una cola estática simple FIFO
 * Usa un arreglo de objetos para almacenar los elementos
 * 
 * @param <T>	El tipo de dato del que será la pila
 * @author 		Mateo Mtz
 * @since 		1.0.0
 */
public class ColaEstaticaSimple<T> implements IColaEstatica<T>{
	private int posterior;
	private int tamanio;
	private Object cola[];
	public ColaEstaticaSimple(int n) {
		this.posterior = -1;
		this.tamanio = n;
		cola = new Object[n];
	}

	/**
	 * Comprueba si la cola esta llena
	 * @return verdadero si la cola esta llena
	 *         falso si no lo esta
	 */
	public boolean estaLlena() {
		return posterior == tamanio - 1;
	}
	
	/**
	 * Comprueba si la cola esta vacía
	 * @return verdadero si la cola esta vacía
	 *         falso si no lo esta
	 */
	public boolean estaVacia() {
		return posterior == -1;
	}
	
	/**
	 * Agrega un elemento a la cola
	 * @param elemento que se desea agregar
	 */
	public void agregar(T elemento) {
		if(!estaLlena()) {
			this.cola[++posterior] = elemento;
		}else {
			System.out.println("Cola llena");
		}
	}
	
	/**
	 * Muestra el primer elemento sin quitarlo
	 * @return primer elemento insertado, nulo si esta vacío
	 */
	@SuppressWarnings("unchecked")
	public T mostrar() {
		if(!estaVacia()) {
			return (T) this.cola[0];
		}
		System.out.println("Cola vacía");
		return null;
	}
	
	/**
	 * Quita el primer elemento de la lista
	 * @return primer elemento insertado, nulo si esta vacío
	 */
	public T quitar() {
		if(!estaVacia()) {
			T elemento = mostrar();
			for(int i = 0; i < posterior; i++) {
				this.cola[i] = this.cola[i + 1];
			}
			this.cola[posterior--] = null;
			return elemento;
		}
		System.out.println("Cola vacía");
		return null;
	}
	
	@Override
	public int numeroElementos() {
		return posterior + 1;
	}
	
	public String toString() {
		String cadena = "[";
		for(int i = 0; i < cola.length; i++) {
			if(cola.length - 1 == i) {
				cadena += cola[i] + "]";
			}else {
				cadena += cola[i] + ", ";
			}
		}
		return cadena;
	}
}
