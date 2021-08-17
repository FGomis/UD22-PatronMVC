package controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vistas.Vista;
import modelos.Modelo;

public class Controlador implements ActionListener{
	
//	Atributos
	private Vista vista;
	private Modelo modelo;
	
//	Constructor principal
	public Controlador(Vista vista, Modelo modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.añadirCliente.addActionListener(this);
		this.vista.consultarClientes.addActionListener(this);
		this.vista.eliminarCliente.addActionListener(this);
		this.vista.actualizarCliente.addActionListener(this);
	}

//	Método para iniciar la vista
	public void iniciarvista() {
		vista.setTitle("Clientes");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		vista.setPreferredSize(new Dimension(400, 300));
	}
	
//	Método que realiza el CRUD dependiendo del botón seleccionado
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
//		Filtramos la fuente del evento para saber que función del CRUD debemos realizar
		if (vista.añadirCliente == e.getSource()) {
//			Llamamos al método del CRUD correspondiente con los datos que hay introducidos en la vista
			modelo.insertData("clientes", "clientes", vista.nombre.getText(), vista.apellidos.getText(), vista.direccion.getText(), vista.dni.getText());
		} else if(vista.consultarClientes == e.getSource()) {
			modelo.selectData("clientes", "clientes");
		} else if(vista.eliminarCliente == e.getSource()) {
			modelo.deleteData("clientes", "clientes");
		} else if(vista.actualizarCliente == e.getSource()) {
			modelo.updateData("clientes", "clientes", vista.nombre.getText(), vista.apellidos.getText(), vista.direccion.getText(), vista.dni.getText());
		}
	}

}
