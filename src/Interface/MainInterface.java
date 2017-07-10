package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JDesktopPane;
import java.awt.Color;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mnElementos;
	private JDesktopPane desktopPane;
	
	private JMenuItem mntmAlta;
	private JMenuItem mntmConsultarTodos;
	private JMenu mnAsd;
	private JMenuItem mntmBaja;
	private JMenuItem mntmBuscarPorId;
	private JMenuItem mntmModificar;
	private JMenuItem mntmBuscarPorNombre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainInterface() {
		setTitle("Reservas Elementos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnElementos = new JMenu("Elementos");
		mnElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowABMCInterface();
			}
		});
		menuBar.add(mnElementos);
		
		JMenuItem mntmAbmcelementos = new JMenuItem("ABMCElementos");
		mntmAbmcelementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ShowABMCInterface();
			}
		});
		
		mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInterfacealta();
			}
		});
		
		mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInterfaceBaja();
			}
		});
		mnElementos.add(mntmBaja);
		mnElementos.add(mntmAlta);
		mnElementos.add(mntmAbmcelementos);
		
		mnAsd = new JMenu("Buscar");
		mnElementos.add(mnAsd);
		
		mntmBuscarPorId = new JMenuItem("Buscar por ID");
		mntmBuscarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showConsultaPorId();
			}
		});
		mnAsd.add(mntmBuscarPorId);
		
		mntmBuscarPorNombre = new JMenuItem("Buscar por Nombre");
		mntmBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showporNombre();
			}
		});
		mnAsd.add(mntmBuscarPorNombre);
		
		mntmConsultarTodos = new JMenuItem("Buscar Todos");
		mnAsd.add(mntmConsultarTodos);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showModificar();
			}
		});
		mnElementos.add(mntmModificar);
		mntmConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showConsulta();
			}
		});
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
	}


	protected void showporNombre() {
		InterfaceConsultaPorNombre frmnombre = new InterfaceConsultaPorNombre();
		desktopPane.add(frmnombre);
		frmnombre.setVisible(true);
	}

	protected void showModificar() {
		InterfaceModificacionElementos frmModifica = new InterfaceModificacionElementos();
		desktopPane.add(frmModifica);
		frmModifica.setVisible(true);
	}

	protected void showConsultaPorId() {
		
		InterfaceConsultaIDElementos frmporid = new InterfaceConsultaIDElementos();
		desktopPane.add(frmporid);
		frmporid.setVisible(true);
	}

	protected void showInterfaceBaja() {
		InterfaceBajaElementos frmbaja = new InterfaceBajaElementos();
		desktopPane.add(frmbaja);
		frmbaja.setVisible(true);
		}

	protected void showInterfacealta() {
		InterfaceAltaElementos frmalta = new InterfaceAltaElementos();
		desktopPane.add(frmalta);
		frmalta.setVisible(true);
	}

	protected void ShowABMCInterface() {
		ABMCInterface frmElemento = new ABMCInterface();
		desktopPane.add(frmElemento);
		frmElemento.setVisible(true);
	
		
	}
	protected void showConsulta(){
		InterfaceConsultarTodosElementos fmrtodos = new InterfaceConsultarTodosElementos();
		desktopPane.add(fmrtodos);
		fmrtodos.setVisible(true);
	}
}
