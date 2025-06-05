package com.farmacia.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.farmacia.controlador.Controller;
import com.farmacia.model.Utils;

public class VentanaResumen extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Utils utils = new Utils();
	
	public VentanaResumen(Controller controller,String distribuidor, String unidades,
			String tipo, String nombre, boolean principal, boolean secundario) {
		super("Pedido al distribuidor "+distribuidor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(370, 250);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(15);
        flowLayout.setHgap(10);
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(new Color(204, 255, 255));
        String texto1 = unidades + " unidades del "+tipo+" "+nombre;
        panel.add(new JLabel(texto1));
        String texto2 = utils.generateTextAddress(principal, secundario);
        JTextArea address = new JTextArea(texto2);
        address.setPreferredSize(new Dimension(250,100));
        address.setLineWrap(true);
        address.setEditable(false);
        address.setWrapStyleWord(true);
        address.setBackground(new Color(204, 255, 255));
        panel.add(address);
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBackground(Color.red);
        cancelar.setOpaque(true);
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBackground(Color.green);
        confirmar.setOpaque(true);
        panel.add(new JLabel());
        panel.add(cancelar);
        panel.add(confirmar);
        getContentPane().add(panel);

        setVisible(true);
        
        cancelar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cancelar();
			}
		});
        
        confirmar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.aceptar(confirmar);
			}
		});
	}

}
