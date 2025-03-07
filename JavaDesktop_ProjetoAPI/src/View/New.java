package View;

import Controller.AlunoController;
import Model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New extends JFrame implements ActionListener {
    public JTextField txtNome;
    public JTextField txtEmail;
    public JTextField txtMatricula;
    public AlunoController alunoController = new AlunoController();

    public New() {
        super("Novo Aluno");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);

        constr.gridx = 0;
        constr.gridy = 0;
        add(new JLabel("Nome:"), constr);

        constr.gridx = 1;
        constr.gridy = 0;
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1.0;
        txtNome = new JTextField(20);
        add(txtNome, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        add(new JLabel("Email:"), constr);

        constr.gridx = 1;
        constr.gridy = 1;
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1.0;
        txtEmail = new JTextField(20);
        add(txtEmail, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        add(new JLabel("Matrícula:"), constr);

        constr.gridx = 1;
        constr.gridy = 2;
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1.0;
        txtMatricula = new JTextField(20);
        add(txtMatricula, constr);

        constr.gridx = 0;
        constr.gridy = 3;
        constr.gridwidth = 2;
        constr.fill = GridBagConstraints.NONE;
        constr.anchor = GridBagConstraints.CENTER;
        JButton btnSalvar = new JButton("Salvar");
        add(btnSalvar, constr);

        btnSalvar.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Aluno aluno = new Aluno(0, txtNome.getText(), txtEmail.getText(), txtMatricula.getText());
        boolean sucesso = alunoController.store(aluno);
        if (sucesso) {
            JOptionPane.showMessageDialog(New.this, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            Index.verAlunos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(New.this, "Erro ao cadastrar aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}