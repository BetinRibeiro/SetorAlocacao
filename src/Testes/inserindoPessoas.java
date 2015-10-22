package Testes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.sun.jndi.url.dns.dnsURLContext;

import Bin.Endereco;
import Bin.Interessado.Interessado;
import Bin.Pessoa.Filiacao;
import Bin.Pessoa.Pessoa;
import Bin.Pessoa.Telefone;
import Persistence.Dao;

public class inserindoPessoas {

	public static void main(String[] args) {
		Dao dao = new Dao();
		//TODO Quantas Clientes;
		int numClientes = 100;

		String[] listaNomes = { "Miguel", "Sophia", "Davi", "Alice", "Arthur",
				"Julia", "Pedro", "Isabella", "Gabriel", "Manuela", "Bernardo",
				"Laura", "Lucas", "Luiza", "Matheus", "Valentina", "Rafael",
				"Giovanna", "Heitor", "Maria", "Eduarda", "Enzo", "Helena",
				"Guilherme", "Beatriz", "Nicolas", "Maria", "Luiza", "Lorenzo",
				"Lara", "Gustavo", "Mariana", "Felipe", "Nicole",
				"SamuelRafael", "Jo�o", "Pedro", "Helo�sa", "Daniel",
				"Isadora", "Vitor", "L�via", "Leonardo", "Maria", "Clara",
				"Henrique", "Ana", "Clara", "Theo", "Lorena", "Murilo",
				"Gabriela", "Eduardo", "Yasmin", "Pedro", "Henrique",
				"Isabelly", "Pietro", "Sarah", "Cau�", "Ana", "Julia", "Isaac",
				"Let�cia", "Caio", "Ana", "Luiza", "Vinicius", "Melissa",
				"Benjamin", "Marina", "Jo�o", "Clara", "Lucca", "Cec�lia",
				"Jo�o", "Miguel", "Esther", "Bryan", "Emanuelly",
				"Joaquim	Rebeca", "Jo�o", "VitorAna", "Beatriz", "Thiago",
				"Lav�nia", "Ant�xnio", "Vit�ria", "Davi", "Lucas", "Bianca",
				"Francisco", "Catarina", "Enzo", "Gabriel", "Larissa", "Bruno",
				"Maria", "Fernanda", "Emanuel", "Fernanda", "Jo�o", "Gabriel",
				"Amanda", "Ian", "Al�cia", "Davi", "Luiz", "Carolina",
				"Rodrigo", "Agatha", "Ot�vio" };
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < listaNomes.length; i++) {
			
			lista.add(listaNomes[i]);
			
		}
		
		for (int i = 0; i < numClientes; i++) {
			Collections.shuffle(lista);
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(lista.get(0)+" "+lista.get(0));
			pessoa.setEmail(i+"email@gmail.com");
			pessoa.setCpf(183465+i);
			pessoa.setRg(7594372+i);
			
			
			pessoa.setCargo("rwe");
			pessoa.setNaturalidade("rwe");
			pessoa.setNascionalidade("rwe");
			pessoa.setObservacao("rew");

			Endereco endereco = new Endereco();
			endereco.setBairro("rwe");
			endereco.setCep("rwe");
			endereco.setCidade("rew");
			endereco.setLougradouro("rwe");
			endereco.setUf("rew");

			pessoa.setEnd(endereco);

			Telefone telefone = new Telefone();
			telefone.setFone1(98798765);
			telefone.setFone2(56098765);

			pessoa.setTelefone(telefone);

			Filiacao filiacao = new Filiacao();
			filiacao.setNomeMae("re");
			filiacao.setNomePai("fds");

			pessoa.setFiliacao(filiacao);
			pessoa.setEscolaridade("re");
			pessoa.setEstadoCivil("sde");
			pessoa.setSexo("fsd");
			pessoa.setUfrg("fds");
			pessoa.setUfNaturalidade("fsd");
			pessoa.setOrgaoEspedidor("fds");

			pessoa.setDataNascimento(new Date());
			
			dao.salvarObjeto(pessoa);
			System.out.println(pessoa.getNome());
			
		}

	}
}
