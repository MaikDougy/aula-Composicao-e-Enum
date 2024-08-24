package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Locale;
public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);

        //objeto para formatar a data do contrato informado pelo usuario
        SimpleDateFormat formartarData = new SimpleDateFormat("dd/MM/yyyy");

        //instacia um objeto do tipo departamento para ser passado para o construtor
        System.out.print("Entre com o nome do departamento: ");
        String departamento = leitor.nextLine();
        Department d = new Department();
        d.setNomeDoDepartamento(departamento);

        System.out.println("Entre com os dados do trabalhador:");
        System.out.println("nome:");
        String nomeDoTrabalhador = leitor.nextLine();
        System.out.println("Cargo: ");
        String cargo = leitor.nextLine();
        System.out.println("Salário base: ");
        double salarioBase = leitor.nextDouble();

        Worker trabalhador = new Worker(nomeDoTrabalhador, WorkerLevel.valueOf(cargo.toUpperCase()), salarioBase, d);

        System.out.println("quantos contratos o trabalhador tem? ");
        int quantidadeContratos = leitor.nextInt();

        for (int i = 1; i <= quantidadeContratos; i++) {

            //ler os dados para criar o contrato
            System.out.println("Entre com os dados do " + i + "° contrato: ");
            System.out.println("Data do contrarto (DD/MM/YYYY): ");
            leitor.nextLine();
            String dataDigitada = leitor.nextLine();

            //formata a String digitado para o tipo "Date"
            Date dataDoContrato = formartarData.parse(dataDigitada);

            System.out.println("Valor por hora: ");
            double valorPorHora = leitor.nextDouble();

            System.out.println("Duração do contrato: (horas)");
            int duracao = leitor.nextInt();

            //criar contrato
            HourContract contrato = new HourContract(dataDoContrato, valorPorHora, duracao);

            //associar contrato ao trabalhador
            trabalhador.adicionarContrato(contrato);

        }
        leitor.nextLine();
        System.out.println();
        System.out.println("Entre com o mês e ano para consulta de valores recebidos (MM/YYYY): ");
        String mes_e_ano = leitor.nextLine();

        /*"parseInt" converte a String para inteiro, "substring" recorta a String
        com os valores passados como parametro OBS: é passado uma posição a mais
         do que deseja ser recortado*/
        int mes = Integer.parseInt(mes_e_ano.substring(0, 2));
        int ano = Integer.parseInt(mes_e_ano.substring(3));
        System.out.println("Nome do trabalhador: " + trabalhador.getName());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNomeDODepartamento());

        double ganhosTotais = trabalhador.ganhos(ano, mes);
        System.out.println("Ganhos do mês " + mes_e_ano + ": " + ganhosTotais);

        leitor.close();
    }
}