package br.ufpb.dcx.davi.Controllers;

import br.ufpb.dcx.davi.Exceptions.AlunoNaoCadastradoException;
import br.ufpb.dcx.davi.SistemaEscola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolaPesquisaAlunoController implements ActionListener {
    private SistemaEscola sistema;
    private JFrame janelaPrincipal;

    public EscolaPesquisaAlunoController(SistemaEscola sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String matricula = JOptionPane.showInputDialog(janelaPrincipal, "Digite a matrícula do aluno:");
        try{
            JOptionPane.showMessageDialog(janelaPrincipal, sistema.PesquisarAluno(matricula));
        }catch (AlunoNaoCadastradoException ex){
            throw new RuntimeException(ex);
        }

    }
}
