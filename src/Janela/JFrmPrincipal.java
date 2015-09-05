package Janela;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import org.jboss.jandex.Main;

import Painel.Fixo.*;
import Painel.Dinamico.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JFrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel foto;
	private JPnlAgenda panelSetorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {// com.jtattoo.plaf.luna.LunaLookAndFeel azulado simples
						// com.jtattoo.plaf.smart.SmartLookAndFeel o padrão que
						// eu
						// usava muito
						// com.jtattoo.plaf.hifi.HiFiLookAndFeel preto bem
						// massa!!
						// com.jtattoo.plaf.graphite.GraphiteLookAndFeel preto
						// com
						// detalhes marrons
						// com.jtattoo.plaf.fast.FastLookAndFeel cinza basico
						// com.jtattoo.plaf.aluminium.AluminiumLookAndFeel -
						// com.jtattoo.plaf.acryl.AcrylLookAndFeel - um pouco
						// transparente detalhes em preto, bonito
						// com.jtattoo.plaf.bernstein.BernsteinLookAndFeel
						// bonito
						// detalhes em amarelo laranja
						// com.jtattoo.plaf.mcwin.McWinLookAndFeel interface do
						// MacOs
						// com.jtattoo.plaf.mint.MintLookAndFeel basico cores
						// cinsas
						// padrao
						// com.jtattoo.plaf.noire.NoireLookAndFeel preto com
						// detalhe
						// em laranja
						// com.jtattoo.plaf.smart.SmartLookAndFeel tons em azul
						// com.jtattoo.plaf.texture.TextureLookAndFeel banco
						// gelo
						// com detalhes em preto fosco muito massa
						// Properties props = new Properties();
					// props.put("logoString", "");
					// SmartLookAndFeel.setCurrentTheme(props);

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					JFrmPrincipal frame = new JFrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("betin");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrmPrincipal() {
		setTitle("Setor de Visitas e Loca\u00E7\u00E3o");
		foto = new JLabel();
		foto.setBounds(10, 414, 250, 145);
		ImageIcon imagem = new ImageIcon(
				Main.class.getResource("/Imagens/1288955.png"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPnlMenuJanelas();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(5, 5, 1350, 90);
		contentPane.add(panelMenu);

		JPanel panelComandas = new JPanel();
		panelComandas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelComandas.setBounds(5, 100, 270, 570);
		contentPane.add(panelComandas);
		panelComandas.setLayout(null);
		panelComandas.add(foto);

		JButton btnAgendamentos = new JButton("Agendamentos e Pendencias");
		btnAgendamentos.setBounds(10, 10, 250, 23);
		panelComandas.add(btnAgendamentos);

		JButton btnClientes = new JButton("Locadores em Contrato");
		btnClientes.setBounds(10, 45, 250, 23);
		panelComandas.add(btnClientes);

		JButton btnLocatarios = new JButton("Locatarios em Contrato");
		btnLocatarios.setBounds(10, 80, 250, 23);
		panelComandas.add(btnLocatarios);

		JButton btnImveis = new JButton("Informa\u00E7\u00F5es de Im\u00F3veis");
		btnImveis.setBounds(10, 115, 250, 23);
		panelComandas.add(btnImveis);

//		JPanel panelCalendario = new JPnlCalendario();
//		panelCalendario.setBounds(5, 220, 260, 190);
//		panelComandas.add(panelCalendario);
//		panelCalendario.setLayout(null);

		JButton btnContratosEmVigor = new JButton("Contratos em Vigor");
		btnContratosEmVigor.setBounds(10, 150, 250, 23);
		panelComandas.add(btnContratosEmVigor);

		JPanel panelRodape = new JPnlRodaPe();
		panelRodape.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRodape.setBounds(5, 675, 1350, 43);
		contentPane.add(panelRodape);

		panelSetorial = new JPnlAgenda();
		panelSetorial.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSetorial.setBounds(280, 100, 1075, 570);
		contentPane.add(panelSetorial);
		
		
		panelSetorial.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		btnAgendamentos.addActionListener(this);
		btnAgendamentos.setActionCommand("AGENDAMENTO");
		btnClientes.addActionListener(this);
		btnClientes.setActionCommand("LOCADORES");
		btnImveis.addActionListener(this);
		btnImveis.setActionCommand("IMOVEIS");
		btnLocatarios.addActionListener(this);
		btnLocatarios.setActionCommand("LOCATARIOS");
		btnContratosEmVigor.addActionListener(this);
		btnContratosEmVigor.setActionCommand("CONTRATOS");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "AGENDAMENTO":
			//contentPane.remove(panelSetorial);
			panelSetorial.removeAll();
			panelSetorial.add(new JPnlAgenda());
			panelSetorial.repaint();
			panelSetorial.validate();

			break;
		case "LOCADORES":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlLocadores());
			panelSetorial.validate();

			break;
		case "IMOVEIS":
		panelSetorial.removeAll();
		panelSetorial.repaint();
		panelSetorial.add(new JPnlImoveis());
		panelSetorial.validate();

			break;
		case "LOCATARIOS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlLocatarios());
			panelSetorial.validate();

			break;
		case "CONTRATOS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlContratos());
			panelSetorial.validate();

			break;

		default:
			break;
		}

	}

}
