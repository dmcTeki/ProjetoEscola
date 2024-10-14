package br.ufpb.dcx.davi;

import br.ufpb.dcx.davi.Exceptions.AlunoJaCadastradoException;
import br.ufpb.dcx.davi.Exceptions.AlunoNaoCadastradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEscola implements SistemaEscolaInterface {

    private Map<String, Aluno> alunos;
    private List<Boletim> boletins;

    public  SistemaEscola() {
        this.alunos = new HashMap<>();
        this.boletins = new ArrayList<>();
    }


    @Override
    public boolean CadastraNovoAluno(String nome, String serie, String matricula) throws AlunoJaCadastradoException {
        if(alunos.containsKey(matricula)){
            throw new AlunoJaCadastradoException("Aluno já cadastrado.");
        }
        else{
            Aluno a = new Aluno(nome,serie,matricula);
            alunos.put(matricula, a);
            return true;
        }
    }

    @Override
    public Aluno PesquisarAluno(String matricula) throws AlunoNaoCadastradoException {
        for(Aluno a: alunos.values()){
            if(a.getMatricula().equals(matricula)){
                return alunos.get(matricula);
            }
        } throw new AlunoNaoCadastradoException("Este aluno não está cadastrado no sistema.");
    }

    @Override
    public String VerBoletim(String matricula) throws AlunoNaoCadastradoException {
        return null;
    }

    @Override
    public void CadastrarBoletim(double Nota1, double Nota2, double Nota3, String matriculaAluno) throws AlunoNaoCadastradoException {

    }

    public String EditarBoletim(String opcao, double Nota, String matriculaAluno) throws AlunoNaoCadastradoException{
        for(Boletim b: boletins) {
            if (b.getMatriculaAluno().equals(matriculaAluno)) {
                if (opcao.equals("1")) {
                    b.setNota1(Nota);
                }
                if (opcao.equals("2")) {
                    b.setNota2(Nota);
                }
                if (opcao.equals("3")) {
                    b.setNota3(Nota);
                }
            } return b.toString();
        } throw new AlunoNaoCadastradoException("Este aluno não está cadastrado no sistema.");
    }

    @Override
    public boolean VerificarMatricula(String matricula){
        if(alunos.containsKey(matricula)){
            return true;
        }
        return false;
    }

    @Override
    public boolean RemoverAlunoEBoletim(String matricula)throws AlunoNaoCadastradoException {
        if(alunos.containsKey(matricula)){
            for(Boletim b: boletins){
                if(b.getMatriculaAluno().equals(matricula)){
                    boletins.remove(b);
                }}
            alunos.remove(matricula);
            return true;
        }
        throw new AlunoNaoCadastradoException("Este aluno não está cadastrado ou já foi removido do sistema.");

    }
}
