package br.ufpb.dcx.davi.gui;

import br.ufpb.dcx.davi.Controllers.EscolaCadAlunoController;
import br.ufpb.dcx.davi.Controllers.EscolaEditarBoletimController;
import br.ufpb.dcx.davi.Controllers.EscolaPesquisaAlunoController;
import br.ufpb.dcx.davi.SistemaEscola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EscolaGUI extends JFrame {
    JLabel linha1, linha2;
    SistemaEscola sistema = new SistemaEscola();
    JMenuBar barraDeMenu = new JMenuBar();

    public EscolaGUI() {
        setTitle("Sistema Escola");
        setSize(800, 900);
        setLocation(150, 150);
        setResizable(true);
        setBackground(Color.LIGHT_GRAY);
        linha1 = new JLabel("Escola", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(new JLabel());
        JMenu menuBoletim = new JMenu("Boletins");
        JMenu menuAluno = new JMenu("Alunos");
        JMenu menuExcluir = new JMenu("Excluir");

        JMenuItem opcaoCadastrarBoletim = new JMenuItem("Cadastrar Boletim");
        menuBoletim.add(opcaoCadastrarBoletim);
        JMenuItem opcaoBuscarBoletim = new JMenuItem("Buscar Boletim");
        menuBoletim.add(opcaoBuscarBoletim);
        JMenuItem opcaoEditarBoletim = new JMenuItem("Editar Boletim");
        menuBoletim.add(opcaoEditarBoletim);
        JMenuItem opcaoCadastrarAluno = new JMenuItem("Cadastrar Aluno");
        menuAluno.add(opcaoCadastrarAluno);
        JMenuItem opcaoPesquisarAluno = new JMenuItem("Pesquisar Aluno");
        menuAluno.add(opcaoPesquisarAluno);
        JMenuItem opcaoExcluir = new JMenuItem("Excluir Aluno e Boletim");
        menuExcluir.add(opcaoExcluir);

        opcaoCadastrarAluno.addActionListener(new EscolaCadAlunoController(sistema, this));
        opcaoPesquisarAluno.addActionListener(new EscolaPesquisaAlunoController(sistema, this));
        opcaoEditarBoletim.addActionListener(new EscolaEditarBoletimController(sistema, this));

        barraDeMenu.add(menuBoletim);
        barraDeMenu.add(menuAluno);
        barraDeMenu.add(menuExcluir);
        setJMenuBar(barraDeMenu);


    }
    public static void main(String[] args) {
        SistemaEscola sistema = new SistemaEscola();
        JFrame janela = new EscolaGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanela = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanela);
    }
}
