package Janela.Cadastro;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Persistence.*;

/**
 * JFrmCadastroPessoa cadastro da Pessoa view que cadastra ou altera uma Pessoa
 * 
 * @author Rogoberto
 *
 */
@SuppressWarnings("serial")
abstract class JFrmCadastro extends JDialog implements ActionListener {

	// Painel principal onde tudo é aberto aqui
	protected JPanel contentPane;
	protected JTextField txtObservacao;

	/**
	 * Classe Dao instanciada dentro dessa classe para pooder fazr alterações
	 * efetivas no banco
	 */
	protected Dao banco = new Dao();

	/**
	 * essa formatação será simplesmente para converter datas no formato em que
	 * o banco entende
	 */

	protected DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * btnSalvarAlterar podera assumir dois valores o Salvar ou Alterar quando
	 * não tiver nem uma captação setada nos txtfildes ficará disponivel o btn
	 * salvar para salvar um novo, quando já for inserido esse mesmo botão será
	 * alterar para liberar as teclas bloqueadas isso é feito por que teremos a
	 * opção de simplesmente visualizar sem a necessidade de sempre salvar
	 */
	protected JButton btnSalvarAlterar;
	/**
	 * btnCancelarDeletar assumira dois valores quando tivernos uma captaçãos
	 * setada no txtfild poderemos simplesmente deletar pois não estara em
	 * processo de criação e sim visualização de um item já criado, caso
	 * contrario para sair da tela pois nesse caso o sentido do usuario seria
	 * simplesmente visualizar algum dado que esta sendo exposto, caso
	 */
	protected JButton btnCancelarDeletar;

	// esta variavel quando não esta nula obotão salvar fica com o nome Alterar
	// e faz uma pesquisa preenchendo os valores dos campos com os de uma pessoa
	// já cadastrada
	protected Object objParaAlterar = null;

	/**
	 * Contrutor.
	 * 
	 * @param idFuncionario
	 */
	protected JFrmCadastro(Object obj) {
		setTitle("Titulo");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// deixa a janela acima das demais
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		btnSalvarAlterar = new JButton("Salvar");
		btnSalvarAlterar.setBounds(597, 422, 89, 23);
		contentPane.add(btnSalvarAlterar);

		btnCancelarDeletar = new JButton("Cancelar");
		btnCancelarDeletar.setBounds(696, 422, 89, 23);
		contentPane.add(btnCancelarDeletar);

		txtObservacao = new JTextField();
		txtObservacao.setColumns(10);
		txtObservacao.setBounds(10, 422, 577, 23);
		contentPane.add(txtObservacao);
		limparTxt();

		// quando a Objeto for nula será para cadastrar uma Objeto quando ela
		// não for quer dizer que será feita uma alteração da Objeto que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a Objeto
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (obj != null) {

			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setText("Deletar");
			
			txtEnable(false);
		}

		// aqui vou adicionar um observador dos botões para que quando um deles
		// for clicado a ação dele seja enviada para o metodo actionPerformed
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);
		objParaAlterar = obj;
		txtObservacao.setEditable(false);

	}

	/**
	 * metodo sobrescrito da implementação do actionlistiner, serve para
	 * observar se existe ações de algum botão
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Alterar":
			liberarAlteracao();
			btnSalvarAlterar.setText("Salvar");
			btnCancelarDeletar.setText("Cancelar");
			break;
		case "Salvar":
			salvar();
			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setText("Novo");
			break;
		case "Cancelar":
			dispose();
			break;
		case "Novo":
			txtEnable(true);
			limparTxt();
			btnSalvarAlterar.setText("Salvar");
			btnCancelarDeletar.setText("Cancelar");
			break;
		case "Deletar":
			int op = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente deletar?");
			System.out.println(op);
			if (op == 0) {
				JOptionPane.showMessageDialog(contentPane, "Você não tem autorização!");
			}
			break;

		default:
			break;
		}

	}

	/**
	 * Inserir simplesmente preenche os tctfildes com informações do parametro
	 * passado inclusive o box
	 * 
	 * @param ob
	 */
	abstract void inserir(Object ob);

	/**
	 * Salvar - verifica se existe algum id setado no txtId, caso exista se
	 * trata de um item que esta sendo alterado, caso contrario será a criação
	 * de um item, depois cria captação e seta seus valores, verifica se existe
	 * alguma captação para alterar caso exista salva alterando e feixa janela(
	 * nesse modo salva com o id existente), caso contrario salva um novo obj
	 * com um id novo e seta no txtId o novo id e coloca uma observação que
	 * nesse sentido sera gerado automaticamente por fim bloqueia e seta o
	 * btnCancelarDeletar para o valor novo caso deseje continuar criando um
	 * nova capação
	 * 
	 */

	abstract void salvar();

	/**
	 * libera alterações
	 */

	abstract void liberarAlteracao();

	/**
	 * limpa todas as caixas de txto e a data com data atual
	 */
	abstract void limparTxt();

	/**
	 * bloqueia ou desbloqueia os componentes que podem ser alterados
	 * 
	 * @param valor
	 */
	abstract void txtEnable(boolean valor);
}
