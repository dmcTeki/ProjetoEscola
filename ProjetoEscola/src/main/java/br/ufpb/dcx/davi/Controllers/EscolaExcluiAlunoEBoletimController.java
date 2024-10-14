package br.ufpb.dcx.davi.Controllers;

import br.ufpb.dcx.davi.Exceptions.AlunoNaoCadastradoException;
import br.ufpb.dcx.davi.SistemaEscola;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolaExcluiAlunoEBoletimController implements ActionListener {
    private SistemaEscola sistema;
    private JFrame janelaPrincipal;

    public EscolaExcluiAlunoEBoletimController(SistemaEscola sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String matricula = JOptionPane.showInputDialog(janelaPrincipal,"Digite a matrícula do Aluno:");
        try{
            if(sistema.RemoverAlunoEBoletim(matricula)) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Aluno excluído com sucesso.");
            }
        } catch (AlunoNaoCadastradoException ex){
            throw new RuntimeException(ex);
        }
    }
}
