package gui;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Login extends JPanel {

	private VentanaPrincipal ventanaPrincipal;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		crearPantalla();
	}

	/**
	 * Initialize the contents of the ventanaPrincipal.
	 */
	private void crearPantalla() {

		setBounds(100, 100, 600, 400);
		setLayout(null);
		
		JLabel lblAppchat = new JLabel("AppChat");
		lblAppchat.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblAppchat.setBounds(208, 11, 158, 90);
		add(lblAppchat);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(107, 115, 51, 14);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(88, 146, 70, 14);
		add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(189, 112, 261, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 143, 261, 20);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(107, 215, 87, 23);
		add(btnLogin);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(216, 215, 93, 23);
		add(btnRegistro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(363, 215, 87, 23);
		add(btnCancelar);
		
		
		//Manejadores
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.dispose(); 
				System.exit(0);  /*no seria necesario en este caso*/
			}
		});
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setTitle("Registro de Usuario");
				new Registro(ventanaPrincipal);
			}
		});
	}
	
	public void mostrarVentana() {
		ventanaPrincipal.setVisible(true);
	}
}

