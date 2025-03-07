package View;

import Controller.AlunoController;
import Model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Index extends JFrame implements ActionListener {
    public static AlunoController alunoController = new AlunoController();
    public JButton btnCarregar = new JButton("Carregar Alunos");
    public JButton btnEditar = new JButton("Editar Aluno");
    public JButton btnDeletar = new JButton("Deletar Aluno");
    public JButton btnNovo = new JButton("Novo Aluno");
    public static JTable tabela = new JTable();
    public JScrollPane scrollPane = new JScrollPane(tabela);
    public JPanel buttonPanel = new JPanel();

    public Index() {
        super("CRUD Alunos");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnDeletar);
        buttonPanel.add(btnNovo);
        add(buttonPanel, BorderLayout.SOUTH);

        btnEditar.addActionListener(this);
        btnDeletar.addActionListener(this);
        btnNovo.addActionListener(this);

        verAlunos();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnCarregar)
           verAlunos();
        else if(e.getSource() == btnDeletar)
            deletar();
        else if (e.getSource() == btnEditar)
            editar();
        else if(e.getSource() == btnNovo)
            newAluno();
    }

     public static void verAlunos() {
        try {
            ArrayList<Aluno> alunos = alunoController.index();
            String[] colunas = {"ID", "Nome", "Email", "Matrícula"};
            Object[][] dados = new Object[alunos.size()][4];

            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                dados[i][0] = aluno.getId();
                dados[i][1] = aluno.getNome();
                dados[i][2] = aluno.getEmail();
                dados[i][3] = aluno.getMatricula();
            }

            DefaultTableModel model = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            tabela.setModel(model);
        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos. Verifique também, se a API está rodando.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(ABORT);
        }
    }

    public void editar() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tabela.getValueAt(selectedRow, 0);
            String nome = (String) tabela.getValueAt(selectedRow, 1);
            String email = (String) tabela.getValueAt(selectedRow, 2);
            String matricula = (String) tabela.getValueAt(selectedRow, 3);

            Aluno aluno = new Aluno(id, nome, email, matricula);
            new Edit(aluno);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deletar() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tabela.getValueAt(selectedRow, 0);
            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar este aluno?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                boolean sucesso = alunoController.destroy(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    verAlunos();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao deletar aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para deletar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void newAluno() {
        new New();
    }
}