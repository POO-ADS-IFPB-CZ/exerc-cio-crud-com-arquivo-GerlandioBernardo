package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pessoa  implements Serializable {
    private long serialVersionUID;
    private String nome;
    private String email;
    Set<Pessoa> pessoas;

    public Pessoa(String nome, String email) {
        serialVersionUID = 1L;
        this.nome = nome;
        this.email = email;
        this.pessoas = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
