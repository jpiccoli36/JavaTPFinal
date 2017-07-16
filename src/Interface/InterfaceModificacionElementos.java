package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Datos.DatosElementos;
import Entidades.Elemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceModificacionElementos extends JInternalFrame {

	Controlador control = new Controlador();
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

		JButton btnBuscar = new JButton("Buscar por ID");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarporID();
			}
		});

		JButton btnBuscarPorNombre = new JButton("Buscar por Nombre");
		btnBuscarPorNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BuscarporNombre();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
										.addComponent(lblCantidadElemento).addComponent(lblIdElemento))
								.addGap(33)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addComponent(btnModificar)
								.addGap(44).addComponent(btnBuscar).addGap(18).addComponent(btnBuscarPorNombre)))
				.addContainerGap(56, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(42)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre).addComponent(
						tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCantidadElemento)
						.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblIdElemento)
						.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(43)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnModificar)
						.addComponent(btnBuscar).addComponent(btnBuscarPorNombre))
				.addContainerGap(56, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void BuscarporNombre() {
		DatosElementos de = new DatosElementos();
		Elemento e = new Elemento();
		String nombre = tfNombreElemento.getText();
		ResultSet rs = de.ConsultaNombreElementos(nombre);
		try {
			rs.next();
			tfCantidadElemento.setText(rs.getString("CantidadElementos"));
			tfIDElemento.setText(rs.getString("idElementos"));

		} catch (SQLException e1) {

			e1.printStackTrace();

		}

	}

	protected void buscarporID() {

		DatosElementos de = new DatosElementos();
		Elemento e = new Elemento();		
			e.setId_elemento(Integer.parseInt(tfIDElemento.getText()));
			int id = Integer.parseInt(tfIDElemento.getText());
			ResultSet rs = de.ConsultaID(id);
			try {
				rs.next();

				tfCantidadElemento.setText(rs.getString("CantidadElementos"));
				tfNombreElemento.setText(rs.getString("NombreElemento"));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	

	protected void modificarclick() {
		Elemento e= new Elemento();
		DatosElementos de = new DatosElementos();
		e.setId_elemento(Integer.parseInt(tfIDElemento.getText()));
		e.setCantidad_elemento(Integer.parseInt(tfCantidadElemento.getText()));
		e.setNombre_elemento(tfNombreElemento.getText());
		control.Modifica(e);
		
		
	}
}
