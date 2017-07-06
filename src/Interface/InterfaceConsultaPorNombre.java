package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorElementos;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceConsultaPorNombre extends JInternalFrame {
ControladorElementos control = new ControladorElementos();
	private JPanel contentPane;
	private JTextField tfNombreElemento;

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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNombreElemento)
							.addGap(38)
							.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(btnConsultar)))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreElemento)
						.addComponent(tfNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addComponent(btnConsultar)
					.addGap(66))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void porNombreclick() {
		String n= this.tfNombreElemento.getText();
		control.PorNombre(n);

		
	}

}
