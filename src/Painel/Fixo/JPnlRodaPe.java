package Painel.Fixo;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JPnlRodaPe extends JPanel {

	private JLabel data;

	/**
	 * Create the panel.
	 */
	public JPnlRodaPe() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(5, 675, 1350, 43);
		setLayout(null);
		
		
		JLabel lblEmailDaEmpresa = new JLabel("sistemasgerenciais@gmail.com");
		lblEmailDaEmpresa.setBounds(511, 11, 200, 14);
		add(lblEmailDaEmpresa);
		
		JLabel lblLinkDeContato = new JLabel("(88) 98878-0587 - (88) 99786-7735");
		lblLinkDeContato.setForeground(new Color(65, 105, 225));
		lblLinkDeContato.setBounds(1095, 11, 230, 14);
		add(lblLinkDeContato);
		
		Date valorData = new Date() ;
        String dataz = "dd/MM/yyyy";
        SimpleDateFormat formatas = new SimpleDateFormat(dataz );
        String adata = formatas.format(valorData );

		data = new JLabel(adata);
		data.setBounds(10, 11, 120, 14);
		add(data);

	}
}
