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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceConsultaIDElementos extends JInternalFrame {
	
	ControladorElementos control = new ControladorElementos();

	private JPanel contentPane;
	private JTextField tfIdElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsultaIDElementos frame = new InterfaceConsultaIDElementos();
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
	public InterfaceConsultaIDElementos() {
		setTitle("Buscar por ID");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdElemento = new JLabel("ID Elemento");
		
		tfIdElemento = new JTextField();
		tfIdElemento.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickbuscarPorId();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(lblIdElemento)
							.addGap(43)
							.addComponent(tfIdElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(btnBuscar)))
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdElemento)
						.addComponent(tfIdElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addComponent(btnBuscar)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void clickbuscarPorId() {
		Elemento e = new Elemento();
		int id=Integer.parseInt(this.tfIdElemento.getText());
		e.setId_elemento(id);
	control.Porid(e);
		
	}

}
