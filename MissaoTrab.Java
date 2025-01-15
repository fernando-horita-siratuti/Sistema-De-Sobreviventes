import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MissaoTrab{
    protected String nome, objetivo, local, statusMissao;
    protected List<SobreviventeTrab> sobreviventesMissao;
    protected List<RecursoTrab> recursosColetados;
    protected VaultTrab vault;

    public MissaoTrab(String nome, String objetivo, String local, String statusMissao, VaultTrab vault){
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.sobreviventesMissao = new ArrayList<SobreviventeTrab>();
        this.statusMissao = statusMissao;
        this.recursosColetados = new ArrayList<RecursoTrab>();
        this.vault = vault;
    }

    public String getNome(){
        return nome;
    }
    public String getObjetivo(){
        return objetivo;
    }
    public String getLocal(){
        return local;
    }
    public String getStatusMissao(){
        return statusMissao;
    }
    public List<SobreviventeTrab> getSobreviventesMissao(){
        return sobreviventesMissao;
    }
    public void getRecursosColetados(){
        Set<String> nomesExibidos = new HashSet<>();

        System.out.println("\nRecursos: \n");
        for(RecursoTrab recurso : this.recursosColetados){
            if(!nomesExibidos.contains(recurso.getNome())){
                nomesExibidos.add(recurso.getNome());
                System.out.println("- " + recurso.getNome() + ": " + recurso.getQnt());
            }
        }
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
    public void setLocal(String local){
        this.local = local;
    }
    public void setStatusMissao(String statusMissao){
        this.statusMissao = statusMissao;
    }
    public void setSobreviventesMissao(List<SobreviventeTrab> sobreviventesMissao){
        this.sobreviventesMissao = sobreviventesMissao;
    }
    public void setRecursosColetados(List<RecursoTrab> recursosColetados){
        this.recursosColetados = recursosColetados;
    }

    public void addRecursoMissao(RecursoTrab recurso){
        this.recursosColetados.add(recurso);
    }
    public void addSobreviventeMissao(String id, SobreviventeTrab sobrevivente){
        if(!this.sobreviventesMissao.contains(id)){
            this.sobreviventesMissao.add(sobrevivente);
            System.out.println("\nSobrevivente adicionado com sucesso!");
        }
        else if(this.sobreviventesMissao.contains(id)){
            System.out.println("\nEsse sobrevivente já foi adicionado antes.");
        }
        else{
            System.out.println("\nA missão já possui o limite de sobreviventes.");
        }
    }
    public void listaRecursos(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Digite o nome do recurso coletado durante a missão(caso deseja parar de adicionar recursos, digite 'fim'): ");
            String recursoNome = scanner.nextLine();
            if(recursoNome.equals("fim") || recursoNome.equals("Fim")){
                break;
            }
            else{
                System.out.print("Agora, informe a quantidade de " + recursoNome + " coletados: ");
                int qnt = scanner.nextInt();
                scanner.nextLine();
                RecursoTrab recurso = new RecursoTrab(recursoNome, qnt);
                vault.addRecurso(recursoNome, qnt);
                this.addRecursoMissao(recurso);
            }
        }
    }
    public void mostrarSobreviventesMissao(){
        int i = 1;

        for(SobreviventeTrab sobrevivente : this.sobreviventesMissao){
            System.out.println("\n- - - - - " + (i) + "° sobrevivente: - - - - - ");
            System.out.println("\n- Nome: " + sobrevivente.getNome());
            System.out.println("- ID: " + sobrevivente.getId());
            System.out.println("- Idade: " + sobrevivente.getIdade());
            System.out.println("- Status: " + sobrevivente.getStatus() + "\n\n");
            System.out.println("- Habilidades: \n");

            List<String> habilidades = sobrevivente.getHabilidades();
            for(String habilidade : habilidades){
                System.out.println("- " + habilidade);
            }
            i++;
        }
    }
}