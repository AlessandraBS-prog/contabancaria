package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;

import java.util.ArrayList;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {
	static ArrayList<Conta> contas = new ArrayList<Conta>();
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int opcao;
     // Teste da Conta Corrente
        ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "José da Silva", 0.0f, 1000.0f);
        cc1.visualizar();
        cc1.sacar(12000.0f);
        cc1.visualizar();
        cc1.depositar(5000.0f);
        cc1.visualizar();

        // Teste da Conta Poupança
        ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Maria dos Santos", 100000.0f, 15);
        cp1.visualizar();
        cp1.sacar(1000.0f);
        cp1.visualizar();
        cp1.depositar(5000.0f);
        cp1.visualizar();


        while (true) {
            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
                    + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                BANCO DO BRAZIL COM Z                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                          ");
            System.out.println("            2 - Listar todas as Contas               ");
            System.out.println("            3 - Buscar Conta por Numero              ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);

            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
               case 1:
            	    System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n");

            	    System.out.print("Número da Conta: ");
            	    int numero = leia.nextInt();
            	    leia.nextLine(); // limpar buffer

            	    System.out.print("Número da Agência: ");
            	    int agencia = leia.nextInt();
            	    leia.nextLine();

            	    System.out.print("Tipo da Conta (1 - Corrente / 2 - Poupança): ");
            	    int tipo = leia.nextInt();
            	    leia.nextLine();

            	    System.out.print("Nome do Titular: ");
            	    String titular = leia.nextLine();

            	    System.out.print("Saldo Inicial: ");
            	    float saldo = Float.parseFloat(leia.nextLine());

            	    Conta novaConta = new Conta(numero, agencia, tipo, titular, saldo);

            	    contas.add(novaConta); // ✅ adiciona à lista

            	    System.out.println("\nConta criada com sucesso!");
            	    novaConta.visualizar();
            	    break;


            case 2:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n");

                if (contas.isEmpty()) {
                    System.out.println("Nenhuma conta cadastrada.");
                } else {
                    for (Conta c : contas) {
                        c.visualizar();
                    }
                }
                break;

            case 3:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar Conta por Número\n");

                System.out.print("Digite o número da conta: ");
                int numeroBusca = leia.nextInt();

                Conta contaEncontrada = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroBusca) {
                        contaEncontrada = c;
                        break;
                    }
                }

                if (contaEncontrada != null) {
                    System.out.println("\nConta encontrada:");
                    contaEncontrada.visualizar();
                } else {
                    System.out.println("\nConta não encontrada.");
                }
                break;

            case 4:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar Dados da Conta\n");

                System.out.print("Digite o número da conta que deseja atualizar: ");
                int numeroAtualizar = leia.nextInt();
                leia.nextLine(); // limpar buffer

                Conta contaAtualizar = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroAtualizar) {
                        contaAtualizar = c;
                        break;
                    }
                }

                if (contaAtualizar != null) {
                    System.out.print("Novo nome do titular: ");
                    String novoTitular = leia.nextLine();

                    System.out.print("Novo tipo da conta (1 - Corrente / 2 - Poupança): ");
                    int novoTipo = leia.nextInt();
                    leia.nextLine();

                    System.out.print("Novo saldo: ");
                    float novoSaldo = Float.parseFloat(leia.nextLine());

                    contaAtualizar.setTitular(novoTitular);
                    contaAtualizar.setTipo(novoTipo);
                    contaAtualizar.setSaldo(novoSaldo);

                    System.out.println("\nConta atualizada com sucesso!");
                    contaAtualizar.visualizar();
                } else {
                    System.out.println("\nConta não encontrada.");
                }
                break;

            case 5:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar Conta\n");

                System.out.print("Digite o número da conta que deseja apagar: ");
                int numeroApagar = leia.nextInt();

                Conta contaParaRemover = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroApagar) {
                        contaParaRemover = c;
                        break;
                    }
                }

                if (contaParaRemover != null) {
                    contas.remove(contaParaRemover);
                    System.out.println("\nConta removida com sucesso!");
                } else {
                    System.out.println("\nConta não encontrada.");
                }
                break;

            case 6:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Sacar\n");

                System.out.print("Digite o número da conta: ");
                int numeroSaque = leia.nextInt();

                Conta contaSaque = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroSaque) {
                        contaSaque = c;
                        break;
                    }
                }

                if (contaSaque != null) {
                    System.out.print("Digite o valor do saque: ");
                    float valorSaque = leia.nextFloat();

                    if (valorSaque <= contaSaque.getSaldo()) {
                        contaSaque.setSaldo(contaSaque.getSaldo() - valorSaque);
                        System.out.println("\nSaque realizado com sucesso!");
                        contaSaque.visualizar();
                    } else {
                        System.out.println("\nSaldo insuficiente para realizar o saque.");
                    }
                } else {
                    System.out.println("\nConta não encontrada.");
                }
                break;

            case 7:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Depositar\n");

                System.out.print("Digite o número da conta: ");
                int numeroDeposito = leia.nextInt();

                Conta contaDeposito = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroDeposito) {
                        contaDeposito = c;
                        break;
                    }
                }

                if (contaDeposito != null) {
                    System.out.print("Digite o valor do depósito: ");
                    float valorDeposito = leia.nextFloat();

                    contaDeposito.setSaldo(contaDeposito.getSaldo() + valorDeposito);
                    System.out.println("\nDepósito realizado com sucesso!");
                    contaDeposito.visualizar();
                } else {
                    System.out.println("\nConta não encontrada.");
                }
                break;

            case 8:
                System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n");

                System.out.print("Digite o número da conta de origem: ");
                int numeroOrigem = leia.nextInt();

                System.out.print("Digite o número da conta de destino: ");
                int numeroDestino = leia.nextInt();

                Conta contaOrigem = null;
                Conta contaDestino = null;

                for (Conta c : contas) {
                    if (c.getNumero() == numeroOrigem) {
                        contaOrigem = c;
                    }
                    if (c.getNumero() == numeroDestino) {
                        contaDestino = c;
                    }
                }

                if (contaOrigem != null && contaDestino != null) {
                    System.out.print("Digite o valor da transferência: ");
                    float valorTransferencia = leia.nextFloat();

                    if (valorTransferencia <= contaOrigem.getSaldo()) {
                        contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransferencia);
                        contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);

                        System.out.println("\nTransferência realizada com sucesso!");
                        System.out.println("\nConta de Origem:");
                        contaOrigem.visualizar();
                        System.out.println("\nConta de Destino:");
                        contaDestino.visualizar();
                    } else {
                        System.out.println("\nSaldo insuficiente na conta de origem.");
                    }
                } else {
                    System.out.println("\nConta de origem ou destino não encontrada.");
                }
                break;

            default:
                System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Alessandra - alessandra@email.com");
        System.out.println("github.com/AlessandraBS-prog");
        System.out.println("*********************************************************");
    }
}
