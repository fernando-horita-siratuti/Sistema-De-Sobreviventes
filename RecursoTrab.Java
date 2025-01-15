import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursoTrab{
    protected String nome;
    protected int qnt;

    public RecursoTrab(String nome, int qnt){
        this.nome = nome;
        this.qnt = qnt;
    }

    public String getNome(){
        return nome;
    }
    public int getQnt(){
        return qnt;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setQnt(int qnt){
        this.qnt = qnt;
    }
}