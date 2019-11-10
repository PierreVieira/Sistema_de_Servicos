package Servicos;

public class ServicoValidoComPrestador extends ServicoValido{
    private String nome_usuario_profissional;
    private double preco;
    public ServicoValidoComPrestador(String tipo_servico, String nome_usuario_profissional, double preco) {
        super(tipo_servico);
        this.nome_usuario_profissional = nome_usuario_profissional;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.getTipoServico()+";"+this.nome_usuario_profissional+";"+this.preco+";";
    }

    public String getNome_usuario_profissional() {
        return nome_usuario_profissional;
    }

    public double getPreco() {
        return preco;
    }
}
