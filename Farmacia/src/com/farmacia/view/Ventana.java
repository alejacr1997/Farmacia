package com.farmacia.view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.farmacia.controlador.Controller;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	JRadioButton cofarma;
	JRadioButton empsephar;
	JRadioButton cemefar;
	ButtonGroup groupButton;
	JTextField name;
	JComboBox<String> tipo;
	JTextField cantidad;
	JCheckBox principal;
	JCheckBox secundaria;
	
    public Ventana() {
        super("Solicitud Medicamentos");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(new Color(204, 255, 255));

        String[] opciones = { "Ninguno", "Analgésico","Analéptico","Anestésico","Antiácido","Antidepresivo","Antibióticos"};
        
        cofarma = new JRadioButton("Cofarma");
        empsephar = new JRadioButton("Empsephar");
        cemefar = new JRadioButton("Cemefar");
        groupButton = new ButtonGroup();
        groupButton.add(cofarma);
        groupButton.add(empsephar);
        groupButton.add(cemefar);
        
        JButton borrar = new JButton("Borrar");
        borrar.setBackground(Color.red);
        borrar.setOpaque(true);
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBackground(Color.green);
        confirmar.setOpaque(true);
        panel.setLayout(new GridLayout(0, 2, 2, 2));
        
        panel.add(new JLabel("Ingrese el nombre del medicamento:"));
        name = new JTextField();
        panel.add(name);
        
        panel.add(new JLabel("Selecciona el tipo de medicamento:"));
        tipo = new JComboBox<>(opciones);
        panel.add(tipo);
        
        panel.add(new JLabel("Digita el número de unidades:"));
        cantidad = new JTextField();
        panel.add(cantidad);
        
        panel.add(new JLabel("Escoga el distribuidor farmaceutico:"));
        panel.add(cofarma);
        panel.add(new JLabel());
        panel.add(empsephar);
        panel.add(new JLabel());
        panel.add(cemefar);
        
        panel.add(new JLabel("Eliga la sucursal:"));
        
        principal = new JCheckBox("Sucursal Principal");
        panel.add(principal);
        panel.add(new JLabel(""));
        secundaria = new JCheckBox("Sucursal Secundaria");
        panel.add(secundaria);
        panel.add(borrar);
        panel.add(confirmar);
        
        getContentPane().add(panel);
//        setVisible(true);
        
        borrar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onBorrar();
			}
		});
        
        confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onConfirmar(confirmar,groupButton, name, tipo, cantidad, principal, secundaria,cofarma,empsephar,cemefar);
			}
        	
        });
        
    }

	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	public void clearFields() {
		name.setText("");
		tipo.setSelectedIndex(0);
		cantidad.setText("");
		groupButton.clearSelection();
		principal.setSelected(false);
		secundaria.setSelected(false);
	}
}
