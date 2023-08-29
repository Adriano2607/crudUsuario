package tst;

import DAO.DAOUsuario;
import Model.ModelUsuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static DAO.DAOUsuario.getusuario;

public class tstUsuario {


    public static void main(String[] args) throws SQLException {

        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o nome que deseja procurar ");

        String nome = ler.next();
        ModelUsuario clienteModel = DAOUsuario.getusuario(nome);

            if(clienteModel != null){
                System.out.println(clienteModel.getNome());
                System.out.println(clienteModel.getEmail());
                System.out.println(clienteModel.getSenha());

            }else{
                System.err.println("Usuario Nao Encontrado");
            }




    }

    public static void inserir() throws SQLException {
        Scanner ler = new Scanner(System.in);
        ModelUsuario a = new ModelUsuario();

        System.out.println("Nome: ");
        a.setNome(ler.next());

        System.out.println("Email: ");
        a.setEmail(ler.next());

        System.out.println("Senha: ");
        a.setSenha(ler.next());

        System.out.println("Papel: ");
        a.setPapel(ler.next());

        DAOUsuario f = new DAOUsuario();

        f.insert(a);

    }





}
