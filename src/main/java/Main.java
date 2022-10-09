import one.digitalinnovation.com.Cliente;
import one.digitalinnovation.com.Conta;
import one.digitalinnovation.com.ContaCorrente;
import one.digitalinnovation.com.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "111.222.333-44");
        Cliente cliente2 = new Cliente("Letícia", "444.333.222-11");

        Conta conta1 = new ContaCorrente(123456, cliente1);
        Conta conta2 = new ContaPoupanca(444562, cliente2);

        System.out.println("------------------ Depósito ----------------------");
        conta1.depositar(1000.0);

        System.out.println("------------------ Saque -------------------------");
        conta1.sacar(20000.0);

        System.out.println("------------------ Transferência -----------------");
        conta1.transferir(conta2, 100.50);

        System.out.println("------------------ Extrato -----------------------");
        conta1.imprimirExtrato();
        System.out.println("\n------------------------------------------------");
        conta2.imprimirExtrato();
    }
}
