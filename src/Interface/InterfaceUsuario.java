package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUsuario extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuItem mntmConsultarTodos;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceUsuario frame = new InterfaceUsuario();
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
	public InterfaceUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnElementos = new JMenu("Elementos");
		menuBar.add(mnElementos);
		
		mntmConsultarTodos = new JMenuItem("Consultar todos");
		mntmConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showConsultarTodos();
			}
		});
		mnElementos.add(mntmConsultarTodos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	
	protected void showConsultarTodos() {
		InterfaceConsultarTodosElementos ice = new InterfaceConsultarTodosElementos();
		desktopPane.add(ice);
		ice.setVisible(true);
		
		
	}
}
