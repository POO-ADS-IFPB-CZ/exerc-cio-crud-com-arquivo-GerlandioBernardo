package dao;

import model.Pessoa;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PessoaDao {
    private File arquivo;
    public PessoaDao(){
        arquivo = new File("Pessoas.bin");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Falha ao cria arquivo");
            }
        }
    }
    public Set<Pessoa> getPessoa(){
        if (arquivo.length() > 0){
            try {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Set<Pessoa> pessoas = (Set<Pessoa>) objectInputStream.readObject();
                return pessoas;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao ler arquivo");
            } catch (ClassNotFoundException e) {
                System.out.println("Falha ao ler arquivo");
            }
        }
        return  new HashSet<>();

    }
    public  boolean salvar(Pessoa pessoa){
        Set<Pessoa> pessoas = getPessoa();
        if (pessoas.add(pessoa)){
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(pessoas);
                return  true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return  false;
    }
    public boolean deletar(Pessoa pessoa){
        Set<Pessoa> pessoas = getPessoa();
        if (pessoas.remove(pessoa)){
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(pessoas);
                return  true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }

        }
        return  false;
    }
    public  boolean buscarPorEmail(String email){
        Set<Pessoa> pessoas = getPessoa();
        for (Pessoa pessoa : pessoas){
            if (pessoa.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public void listaPessoas(){
        Set<Pessoa> pessoas = getPessoa();
        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa);
        }
    }

}
