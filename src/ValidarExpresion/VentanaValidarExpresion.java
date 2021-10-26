package ValidarExpresion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class VentanaValidarExpresion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaValidarExpresion frame = new VentanaValidarExpresion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextField txtinput;
	public int flagError = 0;
	
	/**
	 * Create the frame.
	 */
	public VentanaValidarExpresion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stack<String> varPila = new Stack<String>();
				
				String varExpresion = txtinput.getText();
				char varCaracter;
				flagError = 0;
				for(int x=0; x<varExpresion.length(); x++) {
					varCaracter = varExpresion.charAt(x);
					
					System.out.print(varCaracter);
					if(varCaracter=='('){ varPila.push("parentesisAbre");}
		    if(varCaracter== ')') {
			if(varPila.empty()) 
			{
				flagError = 1;
				break;
			}
			else 
			{
				varPila.pop();
				
			}
		}
				}
				if(varPila.empty() && (flagError==0))
				{
					JOptionPane.showMessageDialog(null,"La expresión correcta");
					}
				else {
					JOptionPane.showMessageDialog(null,"La expresión incorrecta");
					}
			}
		});
		btnValidar.setBounds(145, 137, 117, 64);
		contentPane.add(btnValidar);
		
		txtinput = new JTextField();
		txtinput.setBounds(93, 11, 207, 53);
		contentPane.add(txtinput);
		txtinput.setColumns(10);
	}
}
