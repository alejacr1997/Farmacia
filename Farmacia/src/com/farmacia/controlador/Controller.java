package com.farmacia.controlador;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.farmacia.model.Utils;
import com.farmacia.view.Ventana;
import com.farmacia.view.VentanaResumen;

public class Controller {
	
	private Ventana ventana;
	private Utils utils;
	private VentanaResumen ventanaResumen;
	
	public Controller (Ventana ventana, Utils utils) {
		this.ventana = ventana;
		this.utils = utils;
	}
	
	public void onConfirmar(JButton confirmar, ButtonGroup groupButton, JTextField name, JComboBox<String> tipo, JTextField cantidad, JCheckBox principal, JCheckBox secundaria,JRadioButton cofarma, JRadioButton empsephar,JRadioButton cemefar) {
		ButtonModel selection = groupButton.getSelection();
		if(!utils.validateMedicamento(name.getText())) {
			JOptionPane.showMessageDialog(confirmar, "Escriba un nombre valido para el medicamento", "Error", JOptionPane.ERROR_MESSAGE);
		}else if (tipo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(confirmar, "Por favor eliga un tipo de medicamento", "Error", JOptionPane.ERROR_MESSAGE);
		}else if (!utils.validateQuantity(cantidad.getText())) {
			JOptionPane.showMessageDialog(confirmar, "Escriba un número valido para la cantidad de medicamento", "Error", JOptionPane.ERROR_MESSAGE);
		}else if(selection == null) {
			JOptionPane.showMessageDialog(confirmar, "Seleccione un distribuidor", "Error", JOptionPane.ERROR_MESSAGE);
		}else if(!principal.isSelected() && !secundaria.isSelected()) {
			JOptionPane.showMessageDialog(confirmar, "Seleccione una sucursal", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String textDistribuidor = utils.distribuidorSelected(selection,cofarma,empsephar,cemefar);
			this.ventanaResumen = new VentanaResumen(this,textDistribuidor,cantidad.getText(),tipo.getSelectedItem().toString(),name.getText(),principal.isSelected(),secundaria.isSelected());
			ventana.dispose();
		}
	}
	
	public void cancelar() {
		this.ventanaResumen.dispose();
	}
	
	public void aceptar(JButton confirmar) {
		System.out.println("Pedido enviado");
		JOptionPane.showMessageDialog(confirmar, "Pedido enviado");
		this.ventanaResumen.dispose();
	}
	
	public void onBorrar() {
		ventana.clearFields();
	}

}
