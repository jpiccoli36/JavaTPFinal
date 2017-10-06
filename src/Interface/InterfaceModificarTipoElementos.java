package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Datos.DatosElementos;
import Entidades.Elemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InterfaceModificarTipoElementos extends JInternalFrame {

	Controlador control = new Controlador();
	private JPanel contentPane;
	private JTextField tfNombreElemento;
	private JTextField tfCantidadElemento;
	private JTextField tfIDElemento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceModificarTipoElementos frame = new InterfaceModificarTipoElementos();
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
	public InterfaceModificarTipoElementos() {
		setTitle("Modifcar Elementos");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 422);
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
		tfIDElemento.setEnabled(false);
		tfIDElemento.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarclick();
			}
		});

		JButton btnBuscar = new JButton("Buscar Tipo Elementos");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarElemento();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCantidadElemento).addComponent(lblNombre).addComponent(lblIdElemento))
						.addGap(45)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(
												tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
										.addComponent(btnModificar).addGap(23))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(184, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnBuscar))
						.addContainerGap(57, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCantidadElemento)
										.addComponent(tfCantidadElemento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblIdElemento)
								.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnBuscar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE)));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SeleccionarElemento();
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void SeleccionarElemento() {
		int i = table.getSelectedRow();
		if (i != -1) {

			tfCantidadElemento.setText(table.getValueAt(i, 2).toString());
			tfNombreElemento.setText(table.getValueAt(i, 1).toString());
			tfIDElemento.setText(table.getValueAt(i, 0).toString());
		}

	}

	protected void buscarElemento() {

		Elemento e = new Elemento();
		DatosElementos de = new DatosElementos();

		ResultSet rs = de.ConsultaTodosTiposElementos();
		try {
			DefaultTableModel dfm = new DefaultTableModel();
			table = this.table;
			table.setModel(dfm);
			dfm.setColumnIdentifiers(
					new Object[] { "ID Tipo Elemento", "Nombre Tipo Elemento", "Cantidad Tipo Elemento" });

			if (rs != null) {
				try {
					while (rs.next()) {
						dfm.addRow(new Object[] { (Integer.parseInt(rs.getString("idElementos"))),
								(rs.getString("NombreElemento")), rs.getString("CantidadElementos") });

					}

				} catch (SQLException w) {

					w.printStackTrace();
				}
			}
			
		} catch (Exception w) {

			w.printStackTrace();
		}
			}

	protected void modificarclick() {
		Elemento e = new Elemento();
		DatosElementos de = new DatosElementos();
		e.setId_elemento(Integer.parseInt(tfIDElemento.getText()));
		e.setCantidad_elemento(Integer.parseInt(tfCantidadElemento.getText()));
		e.setNombre_elemento(tfNombreElemento.getText());
		de.ModificarTipoElementos(e);
		JOptionPane.showMessageDialog(null, "Se Modifico el Tipo Elemento");

	}
}