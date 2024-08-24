package entities;
import java.util.Date;
public class HourContract {

    //Parametros
    private Date dataDoContrato;
    private Double valorGanhoPorHora;
    private Integer horas;

    //contrutores
    public HourContract(){

    }

    public HourContract(Date dataDocontrato, Double valorPorHora, Integer horas){
        this.dataDoContrato = dataDoContrato;
        this.valorGanhoPorHora = valorPorHora;
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
        return valorGanhoPorHora;
    }
    public void setValorPorHora(Double valorPorHora){
        this.valorGanhoPorHora = valorPorHora;
    }

    public Integer getHoras(){
        return horas;
    }
    public void setHoras(Integer horas){
        this.horas = horas;
    }

    //métodos
    public Double valorGanhoNoContrato(){
        return horas * valorGanhoPorHora;
    }
}
