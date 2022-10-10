package one.digitalinnovation.com;

public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(int agencia, Cliente cliente) {
        this.agencia = agencia;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (saldo > valor) {
            saldo -= valor;
            mensagemOperacaoStatus("success");
        } else {
            mensagemOperacaoStatus("failure");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0)  return;

        saldo += valor;
        mensagemOperacaoStatus("success");
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (saldo > valor) {
            sacar(valor);
            contaDestino.depositar(valor);
        } else {
            mensagemOperacaoStatus("failure");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Cliente: " + cliente.getNome() + " CPF: " + cliente.getCpf());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.printf("Saldo: R$ %.2f", saldo);
    }

    private void mensagemOperacaoStatus(String status) {
        switch (status) {
            case "success" -> System.out.println("Operação efetuada com sucesso!");
            case "failure" -> {
                System.out.println("Impossível efetuar operação!");
                System.out.println("Saldo insuficiente.");
            }
        }
    }
}
