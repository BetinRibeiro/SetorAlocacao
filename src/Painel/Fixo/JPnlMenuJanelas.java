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


@SuppressWarnings("serial")
public class JPnlMenuJanelas extends JPanel implements ActionListener{

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

		JMenu menuCadatro = new JMenu("Cadatro");
		menuBar.add(menuCadatro);
		
		JMenuItem opCadastroImvel = new JMenuItem("Cadastro Im\u00F3vel");
		menuCadatro.add(opCadastroImvel);
		
		JMenuItem opCadastroPessoa = new JMenuItem("Cadastro Pessoa");
		menuCadatro.add(opCadastroPessoa);
		
		JMenu menuCadasatrarContrato = new JMenu("Cadasatrar Contrato");
		menuCadatro.add(menuCadasatrarContrato);
		
		JMenuItem opCadasatrarContratoAdministrao = new JMenuItem("Cadastro Contrato Administra\u00E7\u00E3o");
		menuCadasatrarContrato.add(opCadasatrarContratoAdministrao);
		
		JMenuItem opCadasatrarContratoLocao = new JMenuItem("Cadastro Contrato Loca\u00E7\u00E3o");
		menuCadasatrarContrato.add(opCadasatrarContratoLocao);
		
		JMenuItem opPreCadastro = new JMenuItem("Pr\u00E9-Cadastro");
		menuCadatro.add(opPreCadastro);
		
		JMenu menuConsulta = new JMenu("Consulta");
		menuBar.add(menuConsulta);
		
		JMenuItem opConsultaImvel = new JMenuItem("Consulta Im\u00F3vel");
		menuConsulta.add(opConsultaImvel);
		
		JMenuItem opConsultaPessoa = new JMenuItem("Consulta Pessoa");
		menuConsulta.add(opConsultaPessoa);
		
		JMenuItem opConsultaVisitantes = new JMenuItem("Consulta Visitante");
		menuConsulta.add(opConsultaVisitantes);
		
		JMenu menuAlteraoDeContrato = new JMenu("Altera\u00E7\u00E3o de Contrato");
		menuConsulta.add(menuAlteraoDeContrato);
		
		JMenuItem opAlteraçãoContratoAdministrao = new JMenuItem("Altera\u00E7\u00E3o Contrato Administra\u00E7\u00E3o");
		menuAlteraoDeContrato.add(opAlteraçãoContratoAdministrao);
		
		JMenuItem opAlteracaoContratoLocaoAlteração = new JMenuItem("Altera\u00E7\u00E3o Contrato Loca\u00E7\u00E3o");
		menuAlteraoDeContrato.add(opAlteracaoContratoLocaoAlteração);



		JMenu menuMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(menuMovimentao);
		
		JMenuItem opMovimentacaoAgendamento = new JMenuItem("Agendar Visita no Imovel");
		menuMovimentao.add(opMovimentacaoAgendamento);
		
		JMenuItem opMovimentacaoContratoDeAdministrao = new JMenuItem("Contrato de Administra\u00E7\u00E3o");
		menuMovimentao.add(opMovimentacaoContratoDeAdministrao);
		
		JMenuItem opMovimentacaoContratoDeLocao = new JMenuItem("Contrato de Loca\u00E7\u00E3o");
		menuMovimentao.add(opMovimentacaoContratoDeLocao);
		
		JMenuItem opMovimentacaoRenovaoDeContrato = new JMenuItem("Renova\u00E7\u00E3o de Contrato");
		menuMovimentao.add(opMovimentacaoRenovaoDeContrato);
		
		JMenu menuRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(menuRelatrio);
		
		JMenuItem opRelatorioVisitas = new JMenuItem("Relatorio Visitas");
		menuRelatrio.add(opRelatorioVisitas);
		
		JMenuItem opRelatorioImveis = new JMenuItem("Relatorio Im\u00F3veis");
		menuRelatrio.add(opRelatorioImveis);
		
		JMenuItem opRelatorioClientes = new JMenuItem("Relatorio Clientes");
		menuRelatrio.add(opRelatorioClientes);
		
		JMenuItem opRelatorioContratos = new JMenuItem("Relatorio Contratos");
		menuRelatrio.add(opRelatorioContratos);
		
		//cadastros
		opCadastroImvel.addActionListener(this);
		opCadastroImvel.setActionCommand("CAD_IMOVEL");
		opPreCadastro.addActionListener(this);
		opPreCadastro.setActionCommand("CAD_PRE");
		opCadasatrarContratoAdministrao.addActionListener(this);
		opCadasatrarContratoLocao.addActionListener(this);
		
		//consultas e alterações	
		opAlteraçãoContratoAdministrao.addActionListener(this);
		
		opMovimentacaoAgendamento.addActionListener(this);
		opRelatorioClientes.addActionListener(this);
		opConsultaImvel.addActionListener(this);
		
//		Movimentações
		opConsultaVisitantes.addActionListener(this);
		opMovimentacaoContratoDeAdministrao.addActionListener(this);
		opMovimentacaoContratoDeLocao.addActionListener(this);
		opRelatorioContratos.addActionListener(this);
		opRelatorioImveis.addActionListener(this);
		opAlteracaoContratoLocaoAlteração.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		System.out.println(acao);
		
		switch (acao) {
		case "CAD_IMOVEL":
			JFrmCadastroImovel cadastroimovel = new JFrmCadastroImovel();
			cadastroimovel.setVisible(true);
			break;
		case "CAD_LOCADOR":
			JFrmCadastroPessoa cadastroLocador = new JFrmCadastroPessoa(null);
			cadastroLocador.setVisible(true);
			break;
		case "CAD_PRE":
//			TODO
			break;

		default:
			break;
		}
		
	}
}
