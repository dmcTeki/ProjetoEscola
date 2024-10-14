package br.ufpb.dcx.davi;

import java.util.Objects;

public class Aluno implements Comparable <Aluno> {
    private String nome;
    private String serie;
    private String matricula;
    public Aluno(String nome, String serie, String matricula) {
        this.nome = nome;
        this.serie = serie;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", série='" + serie + '\'' +
                ", matrícula='" + matricula + '\'' +
                '}';
    }

    @Override
    public int compareTo(Aluno o) {
        return this.matricula.compareTo(o.getMatricula());
    }
}
