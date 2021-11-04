package BarraProgresoHilos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarraHilo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static final long serialVersionUID = 1L;
	private boolean flagR = false;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraHilo frame = new BarraHilo();
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
	public BarraHilo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JProgressBar BarraPogreso = new JProgressBar();
		BarraPogreso.setBounds(128, 84, 173, 33);
		contentPane.add(BarraPogreso);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			     try {
			    	 if(!flagR) {
			         for(int i = 0; i <= 99; i++) {
			        	 Thread.sleep(400);
			             i += 10;
			             BarraPogreso.setValue(i);
			         }
			         flagR = true;
			         JOptionPane.showMessageDialog(null,"Terminado");
			         return;
			    	 }
			         if(flagR) {
			        	 BarraPogreso.setValue(0);
			        	 flagR = false;
			        	 return;
			         }
			        	 
			     }
			     catch (Exception ex) {
			         System.err.println( ex.getMessage() );
			     }
			}
		});
		btnComenzar.setBounds(155, 147, 128, 23);
		contentPane.add(btnComenzar);
	}
}
