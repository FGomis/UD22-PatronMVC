package idk.MVCEj1;

import vistas.Vista;
import controladores.Controlador;
import modelos.Modelo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista, modelo);
		controlador.iniciarvista();
	}
}
