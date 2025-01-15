public class PessoaTrab{
    protected String nome, id;
    protected int idade;

    public PessoaTrab(String nome, String id, int idade){
        this.nome = nome;
        this.id = id;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }
    public String getId(){
        return id;
    }
    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}