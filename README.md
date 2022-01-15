# Cola estática simple con Java

Una cola estática simple se construye con un arreglo, por lo que se considera como una estructura estática, tiene un tamaño definido para contener sus elementos, siendo una cola una estructura de datos que almacena elementos en una lista y permite acceder a los datos por uno de los dos extremos de la lista. Un elemento se inserta en la cola(parte final) de la lista y se suprime o elimina por el frente (parte inicial, frente) de la lista. Las aplicaciones utilizan una cola para almacenar elementos en su orden de aparición o concurrencia.
Una cola es una estructura de tipo **FIFO** (_first-in, firs-out_, primero en entrar-primero en salir o bien primero en llegar-primero en ser servido).

# Uso de este proyecto

Este proyecto fue desarrollado con la ayuda del IDE Eclipse, por lo tanto se recomienda abrirlo con el mismo.
Más detalles sobre la cola estática simple [aquí](https://gobitza.com/cola-estatica-simple-con-java/).

# Operaciones de una cola estática simple

## Cola llena

La cola esta llena cuando el posterior es igual al tamaño del arreglo menos uno.

```java
    public boolean estaLlena() {
		return posterior == tamanio - 1;
	}
```

## Cola vacía

La cola está vacía cuando el posterior es igual a menos uno.

```java
    public boolean estaVacia() {
		return posterior == -1;
	}
```

## Agregar elementos, encolar (enqueue)

Para agregar un elemento, primero tenemos que validar que la cola no este llena, sino esta llena, entonces agregamos el elemento en la posición del posterior incrementando en uno.

```java
    public void agregar(T elemento) {
		if(!estaLlena()) {
			this.cola[++posterior] = elemento;
		}else {
			System.out.println("Cola llena");
		}
	}
```

## Mostrar primer elemento sin quitarlo (peek)

Para mostrar el primer elemento sin quitarlo, es una tarea sencilla, validar que la cola no este vacía, sino lo esta, retornar el elemento que está en la posición cero del arreglo.

```java
    public T mostrar() {
		if(!estaVacia()) {
			return (T) this.cola[0];
		}
		System.out.println("Cola vac�a");
		return null;
	}
```

## Quitar el primer elemento

Si la cola no está vacía, guardar en una variable auxiliar el valor del elemento de la posición cero del arreglo. Posteriormente, desplazar los elementos restantes al frente en una posición y retornar el elemento guardado en la variable auxiliar.

```java
public T quitar() {
		if(!estaVacia()) {
			T elemento = mostrar();
			for(int i = 0; i < posterior; i++) {
				this.cola[i] = this.cola[i + 1];
			}
			this.cola[posterior--] = null;
			return elemento;
		}
		System.out.println("Cola vac�a");
		return null;
	}
```
