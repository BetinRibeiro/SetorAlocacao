package Painel.Dinamico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrmDepoisDeletar extends JDialog {

	private JPanel contentPane;
	private JDateChooser dtinicial;
	private JDateChooser dtFinal;
	private JButton btnGerarRelatorio;
	private JButton btnImprimir;

	
	/**
	 * Create the frame.
	 */
	public JFrmDepoisDeletar() {
		setTitle("Gerar Relatorio");
		setBounds(100, 100, 364, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		dtinicial = new JDateChooser(new java.util.Date());
		dtinicial.setEnabled(false);
		dtinicial.setBounds(20, 30, 120, 20);
		contentPane.add(dtinicial);
		
		dtFinal = new JDateChooser(new java.util.Date());
		dtFinal.setEnabled(false);
		dtFinal.setBounds(200, 30, 120, 20);
		contentPane.add(dtFinal);
		
		btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Salvando Relatorio");
				dispose();
			}
		});
		btnGerarRelatorio.setBounds(10, 86, 130, 23);
		contentPane.add(btnGerarRelatorio);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Imprimindo relarorio");
				dispose();
			}
		});
		btnImprimir.setBounds(190, 86, 130, 23);
		contentPane.add(btnImprimir);

	}

}
