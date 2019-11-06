package Concretos;

public class Servicos {

    private String tipoServico;
    private double valorServico;
    private boolean situacao;

    public Servicos(String tipoServico, double valorServico) {
        this.tipoServico = tipoServico;
        this.valorServico = valorServico;
        this.situacao = false;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}