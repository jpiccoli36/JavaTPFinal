package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterfaceLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfContrase�a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceLogin frame = new InterfaceLogin();
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
	public InterfaceLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		tfContrase�a = new JTextField();
		tfContrase�a.setColumns(10);
		
		JButton btnLogear = new JButton("Logear");
		btnLogear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				logearClick();
			}
		});
		
		JButton btnNuevoUsuario = new JButton("Crear Usuario");
		btnNuevoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			ShowCrearUsuario();}
		});
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogear)
							.addGap(60)
							.addComponent(btnNuevoUsuario))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario)
								.addComponent(lblContrasea))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfUsuario)
								.addComponent(tfContrase�a, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(tfContrase�a, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogear)
						.addComponent(btnNuevoUsuario))
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void ShowCrearUsuario() {
		
		InterfaceAltaUsuario iau = new InterfaceAltaUsuario();
		iau.setVisible(true);
		InterfaceLogin.this.dispose();
		
	}

	protected void logearClick() {
		Login log = new Login();
		String usua=tfUsuario.getText();
		String contrase�a=tfContrase�a.getText();
		ResultSet rs=log.login(usua,contrase�a);
		
		
		if(rs!=null)
		{			
			
			try {
				if(rs.getString(4).equals("admin")){
					InterfaceAdmin ia= new InterfaceAdmin();
					ia.setVisible(true);
					InterfaceLogin.this.dispose();
				}
				else{
					if(rs.getString(4).equals("user")){
						InterfaceUsuario il = new InterfaceUsuario();
						il.setVisible(true);
						InterfaceLogin.this.dispose();
						
					}
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
		else {JOptionPane.showMessageDialog(null, "usuario y/o contrase�a incorrecta");}	
		
		
	
}}
