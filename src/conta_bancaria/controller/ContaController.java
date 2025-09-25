package conta_bancaria.controller;

import java.util.ArrayList;
import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> contas = new ArrayList<Conta>();

	@Override
	public void listarTodas() {
		for (Conta conta : contas) {
		    conta.visualizar();
		}

		
	}

	@Override
	public void cadastrar(Conta conta) {
		contas.add(conta);
		System.out.println("\nA conta número " + conta.getNumero() + " foi cadastrada com sucesso!");

		
	}

	@Override
	public void procurarPorNumero(int numero) {
		Conta conta = buscarNaCollection(numero);

		if (conta != null) {
		    conta.visualizar();
		} else {
		    System.out.println("\nA conta número " + numero + " não foi encontrada.");
		}

		
	}

	@Override
	public void atualizar(Conta conta) {
		Conta buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
		    contas.set(contas.indexOf(buscaConta), conta);
		    System.out.println("\nA conta número " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
		    System.out.println("\nA conta número " + conta.getNumero() + " não foi encontrada.");
		}

		
	}

	@Override
	public void deletar(int numero) {
		Conta conta = buscarNaCollection(numero);

		if (conta != null) {
		    if (contas.remove(conta)) {
		        System.out.println("\nA conta número " + numero + " foi deletada com sucesso!");
		    }
		} else {
		    System.out.println("\nA conta número " + numero + " não foi encontrada.");
		}

		
	}

	@Override
	public void sacar(int numero, float valor) {
		Conta conta = buscarNaCollection(numero);

		if (conta != null) {
		    if (conta.sacar(valor)) {
		        System.out.println("\nSaque na conta número " + numero + " foi realizado com sucesso!");
		    }
		} else {
		    System.out.println("\nA conta número " + numero + " não foi encontrada.");
		}

		
	}

	@Override
	public void depositar(int numero, float valor) {
		Conta conta = buscarNaCollection(numero);

		if (conta != null) {
		    conta.depositar(valor);
		    System.out.println("\nDepósito na conta número " + numero + " foi realizado com sucesso!");
		} else {
		    System.out.println("\nA conta número " + numero + " não foi encontrada.");
		}

		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Conta contaOrigem = buscarNaCollection(numeroOrigem);
		Conta contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
		    if (contaOrigem.sacar(valor)) {
		        contaDestino.depositar(valor);
		        System.out.println("\nTransferência da conta " + numeroOrigem + " para a conta " + numeroDestino + " realizada com sucesso!");
		    }
		} else {
		    System.out.println("\nConta de origem ou destino não encontrada.");
		}

		
	}

    // Aqui você vai implementar os métodos da interface
	public Conta buscarNaCollection(int numero) {
	    for (Conta conta : contas) {
	        if (conta.getNumero() == numero) {
	            return conta;
	        }
	    }
	    return null;
	}
}
