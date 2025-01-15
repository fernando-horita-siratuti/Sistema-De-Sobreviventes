import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SobreviventeTrab extends PessoaTrab{
    protected String status;
    protected List<String> habilidades;
    protected List<String> sobreviventesId;

    public SobreviventeTrab(String nome, String id, int idade, String status){
        super(nome, id, idade);
        this.status = status;
        this.habilidades = new ArrayList<String>();
        this.sobreviventesId = new ArrayList<String>();
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
    public List<String> getHabilidades(){
        return habilidades;
    }
    public List<String> getSobreviventesId(){
        return sobreviventesId;
    }
    public String getStatus(){
        return status;
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
    public void setHabilidades(List<String> habilidades){
        this.habilidades = habilidades;
    }
    public void setSobreviventesId(List<String> sobreviventesId){
        this.sobreviventesId = sobreviventesId;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public void addSobreviventeId(String id){
        this.sobreviventesId.add(id);
    }
    public void addHabilidade(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nInforme o ID do sobrevivente: ");
        String id = scanner.nextLine();
        for(int i = 0; i < this.sobreviventesId.size(); i++){
            if(this.sobreviventesId.get(i).equals(id)){
                if(this.habilidades.size() == 3){
                    System.out.println("\n" + nome + " já possui a quantidade máxima de habilidades cadastradas.");
                    return;
                }
                else{
                    System.out.print("\nQual a habilidade de " + nome + " a ser adicionada? ");
                    String habilidade = scanner.nextLine();
                    this.habilidades.add(habilidade);
                    System.out.println(habilidade + " foi adicionada com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Esse ID não existe. Por favor, tente novamente.");
    }
    public void removeHabilidade(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInforme o ID do sobrevivente: ");
        String id = scanner.nextLine();
        for(int i = 0; i < this.sobreviventesId.size(); i++){
            if(this.sobreviventesId.get(i).equals(id) && this.habilidades.size() > 0){
                System.out.print("Qual a habilidade de " + nome + " a ser removida? ");
                String habilidade = scanner.nextLine();
                for(int j = 0; j < this.habilidades.size(); j++){
                    if(this.habilidades.get(j).equals(habilidade)){
                        this.habilidades.remove(j);
                        System.out.println(habilidade + " foi removida com sucesso!");
                        return;
                    }
                }
                System.out.println("Tal habilidade não existe.");
                return;
            }
            else if(this.sobreviventesId.get(i).equals(id) && this.habilidades.size() <= 0){
                System.out.println(nome + " não possui habilidades cadastradas.");
            }
        }
        System.out.println(nome + " não existe. Por favor, tente novamente.");
    }
}