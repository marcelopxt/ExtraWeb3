package View;

import Controller.AlunoController;
import Model.Aluno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Edit extends JFrame implements ActionListener {
    public JTextField txtNome;
    public JTextField txtEmail;
    public JTextField txtMatricula;
    public AlunoController alunoController = new AlunoController();
    public Aluno aluno;

    public Edit(Aluno aluno) {
        super("Editar Aluno");
        this.aluno = aluno;
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
        txtNome = new JTextField(aluno.getNome(), 20);
        add(txtNome, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        add(new JLabel("Email:"), constr);

        constr.gridx = 1;
        constr.gridy = 1;
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1.0;
        txtEmail = new JTextField(aluno.getEmail(), 20);
        add(txtEmail, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        add(new JLabel("Matrícula:"), constr);

        constr.gridx = 1;
        constr.gridy = 2;
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1.0;
        txtMatricula = new JTextField(aluno.getMatricula(), 20);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        aluno.setNome(txtNome.getText());
        aluno.setEmail(txtEmail.getText());
        aluno.setMatricula(txtMatricula.getText());

        boolean sucesso = alunoController.update(aluno);
        if (sucesso) {
            JOptionPane.showMessageDialog(Edit.this, "Aluno editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            Index.verAlunos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(Edit.this, "Erro ao editar aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
