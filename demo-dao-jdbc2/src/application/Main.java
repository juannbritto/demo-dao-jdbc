package application;

import model_dao.DaoFactory;
import model_dao.UsuariosDao;
import model_entities.Premium;
import model_entities.Usuarios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuariosDao usuariosDao = new DaoFactory().createUsuariosDao();

        int opcao;

        do {
            System.out.println("=== Bem-Vindo ao Administrador do WISE ===");
            System.out.println("1 - Para realizar cadastro do usuário");
            System.out.println("2- Para Alterar inforações do usuário");
            System.out.println("3- Para Deletar um usuário");
            System.out.println("4- Para consultar um usuário");
            System.out.println("5- Para sair");

            System.out.println("Escolha uma opcao");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite seu nome, senha, email e telefone");
                    String nome = sc.next();
                    String senha = sc.next();
                    String email = sc.next();
                    String telefone = sc.next();
                    Usuarios newUsuarios = new Usuarios(null, nome, senha, email, telefone, 5);
                    usuariosDao.insert(newUsuarios);
                    System.out.println("Inserted! New id = " + newUsuarios.getId());

                    // System.out.println("Cadastre Manualmente um usuário");
                    // Usuarios newUsuarios = new Usuarios(0, "Diogo", "123456", "diogo1934@gmail.com","99999-9999", 5);
                    // usuariosDao.insert(newUsuarios);
                    // System.out.println("Inserted! New id = " + newUsuarios.getId());
                    break;
                case 2:
                    System.out.println("Siga as instruções para alterar a senha do usuário");
                    System.out.println("Digite o id do usuário");
                    int idSenha = sc.nextInt();
                    Usuarios usuarios = usuariosDao.findById(idSenha);
                    System.out.println("Digite a nova senha");
                    String novaSenha = sc.next();
                    usuarios.setSenha(novaSenha);
                    usuariosDao.update(usuarios);
                    System.out.println("Mudança Completa!");
                    break;

                case 3:
                    System.out.println("Digite o id o usuário que deseja deletar");
                    int id = sc.nextInt();
                    usuariosDao.deleteById(id);
                    System.out.println("Usuário deletado com sucesso!");
                    break;

                case 4:
                    System.out.println("Digite o id do usuário que deseja consultar");
                    int idConsulta = sc.nextInt();
                    Usuarios Usuarios = usuariosDao.findById(idConsulta);
                    System.out.println(Usuarios);



                case 5:
                    System.exit(0);
                    break;
            }





        }while (opcao != 5);
        sc.close();
    }


    }


