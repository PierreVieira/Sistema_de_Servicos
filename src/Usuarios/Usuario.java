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
    //Get e set

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

