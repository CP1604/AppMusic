package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuPrincipal;
	private JMenu mCliente, mVenta, mProducto, mOtros;
	private JMenuItem mniAltaCli, mniListadoCli;
	private JMenuItem mniCrearVenta, mniListadoVentas,mniListadoFechas;
	private JMenuItem mniAltaPro, mniListadoPro;
	private JRadioButtonMenuItem mniTiendaCutre,mniTiendaUniversidad;
	
	private JPanel contenedorPrincipal;
	
	private Registro pantallaRegistro;
	private Login pantallaLogin;
	
	public VentanaPrincipal(){
		setSize(Constantes.ventana_x_size,Constantes.ventana_y_size);
		setTitle("Aplicacion TIENDA");
		contenedorPrincipal= (JPanel) this.getContentPane();

		/*crear pantallas*/
		pantallaRegistro = new Registro(this);
		pantallaLogin = new Login(this);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		//Pantalla inicial
		setContentPane(pantallaLogin);

		setVisible(true);
	}
	
	/*Crea la barra del menu principal de la aplicaciï¿½n*/
	private void configurarMenu(){
		menuPrincipal=new JMenuBar(); //barra del menu
		//opciones principales
		mCliente= new JMenu("Cliente");	mVenta= new JMenu("Venta");
		mProducto= new JMenu("Producto"); mOtros= new JMenu("Otros");
		//Submenu cliente
		mniAltaCli= new JMenuItem("Alta de cliente");
		mniListadoCli= new JMenuItem("Listado de clientes");
		//Submenu venta
		mniCrearVenta= new JMenuItem("Crear Venta");
		mniListadoVentas= new JMenuItem("Listado de ventas");
		mniListadoFechas= new JMenuItem("Listado de un periodo");
		//*************************mascosas
		//Submenu producto
		mniAltaPro= new JMenuItem("Alta de Producto");
		mniListadoPro= new JMenuItem("Listado de Productos");
		//Submenu otros
		mniTiendaCutre= new JRadioButtonMenuItem("Ver tienda cutre");
		mniTiendaUniversidad= new JRadioButtonMenuItem("Ver tienda universitaria");
		mniTiendaUniversidad.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(mniTiendaCutre); buttonGroup.add(mniTiendaUniversidad);
		
		mCliente.add(mniAltaCli); mCliente.add(mniListadoCli);
		mVenta.add(mniCrearVenta); mVenta.add(mniListadoVentas); mVenta.add(mniListadoFechas);
		mProducto.add(mniAltaPro); mProducto.add(mniListadoPro);
		mOtros.add(mniTiendaCutre); mOtros.add(mniTiendaUniversidad);
		
		menuPrincipal.add(mCliente); 
		menuPrincipal.add(mVenta);
		menuPrincipal.add(mProducto); 
		menuPrincipal.add(mOtros);
		
		/*
		//Manejadores
		mniAltaCli.addActionListener(this);
		mniListadoCli.addActionListener(this);
		
		mniCrearVenta.addActionListener(this);
		mniListadoVentas.addActionListener(this);
		mniListadoFechas.addActionListener(this);
		
		mniAltaPro.addActionListener(this);
		mniListadoPro.addActionListener(this);
		
		mniTiendaCutre.addActionListener(this);
		mniTiendaUniversidad.addActionListener(this);
		*/
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();

	}
	 /*
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== mniAltaCli) { 
			setContentPane(pantallaRegistro);
			validate();
			return;	
		}
		
		if (e.getSource()== mniListadoCli) {
			VentanaListados lc= new VentanaListados("Listado de clientes");
			lc.setLocationRelativeTo(this);
			lc.setVisible(true);
			listadoClientes(lc.getTextArea());
			return;
		}
		
		if (e.getSource()== mniCrearVenta) {
			ControladorTienda.getUnicaInstancia().crearVenta();
			pantallaCrearVenta.cargarProductos(); //actualizar combobox con productos nuevos
			setContentPane(pantallaCrearVenta);
			validate();
			return;	
		}
		
		if (e.getSource()== mniListadoVentas) {
			VentanaListados lc= new VentanaListados("Listado de Ventas");
			lc.setLocationRelativeTo(this);
			lc.setVisible(true);
			listadoVentas(lc.getTextArea(),null,null);
			return;
		}

		if (e.getSource()== mniListadoFechas) {
			VentanaEntreFechas lef= new VentanaEntreFechas(this);
			lef.setLocationRelativeTo(this);
			lef.setVisible(true);
			return;
		}
		
		if (e.getSource()== mniAltaPro) { 
			setContentPane(pantallaLogin);
			validate();
			return;	
		}
		
		if (e.getSource()== mniListadoPro) {
			VentanaListados lc= new VentanaListados("Listado de Productos");
			lc.setLocationRelativeTo(this);
			lc.setVisible(true);
			listadoProductos(lc.getTextArea());
			return;
		}
		
		if (e.getSource()== mniTiendaCutre) {
			pantallaVerImagen.cambiarImagen("/fondoTienda.jpg");
			setContentPane(pantallaVerImagen);
			pack();
			return;
		}
		if (e.getSource()== mniTiendaUniversidad) {
			pantallaVerImagen.cambiarImagen("/otroFondoTienda.jpg");
			setContentPane(pantallaVerImagen);
			pack();
			return;
		}
	}
	
	public void listadoProductos(JTextArea listado) {
  		listado.setText("Codigo     Nombre                         Precio\n");
  		listado.append("---------- ------------------------------ --------\n");
  		
  		for (Producto p: ControladorTienda.getUnicaInstancia().getProductos()) {
  			String codigo=String.format("%1$10d",p.getCodigo());
  			String nombre=String.format("%1$-30s",p.getNombre());
  			String precio=String.format("%1$8.2f",p.getPrecio());
  			listado.append(codigo+" "+nombre+" "+precio+"\n");
  		}
  	}
	
	public void listadoClientes(JTextArea listado) {
  		List<Cliente> listaClientes = CatalogoClientes.getUnicaInstancia().getClientes();
  		listado.setText("dni        Nombre                         N.ventas\n");
  		listado.append("---------- ------------------------------ --------\n");
  		for (Cliente c: listaClientes) {
  			String dni=String.format("%1$-10s",c.getDni());
  			String nombre=String.format("%1$-30s",c.getNombre());
  			String numVentas=String.format("%1$-8s",String.valueOf(c.getVentas().size()));
  			listado.append(dni+" "+nombre+" "+numVentas+"\n");
  		}
	}
	public void listadoVentas(JTextArea listado, Date f1, Date f2) {
  		SimpleDateFormat datef = new SimpleDateFormat("dd/MMM/yyyy");
  		List<Venta> listaVentas;
  		if (f1==null) listaVentas = CatalogoVentas.getUnicaInstancia().getAllVentas();
  		else listaVentas = CatalogoVentas.getUnicaInstancia().getVentasPeriodo(f1, f2);
  		
  		listado.setText("fecha       Nombre                         Total\n");
  		listado.append("----------- ------------------------------ --------\n");
  		System.out.println("hay "+listaVentas.size());
  		for (Venta v: listaVentas) {
  			String fecha=datef.format(v.getFecha());
  			String nombre=String.format("%1$-30s",v.getCliente().getNombre());
  			String total=String.format("%1$-8s",String.valueOf(v.getTotal()));
  			listado.append(fecha+" "+nombre+" "+total+"\n");
  			mostrarVenta(v);
  		}
  	}
	private void mostrarVenta(Venta v) {
  		System.out.println("-------------------------------------------------------------");
  		System.out.println("Fecha:"+v.getFecha());
  		System.out.println("Dni:"+v.getCliente().getDni());
  		for(LineaVenta lv:v.getLineasVenta()){
  			System.out.println(""+lv.getUnidades()+" "+lv.getProducto().getNombre()+" "+lv.getSubTotal());
  		}
  		System.out.println("Total:"+v.getTotal());
  	}
  	*/

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
