package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Datos.DatosReserva;
import Entidades.Elemento;
import java.sql.Date;
import java.sql.Time;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DropMode;

public class InterfaceReserva extends JFrame {

	private JPanel contentPane;
	private JTextField tfFechayHoraIni;
	private JTextField tfFechayHoraFin;
	private JComboBox cboxTipos;
	private JTable table;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel lblElemento;
	private JLabel lblTipoElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceReserva frame = new InterfaceReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InterfaceReserva() {
		setTitle("Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tfFechayHoraIni = new JTextField();
		tfFechayHoraIni.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ShowBuscar();

			}
		});

		JLabel lblFechayHoraIni = new JLabel("Fecha y Hora Inicio");

		JLabel lblFechayHoraFin = new JLabel("Fecha y Hora Fin");

		tfFechayHoraFin = new JTextField();
		tfFechayHoraFin.setColumns(10);

		cboxTipos = new JComboBox();
		cboxTipos.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				AgregarElementos();

			}
		});
		cboxTipos.setModel(new DefaultComboBoxModel(new String[] { "Tipos Elementos" }));
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setColumns(10);
		
		lblElemento = new JLabel("Elemento");
		
		lblTipoElemento = new JLabel("Tipo Elemento");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechayHoraIni)
								.addComponent(lblFechayHoraFin))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfFechayHoraIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfFechayHoraFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(164)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuscar)
								.addComponent(cboxTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblElemento)
							.addGap(21)
							.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTipoElemento)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechayHoraIni)
						.addComponent(tfFechayHoraIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboxTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechayHoraFin)
						.addComponent(tfFechayHoraFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblElemento)
						.addComponent(lblTipoElemento)
						.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Agregar();
			}
		});
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void Agregar() {
		int i = table.getSelectedRow();
		if(i!=-1){
			
			textField1.setText(table.getValueAt(i, 0).toString());
			textField2.setText(table.getValueAt(i, 1).toString());
		}
		
	}


	protected void AgregarElementos() {
		Controlador ce = new Controlador();
		ResultSet rs = ce.AgregarTipos();

		cboxTipos.removeAllItems();

		try {
			while (rs.next()) {
				try {

					cboxTipos.addItem(rs.getString("NombreElemento"));
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void ShowBuscar() {		
		
		ResultSet rs=null;
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {

			java.util.Date FechaHoraIni=f.parse(this.tfFechayHoraIni.getText());
			java.util.Date FechaHoraFin =f.parse(this.tfFechayHoraFin.getText());
					
			
			Object TipoEl = cboxTipos.getSelectedItem();
			DatosReserva dr = new DatosReserva();
			
			rs=dr.ConsultaElementosDisponibles(FechaHoraIni,FechaHoraFin,TipoEl);

		} catch (ParseException e){
			JOptionPane.showMessageDialog(null, "Falta una fecha y hora");

		}
		DefaultTableModel dfm= new DefaultTableModel();	
		table = this.table;
		table.setModel(dfm);		
		dfm.setColumnIdentifiers(new Object[]{"Elementos Disponibles","Tipo Elemento"});				
			
				if(rs!=null ){
					try {
						while(rs.next()){
							dfm.addRow(new Object[]{(rs.getString("NombreElementoReserva")),rs.getString("TipoElemento")});							
							
						}						
						
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}					
					
				}
			//	01/01/2003 11:00
				
				
				
				
		
	}
}
