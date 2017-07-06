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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceAltaElementos extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfIDElemento;
	private JTextField tfCantidad;
	ControladorElementos control= new ControladorElementos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAltaElementos frame = new InterfaceAltaElementos();
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
	public InterfaceAltaElementos() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Alta Elementos");
		setMaximizable(true);
		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombreElemento = new JLabel("Nombre Elemento");
		
		JLabel lblIdElemento = new JLabel("ID Elemento");
		
		JLabel lblCantidadElemento = new JLabel("Cantidad Elemento");
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		tfIDElemento = new JTextField();
		tfIDElemento.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setColumns(10);
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarclick();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCantidadElemento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombreElemento)
										.addComponent(lblIdElemento))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnAgregar)))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreElemento)
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdElemento)
						.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCantidadElemento)
						.addComponent(tfCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(btnAgregar)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	protected void agregarclick() {
		Elemento e = new Elemento();
		e.setNombre_elemento(this.tfNombre.getText());
		int id = Integer.parseInt(tfIDElemento.getText());
		
		int cant = Integer.parseInt(tfCantidad.getText());
		
		control.Alta(e);
		
	}

	

}
