package br.ufpb.dcx.davi.Controllers;

import br.ufpb.dcx.davi.Exceptions.AlunoNaoCadastradoException;
import br.ufpb.dcx.davi.SistemaEscola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolaEditarBoletimController implements ActionListener {
    private SistemaEscola sistema;
    private JFrame janelaPrincipal;

    public EscolaEditarBoletimController(SistemaEscola sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String [] opcoes = {"1","2","3"};
        String matricula = JOptionPane.showInputDialog(janelaPrincipal, "Digite a matrícula do aluno:");
        if (sistema.VerificarMatricula(matricula)) {
            String opcao = (String) JOptionPane.showInputDialog(janelaPrincipal, "Escolha qual nota deseja editar:",null,JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[0]) ;
            double nota = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal, "Digite a nota:"));
            try{
                JOptionPane.showMessageDialog(janelaPrincipal, sistema.EditarBoletim(opcao, nota,matricula));
            }catch (AlunoNaoCadastradoException ex){
                throw new RuntimeException(ex);
            }
        }
    }
}