package Servicos;

public class ServicoValidoComPrestador extends ServicoValido{
    private String profissional;
    private double preco;
    public ServicoValidoComPrestador(String tipo_servico, String profissional, double preco) {
        super(tipo_servico);
        this.profissional = profissional;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.getTipoServico()+";"+this.profissional+";"+this.preco+";";
    }
}
