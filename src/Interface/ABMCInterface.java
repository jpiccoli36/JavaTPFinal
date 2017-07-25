package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Entidades.Elemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMCInterface extends JInternalFrame {

	private JPanel contentPane;
	private Controlador ctr = new Controlador();
	private JTextField tFIdElemento;
	private JTextField tFNombreElemento;
	private JTextField tFCantElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCInterface frame = new ABMCInterface();
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
	public ABMCInterface() {
		setTitle("ABMCElementos");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID-Elemento");

		tFIdElemento = new JTextField();
		tFIdElemento.setColumns(10);

		JLabel lblNombreElemento = new JLabel("Nombre Elemento");

		tFNombreElemento = new JTextField();
		tFNombreElemento.setColumns(10);

		JLabel lblCantidadElemento = new JLabel("Cantidad Elemento");

		tFCantElemento = new JTextField();
		tFCantElemento.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarClick();
			}
		});

		JButton btnBaja = new JButton("Baja");
		btnBaja.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				bajaClick();
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				buscarClick();
			}
		});

		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarclick();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(tFNombreElemento, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNombreElemento)
												.addComponent(
														lblCantidadElemento)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(tFCantElemento,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(113).addComponent(btnAgregar))))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false).addGroup(
										gl_contentPane.createSequentialGroup().addGap(21).addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING).addComponent(lblId)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(tFIdElemento, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnBuscar))))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(99)
												.addComponent(btnModificar).addGap(18).addComponent(btnBaja,
														GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(116, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblId)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tFIdElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNombreElemento)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tFNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblCantidadElemento)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(tFCantElemento,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAgregar))
				.addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnModificar)
						.addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(46, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void modificarClick() {
		Elemento e = new Elemento();
		int k = Integer.parseInt(tFIdElemento.getText());
		e.setId_elemento(k);
		ctr.Modifica(e);

	}

	protected void bajaClick() {
		int id = Integer.parseInt(tFIdElemento.getText());
		//ctr.Baja(id);

	}

	protected void agregarclick() {
		Elemento e = new Elemento();
		e.setNombre_elemento(this.tFNombreElemento.getText());
		int id = Integer.parseInt(tFIdElemento.getText());	
		e.setId_elemento(id);
		int cant = Integer.parseInt(tFCantElemento.getText());
e.setCantidad_elemento(cant);
		ctr.Alta(e);

	}

	protected void buscarClick() {

		ctr.consulta();

	}
}
