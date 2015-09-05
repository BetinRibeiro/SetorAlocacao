package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Bin.Captacao.Captacao;
import Bin.Captacao.Visita;
import Bin.Imovel.Imovel;
import Bin.Pessoa.Atendente;
import Janela.Lista.JFrmListaAtendente;
import Janela.Lista.JFrmListaCaptacao;
import Janela.Lista.JFrmListaImoveis;
import Persistence.Dao;
import TableModel.TMVisita;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class JPnlAgenda extends JPanel implements ActionListener {
	private JTable table;
	private JTextField txtIdCaptacao;
	private JTextField txtIdImovel;
	private JTextField txtIdAtendente;
	private JTextField txtNomeCaptacao;
	private JTextField txtNomeImovel;
	private JTextField txtNomeAtendente;
	private JDateChooser dtCadastro;
	private JDateChooser dtAgendada;
	private JButton btnAgendarSalvar;
	private JButton btnBuscarAtendente;
	private JButton btnBuscarImovel;
	private JButton btnBuscarCaptacao;
	private JTextField txtIdVisita;
	private Visita visitaParaAlterar = null;
	private Dao banco = new Dao();
	private JPanel panelDadosAgendamento;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	private TMVisita model = new TMVisita();
	private JPopupMenu pop;
	private JPopupMenu popupMenu;

	/**
	 * Create the panel.
	 */
	public JPnlAgenda() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);

		JPanel panelAgendamento = new JPanel();
		panelAgendamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAgendamento.setBounds(10, 264, 1055, 295);
		add(panelAgendamento);
		panelAgendamento.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1035, 205);
		panelAgendamento.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmAtualizarDadosDa = new JMenuItem(
				"Atualizar dados da tabela");
		popupMenu.add(mntmAtualizarDadosDa);
		mntmAtualizarDadosDa.addActionListener(this);
		mntmAtualizarDadosDa.setActionCommand("ATUALIZAR_TABELA");

		JMenuItem mntmVisualizarDetalhesDa = new JMenuItem(
				"Visualizar detalhes da visita");
		popupMenu.add(mntmVisualizarDetalhesDa);

		JMenuItem mntmAlterar = new JMenuItem("Alterar os dados da visita");
		popupMenu.add(mntmAlterar);
		mntmAlterar.setActionCommand("ALTERAR_VISITA");
		mntmAlterar.addActionListener(this);

		JMenuItem mntmArquivar = new JMenuItem("Arquivar visita como cumprida.");
		popupMenu.add(mntmArquivar);

		JMenuItem mntmContrato = new JMenuItem(
				"Proseguir o processo de contratação");
		popupMenu.add(mntmContrato);

		// para selecionar a linha da tabela tanto pelo click direito quanto
		// pelo esquerdo
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					int col = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					if (col != -1 && row != -1) {
						table.setColumnSelectionInterval(col, col);
						table.setRowSelectionInterval(row, row);
					}
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(10, 385, 1050, 145);
		panelAgendamento.add(panel);

		JLabel lblListaDeAgendamentos = new JLabel(
				"Lista de agendamentos de visitas");
		lblListaDeAgendamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeAgendamentos.setBounds(10, 10, 324, 20);
		panelAgendamento.add(lblListaDeAgendamentos);

		// JPanel panel_1 = new JPnlCalendario();
		// panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		// // panel_1.setBounds(10, 10, 320, 240);
		// add(panel_1);
		//
		panelDadosAgendamento = new JPanel();
		panelDadosAgendamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDadosAgendamento.setBounds(10, 11, 490, 240);
		add(panelDadosAgendamento);
		panelDadosAgendamento.setLayout(null);

		dtCadastro = new JDateChooser(new java.util.Date());
		dtCadastro.setEnabled(false);
		dtCadastro.setBounds(117, 50, 122, 20);
		panelDadosAgendamento.add(dtCadastro);

		dtAgendada = new JDateChooser(new java.util.Date());
		dtAgendada.setBounds(345, 50, 122, 20);
		panelDadosAgendamento.add(dtAgendada);

		txtIdCaptacao = new JTextField();
		txtIdCaptacao.setEnabled(false);
		txtIdCaptacao.setBounds(10, 93, 86, 20);
		panelDadosAgendamento.add(txtIdCaptacao);
		txtIdCaptacao.setColumns(10);

		JLabel lblCaptao = new JLabel("Codigo");
		lblCaptao.setBounds(10, 73, 86, 20);
		panelDadosAgendamento.add(lblCaptao);

		txtIdImovel = new JTextField();
		txtIdImovel.setEnabled(false);
		txtIdImovel.setBounds(10, 133, 86, 20);
		panelDadosAgendamento.add(txtIdImovel);
		txtIdImovel.setColumns(10);

		JLabel lblImvel = new JLabel("Codigo");
		lblImvel.setBounds(10, 113, 86, 20);
		panelDadosAgendamento.add(lblImvel);

		txtIdAtendente = new JTextField();
		txtIdAtendente.setEnabled(false);
		txtIdAtendente.setColumns(10);
		txtIdAtendente.setBounds(10, 173, 86, 20);
		panelDadosAgendamento.add(txtIdAtendente);

		JLabel lblAtendente = new JLabel("Codigo");
		lblAtendente.setBounds(10, 153, 86, 20);
		panelDadosAgendamento.add(lblAtendente);

		txtNomeCaptacao = new JTextField();
		txtNomeCaptacao.setEnabled(false);
		txtNomeCaptacao.setBounds(106, 93, 266, 20);
		panelDadosAgendamento.add(txtNomeCaptacao);
		txtNomeCaptacao.setColumns(10);

		txtNomeImovel = new JTextField();
		txtNomeImovel.setEnabled(false);
		txtNomeImovel.setColumns(10);
		txtNomeImovel.setBounds(106, 133, 266, 20);
		panelDadosAgendamento.add(txtNomeImovel);

		txtNomeAtendente = new JTextField();
		txtNomeAtendente.setEnabled(false);
		txtNomeAtendente.setColumns(10);
		txtNomeAtendente.setBounds(106, 173, 266, 20);
		panelDadosAgendamento.add(txtNomeAtendente);

		btnBuscarCaptacao = new JButton("Buscar");
		btnBuscarCaptacao.setBounds(382, 93, 89, 20);
		panelDadosAgendamento.add(btnBuscarCaptacao);

		btnBuscarImovel = new JButton("Buscar");
		btnBuscarImovel.setBounds(382, 133, 89, 20);
		panelDadosAgendamento.add(btnBuscarImovel);

		btnBuscarAtendente = new JButton("Buscar");
		btnBuscarAtendente.setBounds(382, 173, 89, 20);
		panelDadosAgendamento.add(btnBuscarAtendente);

		JLabel label = new JLabel("Capta\u00E7\u00E3o");
		label.setBounds(108, 73, 190, 20);
		panelDadosAgendamento.add(label);

		JLabel lblImovel = new JLabel("Imovel");
		lblImovel.setBounds(106, 113, 192, 20);
		panelDadosAgendamento.add(lblImovel);

		JLabel lblAtendente_1 = new JLabel("Atendente");
		lblAtendente_1.setBounds(106, 153, 192, 20);
		panelDadosAgendamento.add(lblAtendente_1);

		JLabel lblDataDeHoje = new JLabel("Data de Cadastro");
		lblDataDeHoje.setBounds(10, 50, 97, 20);
		panelDadosAgendamento.add(lblDataDeHoje);

		JLabel lblDataDaVisita = new JLabel("Data da Visita");
		lblDataDaVisita.setBounds(249, 50, 86, 20);
		panelDadosAgendamento.add(lblDataDaVisita);

		btnAgendarSalvar = new JButton("Agendar");
		btnAgendarSalvar.setBounds(10, 204, 89, 23);
		panelDadosAgendamento.add(btnAgendarSalvar);

		btnAgendarSalvar.addActionListener(this);
		btnAgendarSalvar.setActionCommand("SAL_AGE");
		btnBuscarAtendente.addActionListener(this);
		btnBuscarAtendente.setActionCommand("BUSC_ATEN");
		btnBuscarCaptacao.addActionListener(this);
		btnBuscarCaptacao.setActionCommand("BUSC_CAP");
		btnBuscarImovel.addActionListener(this);
		btnBuscarImovel.setActionCommand("BUSC_IMOV");

		txtIdVisita = new JTextField();
		txtIdVisita.setEnabled(false);
		txtIdVisita.setColumns(10);
		txtIdVisita.setBounds(106, 10, 86, 20);
		panelDadosAgendamento.add(txtIdVisita);

		JLabel lblCodigoVisita = new JLabel("Codigo Visita");
		lblCodigoVisita.setBounds(10, 10, 86, 20);
		panelDadosAgendamento.add(lblCodigoVisita);

		carregaTabela();

	}

	private void carregaTabela() {

		model.removeTudo();
		List<?> lista = banco.listarObjetos(Visita.class, "dataAgendamento");
		for (int i = 0; i < lista.size(); i++) {

			Visita visita = (Visita) lista.get(i);
			model.addRow(visita);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "SAL_AGE":
			salvarAgendamento();
			break;
		case "BUSC_ATEN":
			buscarAtendente();
			break;
		case "BUSC_CAP":
			buscarCaptacao();

			break;
		case "BUSC_IMOV":
			buscarImovel();
			break;
		case "ATUALIZAR_TABELA":
			carregaTabela();
			break;
		case "ALTERAR_VISITA":
			carregarVisita();

		default:
			break;
		}

	}

	private void carregarVisita() {
		Visita visita = (Visita) banco.buscarPorId(Visita.class,
				(Integer) table.getValueAt(table.getSelectedRow(), 0));

		dtAgendada.setDate(visita.getDataAgendamento());
		dtCadastro.setDate(visita.getDataCadastro());

		txtIdAtendente.setText(String.valueOf(visita.getAtendente().getId()));
		txtNomeAtendente.setText(String
				.valueOf(visita.getAtendente().getNome()));
		txtIdCaptacao.setText(String.valueOf(visita.getCaptacao().getId()));
		txtNomeCaptacao.setText(String.valueOf(visita.getCaptacao().getNome()));
		txtIdImovel.setText(String.valueOf(visita.getImovel().getId()));
		txtNomeImovel.setText(String.valueOf(visita.getImovel().getEnd()
				.getBairro()));
		txtIdVisita.setText(String.valueOf(visita.getId()));
		
	}

	private void buscarImovel() {
		JFrmListaImoveis capt = new JFrmListaImoveis("Escolher");
		capt.setModal(true);
		capt.setVisible(true);

		Imovel p = capt.getImovel();
		txtIdImovel.setText(String.valueOf(p.getId()));
		txtNomeImovel.setText(String.valueOf(p.getEnd().getBairro()));
		capt.dispose();

	}

	private void buscarCaptacao() {
		JFrmListaCaptacao capt = new JFrmListaCaptacao("Escolher");
		capt.setModal(true);
		capt.setVisible(true);

		Captacao p = capt.getCaptacao();
		txtIdCaptacao.setText(String.valueOf(p.getId()));
		txtNomeCaptacao.setText(String.valueOf(p.getNome()));
		capt.dispose();

	}

	private void buscarAtendente() {
		JFrmListaAtendente capt = new JFrmListaAtendente("Escolher");
		capt.setModal(true);
		capt.setVisible(true);

		Atendente p = capt.getAtendente();
		txtIdAtendente.setText(String.valueOf(p.getId()));
		txtNomeAtendente.setText(String.valueOf(p.getNome()));
		capt.dispose();

	}

	private void salvarAgendamento() {
		Visita visita = new Visita();

		if (visitaParaAlterar != null) {
			visita.setId(Integer.parseInt(txtIdVisita.getText()));
		}

		Atendente atendente = (Atendente) banco.buscarPorId(Atendente.class,
				Integer.parseInt(txtIdAtendente.getText()));

		visita.setAtendente(atendente);

		Imovel imovel = (Imovel) banco.buscarPorId(Imovel.class,
				Integer.parseInt(txtIdImovel.getText()));

		visita.setImovel(imovel);

		Captacao captacao = (Captacao) banco.buscarPorId(Captacao.class,
				Integer.parseInt(txtIdCaptacao.getText()));

		visita.setCaptacao(captacao);

		visita.setDataAgendamento(java.sql.Date.valueOf(df.format(dtAgendada
				.getDate())));

		visita.setDataCadastro(java.sql.Date.valueOf(df.format(dtCadastro
				.getDate())));

		banco.salvarOuAtualizarObjeto(visita);

		JOptionPane.showMessageDialog(panelDadosAgendamento,
				"Visita agendada com sucesso!");

		txtEnable(false);
		limpar();

		carregaTabela();

	}

	private void limpar() {
		txtIdAtendente.setText("");
		txtIdCaptacao.setText("");
		txtIdImovel.setText("");
		txtNomeAtendente.setText("");
		txtNomeCaptacao.setText("");
		txtNomeImovel.setText("");

	}

	private void txtEnable(boolean b) {
		txtIdAtendente.setEnabled(b);
		txtIdCaptacao.setEnabled(b);
		txtIdImovel.setEnabled(b);
		txtNomeAtendente.setEnabled(b);
		txtNomeCaptacao.setEnabled(b);
		txtNomeImovel.setEnabled(b);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
