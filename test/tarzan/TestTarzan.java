package tarzan;

import java.io.File;

import org.junit.Test;

public class TestTarzan {

	private static final String PATH_ENTRADA = "Preparacion de prueba/Lote de prueba/Entrada";
	private static final String PATH_SALIDA = "Ejecucion de prueba/Salida obtenida";

	@Test
	public void testBase() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/00 Base.in"),
				new File(PATH_SALIDA + "/00 Base.out"));
		ejercicio.resolver();
	}

	@Test
	public void testNoRuta() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/01 No Ruta.in"),
				new File(PATH_SALIDA + "/01 No Ruta.out"));
		ejercicio.resolver();
	}

	@Test
	public void testDobleRuta() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/02 Doble ruta.in"),
				new File(PATH_SALIDA + "/02 Doble ruta.out"));
		ejercicio.resolver();
	}

	@Test
	public void testNormal() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/03 Normal.in"),
				new File(PATH_SALIDA + "/03 Normal.out"));
		ejercicio.resolver();
	}

	@Test
	public void testDosCaminos() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/04 Dos caminos.in"),
				new File(PATH_SALIDA + "/04 Dos caminos.out"));
		ejercicio.resolver();
	}

	@Test
	public void testPrimerNodo() {
		EjercicioOIA ejercicio = new Tarzan(new File(PATH_ENTRADA + "/05 Primer nodo.in"),
				new File(PATH_SALIDA + "/05 Primer nodo.out"));
		ejercicio.resolver();
	}
}