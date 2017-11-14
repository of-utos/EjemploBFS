package tarzan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tarzan extends EjercicioOIA {
	/**
	 * Nodos del grafo. <br>
	 */
	private ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	private ArrayList<Nodo> solucion = new ArrayList<Nodo>();
	/**
	 * Matriz de adyacencia del grafo. <br>
	 */
	private int[][] matrizAdyacencia;
	/**
	 * Camino a realizar. <br>
	 */
	private int[] recorrido;

	public Tarzan(final File entrada, final File salida) {
		super(entrada, salida);
		try {
			this.leerArchivo();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void leerArchivo() throws IOException {
		int costo;
		Scanner sc = new Scanner(super.entrada);
		while (sc.hasNextLine()) {
			nodos.add(new Nodo(sc.nextInt(), sc.nextInt()));
		}
		sc.close();
		matrizAdyacencia = new int[nodos.size()][nodos.size()];
		recorrido = new int[nodos.size()];
		for (int i = 0; i < nodos.size(); i++) {
			for (int j = 0; j < nodos.size(); j++) {
				costo = calcularCosto(nodos.get(i), nodos.get(j));
				if (costo <= 50) {
					matrizAdyacencia[i][j] = costo;
				} else {
					// SE CONSIDERA A 99 COMO INFINITO
					matrizAdyacencia[i][j] = 99;
				}
			}
		}
	}

	/**
	 * Calcula el costo de ir de un nodo a otro. <br>
	 * 
	 * @param origen
	 *            Nodo origen. <br>
	 * @param fin
	 *            Nodo fin. <br>
	 * @return Costo. <br>
	 */
	private int calcularCosto(final Nodo origen, final Nodo fin) {
		return (int) Math.sqrt((int) Math.pow((origen.getPosicionX() - fin.getPosicionX()), 2)
				+ (int) Math.pow((origen.getPosicionY() - fin.getPosicionY()), 2));
	}

	@Override
	public void resolver() {
		if (!hayRutaFin() || !hayRutaInicio()) {
			imprimir("NO HAY RUTA");
		} else {
			resolverBFS();
			armarCamino();
			imprimir();
		}
	}

	/**
	 * Graba el resultado final del recorrido. <br>
	 */
	private void imprimir() {
		try {
			PrintWriter pr = new PrintWriter(super.salida);
			for (Nodo nodo : this.solucion) {
				pr.println(nodo.getPosicionX() + " " + nodo.getPosicionY());
			}
			pr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Graba la salida con error. <br>
	 * 
	 * @param string
	 *            Mensaje de advertencia. <br>
	 */
	private void imprimir(String string) {
		try {
			PrintWriter pr = new PrintWriter(super.salida);
			pr.println(string);
			pr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Arma el camino. <br>
	 */
	private void armarCamino() {
		int i = nodos.size() - 1;
		solucion.add(nodos.get(i));
		while (recorrido[i] != -1) {
			i = recorrido[i];
			solucion.add(nodos.get(i));
		}
		Collections.reverse(solucion);
	}

	/**
	 * Resuelve el grafo usando el algoritmo de BFS. <br>
	 */
	private void resolverBFS() {
		Queue<Integer> cola = new LinkedList<Integer>();
		int[] vecDistancia = new int[nodos.size()];
		for (int i = 0; i < vecDistancia.length; i++) {
			vecDistancia[i] = -1;
			recorrido[i] = 0;
		}
		int nodoActual = 0;
		cola.add(nodoActual);
		vecDistancia[nodoActual] = 0;
		recorrido[nodoActual] = -1;
		while (!cola.isEmpty()) {
			if (tieneAdyacencia(nodoActual, vecDistancia)) {
				for (int i = 1; i < matrizAdyacencia.length; i++) {
					if (matrizAdyacencia[nodoActual][i] != 99 && vecDistancia[i] == -1) {
						cola.add(i);
						vecDistancia[i] = vecDistancia[nodoActual] + 1;
						recorrido[i] = nodoActual;
					}
				}
			} else {
				cola.poll();
				if (!cola.isEmpty()) {
					nodoActual = cola.peek();
				}
			}
		}
	}

	private boolean tieneAdyacencia(int nodoActual, int[] vecDistancia) {
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			if (matrizAdyacencia[nodoActual][i] != 99 && vecDistancia[i] == -1) {
				return true;
			}
		}
		return false;
	}

	private boolean hayRutaFin() {
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			if (i != (nodos.size() - 1) && matrizAdyacencia[nodos.size() - 1][i] != 99) {
				return true;
			}
		}
		return false;
	}

	private boolean hayRutaInicio() {
		for (int i = 1; i < matrizAdyacencia.length; i++) {
			if (matrizAdyacencia[0][i] != 99) {
				return true;
			}
		}
		return false;
	}
}
