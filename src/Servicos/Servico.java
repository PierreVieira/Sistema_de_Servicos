//Antônio Pierre Maritns Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Servicos;

public class Servico {
    private String tipoServico;
    Servico(String tipoServico){
        this.tipoServico = tipoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        return this.getTipoServico()+";";
    }
}