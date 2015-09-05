package Janela.Detalhamento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrmDetalhamentoVisita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmDetalhamentoVisita dialog = new JFrmDetalhamentoVisita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmDetalhamentoVisita() {
		setBounds(100, 100, 666, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(10, 26, 97, 20);
			contentPanel.add(lblCodigo);
		}
		{
			textField = new JTextField();
			textField.setBounds(10, 57, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(134, 57, 86, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(134, 26, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(274, 57, 86, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(274, 26, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(10, 119, 86, 20);
			contentPanel.add(textField_3);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(10, 88, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(10, 181, 86, 20);
			contentPanel.add(textField_4);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(10, 150, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(321, 119, 86, 20);
			contentPanel.add(textField_5);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(321, 88, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(321, 181, 86, 20);
			contentPanel.add(textField_6);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(321, 150, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(310, 268, 86, 20);
			contentPanel.add(textField_8);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(310, 237, 97, 20);
			contentPanel.add(label);
		}
		{
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(10, 268, 86, 20);
			contentPanel.add(textField_7);
		}
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(10, 237, 97, 20);
			contentPanel.add(label);
		}
	}

}
