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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceBajaElementos extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tfIDElemento;
	private ControladorElementos control = new ControladorElementos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceBajaElementos frame = new InterfaceBajaElementos();
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
	public InterfaceBajaElementos() {
		setTitle("Baja Elementos");
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdElemento = new JLabel("ID Elemento");
		
		tfIDElemento = new JTextField();
		tfIDElemento.setColumns(10);
		
		JButton btnBaja = new JButton("BAJA");
		btnBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickbaja();
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
							.addGap(31)
							.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(btnBaja)))
					.addContainerGap(213, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdElemento)
						.addComponent(tfIDElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addComponent(btnBaja)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void clickbaja() {
		int id=Integer.parseInt(tfIDElemento.getText());
		int id1=3;
		control.Baja(id1);
		
	}

}
