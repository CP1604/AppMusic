package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

	public class Registro extends JPanel {
		private VentanaPrincipal ventana;
		private JPanel jpanelAnterior;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JPasswordField passwordField;
		private JPasswordField passwordField_1;

	public Registro(VentanaPrincipal ventanaPrincipal) {
		ventana = ventanaPrincipal;
		crearPantalla();
	}
	
	public void crearPantalla() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 70, 47, 14);
		add(lblNombre);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(21, 95, 114, 14);
		add(lblTelfono);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(21, 120, 114, 14);
		add(lblFechaNacimiento);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 145, 47, 14);
		add(lblEmail);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(21, 170, 47, 14);
		add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(21, 198, 47, 14);
		add(lblClave);
		
		JLabel lblClave_1 = new JLabel("Repite");
		lblClave_1.setBounds(251, 198, 47, 14);
		add(lblClave_1);
		
		textField = new JTextField();
		textField.setBounds(145, 67, 250, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 92, 250, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 117, 153, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 142, 153, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 167, 153, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 195, 96, 20);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(311, 195, 84, 20);
		add(passwordField_1);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(145, 244, 96, 23);
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(251, 244, 87, 23);
		add(btnCancelar);
		jpanelAnterior = (JPanel) ventana.getContentPane();
		
		ventana.setContentPane(this);
		
		JLabel lblRegistroDeUsuarios = new JLabel("Registro de Usuarios");
		lblRegistroDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistroDeUsuarios.setBounds(121, 11, 234, 32);
		add(lblRegistroDeUsuarios);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(403, 70, 47, 14);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(403, 95, 47, 14);
		add(label_1);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(308, 145, 47, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(308, 170, 47, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(405, 198, 47, 14);
		add(label_5);
		
		JLabel lblLosCampos = new JLabel("* Los campos indicados son obligatorios");
		lblLosCampos.setForeground(Color.RED);
		lblLosCampos.setBounds(145, 219, 250, 14);
		add(lblLosCampos);
		ventana.revalidate(); /*redibujar con el nuevo JPanel*/
		ventana.repaint();
		
		//manejadores
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setContentPane(jpanelAnterior);
				ventana.setTitle("Login Gestor Eventos");	
				ventana.revalidate();
			}
		});
	}
}

