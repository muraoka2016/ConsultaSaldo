import java.util.Scanner;

public class ConsultaConta {
    /* Criar uma aplicação que mostre os dados do cliente em uma string e
    possibilite realizar as seguintes operações por meio de requisição:
    1 - Consultar saldo
    2 - Receber valor
    3 - Transferir valor
    4 - Sair
    Os dados iniciais do cliente no extrato devem ser:
    a) Nome completo
    b) Tipo de conta
    c) saldo
     */
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        double saldoAtual = 2500.00;
        String nome = "Felipe Muraoka Cardena Silva";
        String tipoConta = "Conta corrente";

            String extratoConta = """
                ****************************************************
                
                Nome: %s
                Tipo de conta: %s
                Saldo atual : %.2f
                
                *****************************************************
                
                Operações
                1- Consultar saldo
                2- Realizar transferêcia
                3- Receber transferência
                4- Consultar extrato
                5- Sair
                """ .formatted(nome, tipoConta, saldoAtual);
            System.out.println(extratoConta);

        while(true) {
            System.out.println("Digite a opção desejada");
            int opcaoDesejada = leitura.nextInt();

            if (opcaoDesejada == 1) {
                System.out.println("O seu saldo é de " + String.format("%.2f", saldoAtual));
            } else if (opcaoDesejada == 2) {
                System.out.println("Digite o valor que deseja transferir: ");
                double valorTransferencia = leitura.nextDouble();
                double saldoTransf = saldoAtual - valorTransferencia;
                if(valorTransferencia > saldoAtual) {
                    System.out.println("Não é possível realizar a operação");
                } else {
                    saldoAtual -= valorTransferencia;
                    System.out.println("Operação realizada. O seu saldo é de " + String.format("%.2f", saldoAtual));
                }
            } else if (opcaoDesejada == 3) {
                System.out.println("Informe o valor a receber: ");
                double valorReceber = leitura.nextDouble();
                double saldoReceber = saldoAtual + valorReceber;
                saldoAtual += valorReceber;
                System.out.println("Operação realizada. O seu saldo é de " + String.format("%.2f", saldoAtual));
            } else if (opcaoDesejada == 4) {
                System.out.println(extratoConta);
            } else if (opcaoDesejada == 5) {
                System.out.println("Operação finalizada.");
                break;
            } else if (opcaoDesejada > 5) {
                System.out.println("Número inválido, por favor, digite uma opção válida.");
            }
        }

    }
}
