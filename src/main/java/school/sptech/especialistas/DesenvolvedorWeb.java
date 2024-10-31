package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public DesenvolvedorWeb() {
    }

    public DesenvolvedorWeb(String backend, String frontend, String sgbd, Integer horasMentoria) {
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + (horasMentoria * 300.00);
    }

    public Boolean isFullstack(){
        if (frontend != null && backend != null && sgbd != null){
            return true;
        }
        return false;
    }
}
