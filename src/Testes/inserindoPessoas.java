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
				"SamuelRafael", "João", "Pedro", "Heloísa", "Daniel",
				"Isadora", "Vitor", "Lívia", "Leonardo", "Maria", "Clara",
				"Henrique", "Ana", "Clara", "Theo", "Lorena", "Murilo",
				"Gabriela", "Eduardo", "Yasmin", "Pedro", "Henrique",
				"Isabelly", "Pietro", "Sarah", "Cauã", "Ana", "Julia", "Isaac",
				"Letícia", "Caio", "Ana", "Luiza", "Vinicius", "Melissa",
				"Benjamin", "Marina", "João", "Clara", "Lucca", "Cecília",
				"João", "Miguel", "Esther", "Bryan", "Emanuelly",
				"Joaquim	Rebeca", "João", "VitorAna", "Beatriz", "Thiago",
				"Lavínia", "Antôxnio", "Vitória", "Davi", "Lucas", "Bianca",
				"Francisco", "Catarina", "Enzo", "Gabriel", "Larissa", "Bruno",
				"Maria", "Fernanda", "Emanuel", "Fernanda", "João", "Gabriel",
				"Amanda", "Ian", "Alícia", "Davi", "Luiz", "Carolina",
				"Rodrigo", "Agatha", "Otávio" };
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
