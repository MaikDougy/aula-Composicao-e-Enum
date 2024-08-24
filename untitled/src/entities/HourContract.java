package entities;
import java.util.Date;
public class HourContract {

    //Parametros
    private Date dataDoContrato;
    private Double valorPorHora;
    private Integer horas;

    //contrutores
    public HourContract(){

    }

    public HourContract(Date dataDocontrato, Double valorPorHora, Integer horas){
        this.dataDoContrato = dataDoContrato;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    //get e set
    public Date getDataDoContrato(){
        return dataDoContrato;
    }
    public void setdataDoContrato(Date dataDoContrato){
        this.dataDoContrato = dataDoContrato;
    }

    public Double getValorPorHora (){
        return valorPorHora;
    }
    public void setValorPorHora(Double valorPorHora){
        this.valorPorHora = valorPorHora;
    }

    public Integer getHoras(){
        return horas;
    }
    public void setHoras(Integer horas){
        this.horas = horas;
    }

    //métodos
    public Double calcularHoras(){
        return horas * valorPorHora;
    }
}
