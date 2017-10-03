package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Datos.DatosReserva;
import Entidades.Elemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.DefaultComboBoxModel;

public class InterfaceReserva extends JFrame {

	private JPanel contentPane;
	private JTextField tffecha;
	private JTextField tfHora;
	private JComboBox cboxTipos;

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

	/**
	 * Create the frame.
	 */
	public InterfaceReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tffecha = new JTextField();
		tffecha.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ShowBuscar();

			}
		});

		JLabel lblFecha = new JLabel("Fecha");

		JLabel lblHora = new JLabel("Hora");

		tfHora = new JTextField();
		tfHora.setColumns(10);

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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(34)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblFecha)
								.addComponent(lblHora))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tffecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(64)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnBuscar)
								.addComponent(cboxTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(128, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(44)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFecha)
								.addComponent(tffecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cboxTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblHora)
								.addComponent(tfHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addContainerGap(136, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
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
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

		try {

			java.sql.Time hora = Time.valueOf(this.tfHora.getText());

			java.util.Date fechaHora = f.parse(this.tffecha.getText());
			System.out.println(fechaHora);
			System.out.println(hora);
			Object TipoEl = cboxTipos.getSelectedItem();
			DatosReserva dr = new DatosReserva();
			dr.ConsultaElementosDisponibles(hora,fechaHora,TipoEl);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Falta la fecha");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falta la hora");

		}
		
	}
}
