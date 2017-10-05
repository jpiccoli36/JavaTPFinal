package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Datos.DatosElementos;
import Datos.DatosReserva;

import javax.swing.event.PopupMenuEvent;

public class InterfaceBajaElementoReserva extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfNombreElemento;
	private JTextField tfIDElemento;
	private JComboBox cboxTipoElemento;
	private JButton btnMostrarElementos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceBajaElementoReserva frame = new InterfaceBajaElementoReserva();
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
	public InterfaceBajaElementoReserva() {
		setTitle("Baja Elemento Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Baja Elemento Reserva");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BajaElemento();
			}
		});
		
		cboxTipoElemento = new JComboBox();
		cboxTipoElemento.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				AgregarElementos();
			}
		});
		cboxTipoElemento.setModel(new DefaultComboBoxModel(new String[] {"Tipo Elementos"}));
		
		JScrollPane scrollPane = new JScrollPane();
		
		tfNombreElemento = new JTextField();
		tfNombreElemento.setEnabled(false);
		tfNombreElemento.setColumns(10);
		
		tfIDElemento = new JTextField();
		tfIDElemento.setEnabled(false);
		tfIDElemento.setColumns(10);
		
		JLabel lblIDElemento = new JLabel("IDElemento");
		
		JLabel lblNewLabel = new JLabel("Nombre Elemento");
		
		btnMostrarElementos = new JButton("Mostrar Elementos");
		btnMostrarElementos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MostrarLista();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblIDElemento)
					.addGap(17)
					.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMostrarElementos)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cboxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(122))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(cboxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnMostrarElementos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIDElemento)
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MostrarListaElementos();
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void MostrarLista() {
		ResultSet rs=null;				
		
		Object TipoEl = cboxTipoElemento.getSelectedItem();
		DatosElementos de = new DatosElementos();	
		rs=de.SeleccionarTiposElementos(TipoEl);
		
	
	DefaultTableModel dfm= new DefaultTableModel();	
	table = this.table;
	table.setModel(dfm);		
	dfm.setColumnIdentifiers(new Object[]{"Nombre Elemento","ID Elemento"});
	
		
			if(rs!=null ){
				
				try {
					while(rs.next()){
						dfm.addRow(new Object[]{(rs.getString("NombreElementoReserva")),rs.getString("IDElementosReserva")});				
						
					}						
					
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}					
				
			}			
			
			
	
}
		
		
	

	protected void MostrarListaElementos() {
		int i = table.getSelectedRow();
		if(i!=-1){
			
			tfNombreElemento.setText(table.getValueAt(i, 0).toString());
			tfIDElemento.setText(table.getValueAt(i, 1).toString());
		}
		
	}

	protected void BajaElemento() {
		
		
	}

	protected void AgregarElementos() {
		Controlador ce = new Controlador();
		ResultSet rs = ce.AgregarTipos();

		cboxTipoElemento.removeAllItems();

		try {
			while (rs.next()) {
				try {

					cboxTipoElemento.addItem(rs.getString("NombreElemento"));
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
