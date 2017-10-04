package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.event.PopupMenuListener;

import Controlador.Controlador;

import javax.swing.event.PopupMenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceBajaReserva extends JFrame {

	private JPanel contentPane;
	private JTextField tfFechaInicio;
	private JTable table;
	private JComboBox cboxTiposElementos;
	private JTextField tfIDElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceBajaReserva frame = new InterfaceBajaReserva();
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
	public InterfaceBajaReserva() {
		setTitle("Baja Reservas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cboxTiposElementos = new JComboBox();
		cboxTiposElementos.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				AgregarElementos();
			}
		});
		cboxTiposElementos.setModel(new DefaultComboBoxModel(new String[] {"Elementos Reserva"}));
		
		JLabel lblFechayHoraInicio = new JLabel("Fecha y Hora Inicio");
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setText("dd/mm/YYYY HH:MM");
		tfFechaInicio.setToolTipText("");
		tfFechaInicio.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBuscarReservas = new JButton("Buscar Reservas");
		btnBuscarReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BuscarReservas();
			}
		});
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		
		tfIDElemento = new JTextField();
		tfIDElemento.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cboxTiposElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFechayHoraInicio)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCancelarReserva)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBuscarReservas)
									.addGap(90))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
							.addGap(54))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboxTiposElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarReservas))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechayHoraInicio)
						.addComponent(tfFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelarReserva))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Seleccionar();
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void Seleccionar() {
		int i = table.getSelectedRow();
		if(i!=-1){
			
		tfIDElemento.setText(table.getValueAt(i, 0).toString());
		
	}
		}

	protected void BuscarReservas() {
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			java.util.Date FechaHoraIni=f.parse(this.tfFechaInicio.getText());
		} catch (ParseException e) {
			
			JOptionPane.showMessageDialog(null, "Falta la fecha y hora");
		}
		
	}

	protected void AgregarElementos() {
		Controlador ce = new Controlador();
		ResultSet rs=ce.AgregarTipos();
		
		cboxTiposElementos.removeAllItems();		
				
		try {
			while (rs.next())
			{
			try {
				
				cboxTiposElementos.addItem(rs.getString("NombreElemento"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
