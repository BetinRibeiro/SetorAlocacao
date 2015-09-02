package Funcoes;

/**
 *
 * @author izaquiellopesdebessas
 */
public class ValidaCPF {

	/**
	 * <h1>Valida se o CPF fornecido � um CPF v�lido</h1>
	 *
	 * Deve-se fornecer um CPF (em string), para que este seja validado.
	 *
	 * @param sCpf
	 *            CPF a ser validado.
	 * @return verdadeiro caso o CPF fornecido for um CPF v�lido e falso caso
	 *         n�o seja v�lido.
	 */
	public boolean isCPF(String sCpf) {
		int[] cpf = new int[9];
		int[] pesos = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int dv1, dv2; // dv = digito verificador

		for (int i = 0, j = 8; i < sCpf.length() - 2; i++) {
			try { // monta o doc, ignora a mascara, le da esq para dir, e
					// escreve da dir para esq
				cpf[j] = Integer.parseInt(sCpf.substring(i, i + 1));
				j--;
			} catch (Exception e) {
			}
		}
		dv1 = calculaDV(cpf, pesos);

		int[] aux = new int[10];
		aux[0] = dv1;
		cpf = tranfereConteudo(cpf, aux);

		dv2 = calculaDV(cpf, pesos);
		String dv = String.valueOf(dv1) + String.valueOf(dv2);

		if (verificaConteudoIgualVetor(cpf)) {
			return false;
		}
		if (sCpf.endsWith(dv)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcula o digito verificador
	 *
	 * @param doc
	 *            CPF, vetor de inteiros contendo o CPF
	 * @param pesos
	 *            pesos, vetor de inteiros com valores pr�-determinados de
	 *            acordo com sua posi��o no vetor
	 * @return retorna-se a soma dos produtos do vetor de pesos e CPF,
	 *         somat�rio(<i>vp[i] x vc[i]</i>)
	 */
	private int calculaDV(int[] doc, int[] pesos) {
		int soma = 0;
		for (int i = 0; i < doc.length; i++) {
			soma += doc[i] * pesos[i];
		}
		soma %= 11;
		if (soma == 10) {
			soma = 0;
		}
		return soma;
	}

	/**
	 * Transfere o conte�do do vetor menor para o vetor maior, atrav�s de uma
	 * opera��o nativa, System.arraycopy
	 *
	 * @param menor
	 *            menor vetor
	 * @param maior
	 *            maior vetor
	 * @return retorna-se o vetor maior, com o conte�do do vetor menor.
	 */
	private int[] tranfereConteudo(int[] menor, int[] maior) {
		System.arraycopy(menor, 0, maior, 1, menor.length);
		return maior;
	}

	/**
	 * Verifica se o conte�do do vetor � igual entre si
	 *
	 * @param vet
	 *            vetor de inteiros
	 * @return caso <i>v[i]</i> for diferente de <i>v[i + 1]</i>, retorna-se
	 *         falso, sen�o, ao final da compara��o, retorna-se verdadeiro.
	 */
	private boolean verificaConteudoIgualVetor(int[] vet) {
		for (int i = 0; i < vet.length - 1; i++) {
			if (vet[i] != vet[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <h1>Verifica qual foi o estado que emitiu o CPF</h1>
	 *
	 * Alguns estados podem possuir o mesmo d�gito de verifica��o, portanto, nem
	 * sempre � poss�vel dizer com precis�o, qual o estado emissor. Abaixo h�
	 * uma tabela demonstrando o identificador de cada estado. <br/>
	 * <br/>
	 * <center>
	 * <table cellpadding="2" cellspacing="1" width="230">
	 * <tbody>
	 * <tr>
	 * <td width="30%"><b>N�mero</b></td>
	 * <td width="70%"><b>Estado</b></td>
	 * </tr>
	 * <tr>
	 * <td width="30%">1</td>
	 * <td width="70%">GO/MT/MS/DF/TO</td>
	 * </tr>
	 * <tr>
	 * <td width="30%">2</td>
	 * <td width="70%">AM/AC/PA/RR/RO/AP</td>
	 * </tr>
	 * <tr>
	 * <td width="30%">3</td>
	 * <td width="70%">MA/CE/PI</td>
	 * </tr>
	 * <tr>
	 * <td width="30%">4</td>
	 * <td width="70%">RN/PB/PE/AL</td>
	 * </tr>
	 * <tr>
	 * <td width="30%">5</td>
	 * <td width="70%">SE/BA</td>
	 * </tr>
	 * <tr>
	 * <td * width="30%">6</td>
	 * <td width="70%">MG</td>
	 * </tr>
	 * <tr>
	 * <td * width="30%">7</td>
	 * <td width="70%">RJ/ES</td>
	 * </tr>
	 * <tr>
	 * <td * width="30%">8</td>
	 * <td width="70%">SP</td>
	 * </tr>
	 * <tr>
	 * <td * width="30%">9</td>
	 * <td width="70%">PR/SC</td>
	 * </tr>
	 * <tr>
	 * <td * width="30%">0</td>
	 * <td width="70%">RS</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * </center>
	 *
	 * @param sCpf
	 *            CPF a ser verificado
	 * @return sigla, ou siglas, do estado que emitiu o CPF
	 */
	public String estadoEmitente(String sCpf) {
		int[] cpf = new int[11];
		for (int i = 0; i < cpf.length; i++) {
			try {
				cpf[i] = Integer.parseInt(String.valueOf(sCpf.charAt(i)));
			} catch (Exception e) {
			}
		}
		if (cpf[8] == 0) {
			return "RS";
		} else if (cpf[8] == 1) {
			return "GO/MT/MS/DF/TO";
		} else if (cpf[8] == 2) {
			return "AM/AC/PA/RR/RO/AP";
		} else if (cpf[8] == 3) {
			return "MA/CE/PI";
		} else if (cpf[8] == 4) {
			return "RN/PB/PE/AL";
		} else if (cpf[8] == 5) {
			return "SE/BA";
		} else if (cpf[8] == 6) {
			return "MG";
		} else if (cpf[8] == 7) {
			return "RJ/ES";
		} else if (cpf[8] == 8) {
			return "SP";
		} else if (cpf[8] == 9) {
			return "PR/SC";
		} else {
			return "";
		}
	}
}
