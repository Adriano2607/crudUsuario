package DAO;

import Infra.DataSource;
import Model.ModelUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuario {

    public static void insert(ModelUsuario af) throws SQLException {
        DataSource a = new DataSource();
        Connection con = a.getConnection();

        PreparedStatement ps = null;

        ps = con.prepareStatement("INSERT INTO tb_usuarios(nome,email,senha,papel) VALUES (?,?,?,?)");

        ps.setString(1, af.getNome());
        ps.setString(2, af.getEmail());
        ps.setString(3, af.getSenha());
        ps.setString(4, af.getPapel());

        ps.executeUpdate();

    }

    public static ModelUsuario getusuario(String usuarioNome) throws SQLException {
        DataSource dataSource = new DataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ModelUsuario cliente = null;


        ps = connection.prepareStatement("SELECT id, nome, email ,senha,papel FROM tb_usuarios WHERE nome = ?");
        ps.setString(1, usuarioNome);
        rs = ps.executeQuery();

        if (rs.next()) {

            cliente = new ModelUsuario();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setPapel(rs.getString("papel"));

        }

        return cliente;
    }

    public static ArrayList<ModelUsuario> listarTudo() throws SQLException {
        DataSource dataSource = new DataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
         ArrayList<ModelUsuario> cliente = new ArrayList<ModelUsuario>();


        ps = connection.prepareStatement("SELECT id, nome, email ,senha,papel FROM tb_usuarios ");
        rs = ps.executeQuery();

        if (rs.next()) {

                ModelUsuario a = new ModelUsuario();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setSenha(rs.getString("senha"));
                a.setPapel(rs.getString("papel"));

                    cliente.add(a);
        }

        return cliente;
    }
}
