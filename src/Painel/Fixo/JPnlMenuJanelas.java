package Painel.Fixo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Janela.Cadastro.*;
import Janela.Lista.JFrmListaAtendente;
import Janela.Lista.JFrmListaContratos;
import Janela.Lista.JFrmListaInteressado;
import Janela.Lista.JFrmListaImoveis;
import Janela.Lista.JFrmListaPessoa;
import Painel.Dinamico.JFrmDepoisDeletar;

@SuppressWarnings("serial")
public class JPnlMenuJanelas extends JPanel implements ActionListener {

	private JMenuItem opConsultaAtendente;
	private JMenuItem opConsultaCaptao;
	private JMenuItem opInteressado;
	private JMenuItem opCadastroAtendente;

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

		JMenu menuRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(menuRelatrio);

		JMenuItem mntmRelatorioLocadores = new JMenuItem("Relatorio Locadores");
		menuRelatrio.add(mntmRelatorioLocadores);

		JMenuItem mntmRelatorioLocatarios = new JMenuItem("Relatorio Locatarios");
		menuRelatrio.add(mntmRelatorioLocatarios);

		JMenuItem mntmRelatorioContratos = new JMenuItem("Relatorio Contratos");
		menuRelatrio.add(mntmRelatorioContratos);

		JMenuItem mnRelatorioVisitas = new JMenuItem("Relatorio Visitas");
		menuRelatrio.add(mnRelatorioVisitas);

		opCadastroAtendente = new JMenuItem("Cadastro Atendente");
		menuCadatro.add(opCadastroAtendente);

		JMenuItem mnCadastroContrato = new JMenuItem("Cadastro Contrato");
		menuCadatro.add(mnCadastroContrato);

		opInteressado = new JMenuItem("Cadastro Interessado");
		menuCadatro.add(opInteressado);

		opConsultaAtendente = new JMenuItem("Consulta Atendente");
		menuConsulta.add(opConsultaAtendente);

		JMenuItem mntConsultaContrato = new JMenuItem("Consulta Contrato");
		menuConsulta.add(mntConsultaContrato);

		opConsultaCaptao = new JMenuItem("Consulta Interessado");
		menuConsulta.add(opConsultaCaptao);

		mnCadastroContrato.addActionListener(this);
		mnCadastroContrato.setActionCommand("CAD_CONTr");
		mntConsultaContrato.addActionListener(this);
		mntConsultaContrato.setActionCommand("CONS_CONTr");

		// cadastros
		opCadastroImvel.addActionListener(this);
		opCadastroImvel.setActionCommand("CAD_IMOVEL");
		opCadastroPessoa.addActionListener(this);
		opCadastroPessoa.setActionCommand("CAD_PESSOA");
		opConsultaImvel.addActionListener(this);
		opConsultaImvel.setActionCommand("CONS_IMOVEL");
		opConsultaPessoa.addActionListener(this);
		opConsultaPessoa.setActionCommand("CONS_PESSOA");
		opInteressado.addActionListener(this);
		opInteressado.setActionCommand("CAD_CAPT");
		opConsultaCaptao.addActionListener(this);
		opConsultaCaptao.setActionCommand("CONS_CAPT");
		opCadastroAtendente.addActionListener(this);
		opCadastroAtendente.setActionCommand("CAD_ATEN");
		opConsultaAtendente.addActionListener(this);
		opConsultaAtendente.setActionCommand("CONS_ATEN");

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmVideosExplicativos = new JMenuItem("Videos Explicativos");
		mnAjuda.add(mntmVideosExplicativos);
		
		mntmVideosExplicativos.addActionListener(this);
		mntmVideosExplicativos.setActionCommand("SITE");
		

		JMenuItem mntmDocumentaoDeApoio = new JMenuItem("Documenta\u00E7\u00E3o de Apoio");
		mnAjuda.add(mntmDocumentaoDeApoio);
		
		mntmDocumentaoDeApoio.addActionListener(this);
		mntmDocumentaoDeApoio.setActionCommand("SITE");

		mntmRelatorioContratos.addActionListener(this);
		mntmRelatorioLocadores.addActionListener(this);
		mntmRelatorioLocatarios.addActionListener(this);
		mnRelatorioVisitas.addActionListener(this);

		mntmRelatorioContratos.setActionCommand("RELAT");
		mntmRelatorioLocadores.setActionCommand("RELAT");
		mntmRelatorioLocatarios.setActionCommand("RELAT");
		mnRelatorioVisitas.setActionCommand("RELAT");

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
			JFrmInteressado InteressadoCliente = new JFrmInteressado(null);
			InteressadoCliente.setVisible(true);
			break;
		case "CONS_CAPT":
			JFrmListaInteressado listaInteressado = new JFrmListaInteressado("");
			listaInteressado.setVisible(true);
			break;
		case "CAD_ATEN":
			JFrmCadastroAtendente cadastroAtendente = new JFrmCadastroAtendente(null);
			cadastroAtendente.setVisible(true);
			break;
		case "CONS_ATEN":
			JFrmListaAtendente consultaAtendente = new JFrmListaAtendente("");
			consultaAtendente.setVisible(true);
			break;
		case "CONS_CONTr":
			JFrmListaContratos consultacontrato = new JFrmListaContratos("");
			consultacontrato.setVisible(true);
			break;
		case "CAD_CONTr":
			JFrmCadastroContrato ccontr = new JFrmCadastroContrato();
			ccontr.setVisible(true);
			break;
		case "RELAT":
			JFrmDepoisDeletar impr = new JFrmDepoisDeletar();
			impr.setVisible(true);
			break;
		case "SITE":
			JOptionPane.showMessageDialog(this, "Direcionamento para uma pagina WEB");
			break;

		default:
			break;
		}

	}
}
