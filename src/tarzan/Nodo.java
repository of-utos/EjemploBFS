package tarzan;

/**
 * Clase que administra las posiciones de los nodos. <br>
 */
public class Nodo {
	/**
	 * Posición X del nodo. <br>
	 */
	private int posicionX;
	/**
	 * Posición Y del nodo. <br>
	 */
	private int posicionY;

	/**
	 * Crea un nodo. <br>
	 * 
	 * @param posicionX
	 *            Posición X del nodo. <br>
	 * @param posicionY
	 *            Posición Y del nodo. <br>
	 */
	public Nodo(final int posicionX, final int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	/**
	 * Devuelve la posición X del nodo. <br>
	 * 
	 * @return Posición X del nodo. <br>
	 */
	public int getPosicionX() {
		return posicionX;
	}

	/**
	 * Devuelve la posición Y del nodo. <br>
	 * 
	 * @return Posición Y del nodo. <br>
	 */
	public int getPosicionY() {
		return posicionY;
	}
}
