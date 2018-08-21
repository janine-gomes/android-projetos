package janine.gomes.projetofinal.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String idUser;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String idUser, String nome, String email, String senha) {
        this.idUser = idUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUser = " + idUser + '\'' +
                "\nNome = " + nome + '\'' +
                "\nEmail = " + email + '\'' +
                "\nSenha = " + senha + '\'' +
                '}';
    }
}
