//Antônio Pierre Maritns Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Usuarios;

public class Usuario {

    private String nome, endereco, email, telefone, nomeUsuario, senha;
    private boolean logado;
    Usuario(String nome, String endereco, String email, String telefone, String nomeUsuario, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.logado = false;
    }

    public boolean equals(String nome_usuario, String senha){
        return this.nomeUsuario.equals(nome_usuario) && this.senha.equals(senha);
    }

    public String toString(){
        return this.nome+";"+this.endereco+";"+this.email+";"+this.telefone+";"+this.nomeUsuario+";"+this.senha+";";
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }
}

