package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Worker {
    //atributos
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    //atributos de associação/Composição
    private Department departamento;
    private List <HourContract> listaDeContratos = new ArrayList<>();   /* como o diagrama uml diz que um "worker" pode ter varios
                                                                 "HoursContract", usa-se a lista para a implementação*/
    //construtores
    public Worker(){

    }

    //a lista não foi implementada pelo construtor
    public Worker(String name, WorkerLevel level, Double baseSalary, Department departamento) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departamento = departamento;
    }

    //get e set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }
    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary){
        this.baseSalary = baseSalary;
    }

    public Department getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Department departamento) {
        this.departamento = departamento;
    }

    public List<HourContract> getListaDeContratos() {
        return listaDeContratos;
    }

    /*o método abaixo associa uma nova a lista de contratos ao "worker" mas a lista ja foi instanciada
    entao e necessario apenas metodos para inserir e remover contratos*/
    /*public void setListaDeContratos(List<HourContract> listaDeContratos) {
        this.listaDeContratos = listaDeContratos;
    }*/

    //métodos
    //adicionar contrato na lista
    public void adicionarContrato(HourContract contract){
        this.listaDeContratos.add(contract);
    }

    //remover contrato na lista
    public void removerContratot(HourContract contract){
        this.listaDeContratos.remove(contract);
    }

    //somar os ganhos de um determinado mes e ano
    public double ganhos(int ano, int mes){
        Double somaDosGanhos = baseSalary;

        //cria o calendario para testar  os meses no contrato
        Calendar calendarioParaTeste = Calendar.getInstance();

        //esse "for each" testa cada "HourContract" na "List" "listaDeContratos"
        for(HourContract contrato : listaDeContratos){

            // o "Calendar" "cal" recebe a data do contrato
            /*OBS: o metodo "setTime" espera um dado do tipo "Date" e o metodo
            "getDataDoContrato" retorna um "Date"*/
            calendarioParaTeste.setTime(contrato.getDataDoContrato());

            //instancia a variavel com o ano e o mes
            int cal_ano = calendarioParaTeste.get(Calendar.YEAR);
            int cal_mes = 1 + calendarioParaTeste.get(Calendar.MONTH);

            /*testa se ano do contrato corresponde ao informado e adiciona
            o valor ganho no contrato a soma total*/
            if (cal_ano == ano && cal_mes == mes){
                somaDosGanhos = somaDosGanhos + contrato.valorGanhoNoContrato();
            }
        }
        return somaDosGanhos;
    }
}
