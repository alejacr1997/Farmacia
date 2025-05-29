package com.farmacia.application;
import javax.swing.SwingUtilities;

import com.farmacia.controlador.Controller;
import com.farmacia.model.Utils;
import com.farmacia.view.Ventana;

public class Ejercicio {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		Utils utils = new Utils();
		Controller controller = new Controller(ventana,utils);
		SwingUtilities.invokeLater(()->{
			ventana.setController(controller);
			ventana.setVisible(true);
		});
	}

}
