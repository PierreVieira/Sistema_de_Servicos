package Concretos;

public class Servico {

    private String tipoServico;
    private double valorServico;
    private boolean ativo;
    private Cliente cliente;
    private Profissional profissional;
    private boolean executado;

    public Servico(String tipoServico) {
        this.tipoServico = tipoServico;
        this.ativo = false;
        this.executado = false;
        this.cliente = null;
        this.profissional = null;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public boolean isExecutado() {
        return executado;
    }

    public void setExecutado(boolean executado) {
        this.executado = executado;
    }
}