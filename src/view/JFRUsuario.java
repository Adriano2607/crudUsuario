package view;

import DAO.DAOUsuario;
import Model.ModelUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class JFRUsuario {
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtSenha;
    private JTextField txtPapel;
    private JButton salvarButton;
    private JButton limparButton;
    private JPanel panel;
    private JButton verButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JFRUsuario");
        frame.setContentPane(new JFRUsuario().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public JFRUsuario() {

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String senha = txtSenha.getText();
                String papel = txtPapel.getText();

                ModelUsuario a = new ModelUsuario();
                a.setNome(nome);
                a.setEmail(email);
                a.setSenha(senha);
                a.setPapel(papel);
                try {
                    DAOUsuario.insert(a);
                    JOptionPane.showMessageDialog(panel,"Sucesso!");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText(null);
                txtEmail.setText(null);
                txtSenha.setText(null);
                txtPapel.setText(null);
            }
        });
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ver secondaryGUI = new Ver();
                secondaryGUI.setVisible(true);
            }
        });
    }
}
