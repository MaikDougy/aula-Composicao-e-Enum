package entities;

public class Department {
    private String nomeDoDepartamento;

    //construtores
    public Department() {

    }

    public Department (String nomeDoDepartamento) {
        this.nomeDoDepartamento = nomeDoDepartamento;
    }

    public String getNomeDODepartamento() {
        return nomeDoDepartamento;
    }

    public void setNomeDoDepartamento(String nomeDODepartamento){
        this.nomeDoDepartamento = nomeDODepartamento;
    }
}
