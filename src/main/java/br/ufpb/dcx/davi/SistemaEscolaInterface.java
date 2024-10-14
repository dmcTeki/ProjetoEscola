package br.ufpb.dcx.davi;

import br.ufpb.dcx.davi.Exceptions.AlunoJaCadastradoException;
import br.ufpb.dcx.davi.Exceptions.AlunoNaoCadastradoException;
public interface SistemaEscolaInterface {


    public void CadastrarBoletim(double Nota1, double Nota2, double Nota3, String matriculaAluno) throws AlunoNaoCadastradoException;
    public String VerBoletim(String matricula) throws AlunoNaoCadastradoException;
    public String EditarBoletim(String opcao, double Nota, String matriculaAluno) throws AlunoNaoCadastradoException;
    public boolean VerificarMatricula(String matricula);
    public boolean CadastraNovoAluno(String nome, String serie, String matricula) throws AlunoJaCadastradoException;
    public Aluno PesquisarAluno(String matricula) throws AlunoNaoCadastradoException, AlunoJaCadastradoException;
    public boolean RemoverAlunoEBoletim(String Matricula)throws AlunoNaoCadastradoException;
}
