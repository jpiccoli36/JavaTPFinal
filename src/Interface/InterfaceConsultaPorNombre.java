package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorElementos;
import Datos.DatosElementos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InterfaceConsultaPorNombre extends JInternalFrame {
	ControladorElementos control = new ControladorElementos();
	private JPanel contentPane;
	private JTextField tfNombreElemento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsultaPorNombre frame = new InterfaceConsultaPorNombre();
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
	public InterfaceConsultaPorNombre() {
		setTitle("Buscar por Nombre");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNombreElemento = new JLabel("Nombre Elemento");

		tfNombreElemento = new JTextField();
		tfNombreElemento.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				porNombreclick();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(21).addComponent(lblNombreElemento).addGap(38)
								.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(37).addComponent(btnConsultar))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(31).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(38, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(45)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNombreElemento)
								.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void porNombreclick() {
		DefaultTableModel dfm = new DefaultTableModel();
		table = this.table;
		table.setModel(dfm);
		dfm.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Cantidad" });
		DatosElementos da = new DatosElementos();
		String Nombre = tfNombreElemento.getText();
		ResultSet rs = da.ConsultaNombreElementos(Nombre);
		if (rs != null) {
			try {
				while (rs.next()) {
					dfm.addRow(new Object[] { Integer.parseInt(rs.getString("idElementos")),
							rs.getString("NombreElemento"), Integer.parseInt(rs.getString("CantidadElementos")) });

				}
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
