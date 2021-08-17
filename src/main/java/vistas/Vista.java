package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame{
	
	public JPanel contentPane;
	public JTextField nombre;
	public JTextField apellidos;
	public JTextField direccion;
	public JTextField dni;
	public JButton añadirCliente;
	public JButton consultarClientes;
	public JButton eliminarCliente;
	public JButton actualizarCliente;
	
	public Vista() {
		setBounds(100, 100, 386, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 348, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(21, 48, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(21, 103, 76, 14);
		panel.add(lblNewLabel_1);
		
		apellidos = new JTextField();
		apellidos.setBounds(166, 100, 136, 20);
		panel.add(apellidos);
		apellidos.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(166, 45, 136, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(166, 149, 136, 20);
		panel.add(direccion);
		direccion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección:");
		lblNewLabel_2.setBounds(21, 152, 76, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setBounds(21, 205, 76, 14);
		panel.add(lblNewLabel_3);
		
		dni = new JTextField();
		dni.setBounds(166, 202, 136, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		añadirCliente = new JButton("Añadir cliente");
		añadirCliente.setBounds(21, 280, 136, 23);
		panel.add(añadirCliente);
		
		consultarClientes = new JButton("Consultar clientes");
		consultarClientes.setBounds(182, 280, 145, 23);
		panel.add(consultarClientes);
		
		eliminarCliente = new JButton("Eliminar Cliente");
		eliminarCliente.setBounds(21, 336, 136, 23);
		panel.add(eliminarCliente);
		
		actualizarCliente = new JButton("Actualizar cliente");
		actualizarCliente.setBounds(182, 336, 145, 23);
		panel.add(actualizarCliente);
	}
}
