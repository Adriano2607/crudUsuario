package view;

import DAO.DAOUsuario;
import Model.ModelUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ver  extends  JFrame{
    private JTable table1;
    private JPanel panelVer;
    private JButton VErButton;

    public Ver() {
        VErButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("Nome");
                model.addColumn("Email");
                model.addColumn("Senha");
                model.addColumn("Papel");

                try {
                    for (ModelUsuario a : DAOUsuario.listarTudo()) {
                        model.addRow(new Object[]{
                                a.getId(), a.getNome(), a.getEmail(),a.getPapel()

                        });
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                table1.setModel(model);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ver");
        frame.setContentPane(new Ver().panelVer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
