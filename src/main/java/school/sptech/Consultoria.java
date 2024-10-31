package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas ){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios(){
        Double salarioTotal = 0.0;
        for (Desenvolvedor devDaVez : desenvolvedores){
            salarioTotal = salarioTotal + devDaVez.calcularSalario();
        }
        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer contador = 0;
        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez instanceof DesenvolvedorMobile){
                contador = contador + 1;
            }
        }
        return contador;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();
        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez.calcularSalario() >= salario){
                desenvolvedoresEncontrados.add(devDaVez);
            }
        }
        return desenvolvedoresEncontrados;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Double menorSalario = 999999.9;
        Desenvolvedor desenvolvedorComMenorSalario = null;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor devDaVez = desenvolvedores.get(i);
            if (devDaVez.calcularSalario()<menorSalario){
                desenvolvedorComMenorSalario = devDaVez;
                menorSalario = devDaVez.calcularSalario();
            }
        }
        return desenvolvedorComMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem() == tecnologia || ((DesenvolvedorMobile) desenvolvedor).getPlataforma() == tecnologia){
                    desenvolvedoresEncontrados.add(desenvolvedor);
                }
            }
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getBackend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getFrontend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getSgbd() == tecnologia){
                    desenvolvedoresEncontrados.add(desenvolvedor);
                }
            }
        }
        return desenvolvedoresEncontrados;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> listaEncontrada = buscarPorTecnologia(tecnologia);
        Double salarioTotal = 0.0;
        for (Desenvolvedor desenvolvedor : listaEncontrada){
            salarioTotal = salarioTotal + desenvolvedor.calcularSalario();
        }
        return salarioTotal;
    }

}
