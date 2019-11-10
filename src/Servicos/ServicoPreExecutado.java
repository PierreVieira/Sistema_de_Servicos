//Antônio Pierre Maritns Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Servicos;

public class ServicoPreExecutado extends ServicoValidoComPrestador {
    private String nome_usuario_cliente;
    public ServicoPreExecutado(String tipo_servico, String nome_usuario_profissional, double preco, String nome_usuario_cliente) {
        super(tipo_servico, nome_usuario_profissional, preco);
        this.nome_usuario_cliente = nome_usuario_cliente;
    }

    public String getNome_usuario_cliente() {
        return nome_usuario_cliente;
    }

    @Override
    public String toString() {
        return this.getTipoServico()+";"+this.getNome_usuario_profissional()+";"+this.getPreco()+";"+this.getNome_usuario_cliente()+";";
    }
}
