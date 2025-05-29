package com.farmacia.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public class Utils {

	public boolean validateMedicamento(String name) {
		String pattern = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s]+$";
		Pattern patron = Pattern.compile(pattern);
		Matcher matcher = patron.matcher(name);
		return matcher.matches() && !name.isEmpty();
	}
	
	public boolean validateQuantity(String value) {
		String pattern = "^[0-9]+$";
		Pattern patron = Pattern.compile(pattern);
		Matcher matcher = patron.matcher(value);
		return matcher.matches();
	}
	
	public String generateTextAddress(boolean principal, boolean secundaria) {
		String response = "Para la farmacia situada en ";
		if (principal && secundaria) {
			response += "Calle de la Rosa n.28 y para la situada en Calle Alcazabilla n.3";
		}else if(principal) {
			response  += "Calle de la Rosa n.28";
		}else {
			response += "Calle Alcazabilla n.3";
		}
		return response;
	}

	public String distribuidorSelected(ButtonModel selection, JRadioButton cofarma, JRadioButton empsephar,
			JRadioButton cemefar) {
		if (selection == cofarma.getModel()) {
			return cofarma.getText();
		}else if (selection == empsephar.getModel()) {
			return empsephar.getText();
		}else {
			return cemefar.getText();
		}
	}
	
	
}
