package view;

import dao.PessoaDao;
import model.Pessoa;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Informe a opção:");
            System.out.println(" 1 - Salvar\n 2 - Deletar\n 3 - Imprimir\n 0 - Sair ");
            opcao = scanner.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Sair");break;
                case 1: salvar(pessoaDao);break;
                case 2: deletar(pessoaDao);break;
                case 3: pessoaDao.listaPessoas();break;
                default:
                    System.out.println("Opção Invalida!");
            }

        }while (opcao != 0);

    }
    public  static void salvar(PessoaDao pessoaDao){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o email: ");
        String email = scanner.nextLine();
        pessoaDao.salvar(new Pessoa(nome, email));

    }
    public static  void deletar(PessoaDao pessoaDao){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o email: ");
        String email = scanner.nextLine();
        if (pessoaDao.buscarPorEmail(email)){
            pessoaDao.deletar(new Pessoa(nome, email));
        }
        else {
            System.out.println("Erro ao delatar! verifique os " +
                    "dados da pessoa");
        }

    }
}