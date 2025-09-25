package conta_bancaria.model;

public abstract class Conta {

    private int numero;
    private int agencia;
    private int tipo; // 1 = Corrente, 2 = Poupança
    private String titular;
    private float saldo;

    public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(float valor) {
        if (this.saldo < valor) {
            System.out.println("\nSaldo Insuficiente!");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void visualizar() {
        String tipoConta = (this.tipo == 1) ? "Conta Corrente" : "Conta Poupança";

        System.out.println("\n***********************************************************");
        System.out.println("Dados da Conta:");
        System.out.println("***********************************************************");
        System.out.println("Número da Conta: " + this.numero);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Tipo da Conta: " + tipoConta);
        System.out.println("Titular: " + this.titular);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }
}
