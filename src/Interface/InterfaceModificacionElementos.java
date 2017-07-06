package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorElementos;
import Elementos.Elemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceModificacionElementos extends JInternalFrame {

	ControladorElementos control = new ControladorElementos();
	private JPanel contentPane;
	private JTextField tfNombreElemento;
	private JTextField tfCantidadElemento;
	private JTextField tfIDElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceModificacionElementos frame = new InterfaceModificacionElementos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceModificacionElementos() {
		setTitle("Modifcar Elementos");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre Elemento");
		
		JLabel lblCantidadElemento = new JLabel("Cantidad Elemento");
		
		JLabel lblIdElemento = new JLabel("ID Elemento");
		
		tfNombreElemento = new JTextField();
		tfNombreElemento.setColumns(10);
		
		tfCantidadElemento = new JTextField();
		tfCantidadElemento.setColumns(10);
		
		tfIDElemento = new JTextField();
		tfIDElemento.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarclick();
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consultaclick();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblCantidadElemento)
								.addComponent(lblIdElemento))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(btnModificar)
							.addGap(44)
							.addComponent(btnBuscar)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadElemento)
						.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdElemento)
						.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnBuscar))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void consultaclick() {
		Elemento e = new Elemento();
		int id= Integer.parseInt(this.tfIDElemento.getText());
		e.setId_elemento(id);
		control.Porid(e);
		
	}

	protected void modificarclick() {
		Elemento e = new Elemento();
		int id= Integer.parseInt(this.tfIDElemento.getText());
		e.setId_elemento(id);
		e.setNombre_elemento(this.tfNombreElemento.getText());
		int cant= Integer.parseInt(this.tfCantidadElemento.getText());
		e.setCantidad_elemento(cant);
		control.Modifica(e);
		
	}

}
