package br.ufpb.dcx.davi.Controllers;

import br.ufpb.dcx.davi.Exceptions.AlunoJaCadastradoException;
import br.ufpb.dcx.davi.SistemaEscola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolaCadAlunoController implements ActionListener {
    private SistemaEscola sistema;
    private JFrame janelaPrincipal;

    public EscolaCadAlunoController(SistemaEscola sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String matricula = JOptionPane.showInputDialog(janelaPrincipal, "Digite a matrícula: ");
        if (!sistema.VerificarMatricula(matricula)) {
            String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite a nome do aluno: ");
            String serie = JOptionPane.showInputDialog(janelaPrincipal, "Digite a serie do aluno: ");
            try {
                if (sistema.CadastraNovoAluno(nome, serie, matricula)) {
                    JOptionPane.showMessageDialog(janelaPrincipal, "Aluno cadastrado com sucesso.");
                }
            } catch (AlunoJaCadastradoException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}