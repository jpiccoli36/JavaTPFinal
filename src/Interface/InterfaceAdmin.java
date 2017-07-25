package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceAdmin extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAdmin frame = new InterfaceAdmin();
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
	public InterfaceAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 431);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnElementos = new JMenu("Elementos");
		menuBar.add(mnElementos);
		
		JMenuItem mntmAltaElementos = new JMenuItem("Alta Elementos");
		mntmAltaElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showIntefaceAltaElementos();
			}
		});
		mnElementos.add(mntmAltaElementos);
		
		JMenuItem mntmBajaElementos = new JMenuItem("Baja Elementos");
		mntmBajaElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showInterfaceBajaElementos();
			}
		});
		mnElementos.add(mntmBajaElementos);
		
		JMenuItem mntmModificarElementos = new JMenuItem("Modificar Elementos");
		mntmModificarElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInterfceModificacionElementos();
			}
		});
		mnElementos.add(mntmModificarElementos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	protected void showInterfceModificacionElementos() {
		InterfaceModificacionElementos ime = new InterfaceModificacionElementos();
		desktopPane.add(ime);
		ime.setVisible(true);
		
	}

	protected void showInterfaceBajaElementos() {

		InterfaceBajaElementos ibe = new InterfaceBajaElementos();
		desktopPane.add(ibe);
		ibe.setVisible(true);
		
	}

	protected void showIntefaceAltaElementos() {
	
		InterfaceAltaElementos iae = new InterfaceAltaElementos();
		desktopPane.add(iae);
		iae.setVisible(true);
		
		
	}
}
