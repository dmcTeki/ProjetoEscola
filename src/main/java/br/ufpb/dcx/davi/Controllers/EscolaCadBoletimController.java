package br.ufpb.dcx.davi.Controllers;

import br.ufpb.dcx.davi.SistemaEscola;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolaCadBoletimController implements ActionListener {
    private SistemaEscola sistema;
    private JFrame janelaPrincipal;

    public EscolaCadBoletimController(SistemaEscola sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
