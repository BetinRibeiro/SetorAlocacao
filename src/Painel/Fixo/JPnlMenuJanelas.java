package Painel.Fixo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Janela.Cadastro.*;
import Janela.Lista.FrmListaCaptacao;
import Janela.Lista.JFrmListaImoveis;
import Janela.Lista.JFrmListaPessoa;

@SuppressWarnings("serial")
public class JPnlMenuJanelas extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	public JPnlMenuJanelas() {
		setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		setBounds(5, 5, 1350, 90);
		setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 1, this.getWidth() - 2, 20);
		this.add(menuBar);

		JMenu menuCadatro = new JMenu("Cadastro");
		menuBar.add(menuCadatro);

		JMenuItem opCadastroImvel = new JMenuItem("Cadastro Im\u00F3vel");
		menuCadatro.add(opCadastroImvel);

		JMenuItem opCadastroPessoa = new JMenuItem("Cadastro Pessoa");
		menuCadatro.add(opCadastroPessoa);

		JMenu menuConsulta = new JMenu("Consulta");
		menuBar.add(menuConsulta);

		JMenuItem opConsultaImvel = new JMenuItem("Consulta Im\u00F3vel");
		menuConsulta.add(opConsultaImvel);

		JMenuItem opConsultaPessoa = new JMenuItem("Consulta Pessoa");
		menuConsulta.add(opConsultaPessoa);

		JMenu menuMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(menuMovimentao);

		JMenu menuRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(menuRelatrio);
		
		JMenuItem opCaptacao = new JMenuItem("Capta\u00E7\u00E3o");
		menuCadatro.add(opCaptacao);
		
		JMenuItem opConsultaCaptao = new JMenuItem("Consulta Capta\u00E7\u00E3o");
		menuConsulta.add(opConsultaCaptao);
		

		// cadastros
		opCadastroImvel.addActionListener(this);
		opCadastroImvel.setActionCommand("CAD_IMOVEL");
		opCadastroPessoa.addActionListener(this);
		opCadastroPessoa.setActionCommand("CAD_PESSOA");
		opConsultaImvel.addActionListener(this);
		opConsultaImvel.setActionCommand("CONS_IMOVEL");
		opConsultaPessoa.addActionListener(this);
		opConsultaPessoa.setActionCommand("CONS_PESSOA");
		opCaptacao.addActionListener(this);
		opCaptacao.setActionCommand("CAD_CAPT");
		opConsultaCaptao.addActionListener(this);
		opConsultaCaptao.setActionCommand("CONS_CAPT");
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "CAD_IMOVEL":
			JFrmCadastroImovel cadastroimovel = new JFrmCadastroImovel(null);
			cadastroimovel.setVisible(true);
			break;
		case "CAD_PESSOA":
			JFrmCadastroPessoa cadastroLocador = new JFrmCadastroPessoa(null);
			cadastroLocador.setVisible(true);
			break;
		case "CONS_IMOVEL":
			JFrmListaImoveis consultaImovel = new JFrmListaImoveis("");
			consultaImovel.setVisible(true);
			break;
		case "CONS_PESSOA":
			JFrmListaPessoa consultaPessoa = new JFrmListaPessoa("");
			consultaPessoa.setVisible(true);
			break;
		case "CAD_CAPT":
			JFrmCaptacao captacaoCliente = new JFrmCaptacao(null);
			captacaoCliente.setVisible(true);
			break;
		case "CONS_CAPT":
			FrmListaCaptacao listaCaptacao = new FrmListaCaptacao("");
			listaCaptacao.setVisible(true);
			break;

		default:
			break;
		}

	}
}
