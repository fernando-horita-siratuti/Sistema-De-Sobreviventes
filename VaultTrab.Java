import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class VaultTrab{
    protected List<SobreviventeTrab> sobreviventes;
    protected List<RecursoTrab> recursos;
    protected List<MissaoTrab> missoes;
    protected RecursoTrab recurso;
    protected MissaoTrab missao; 

    public VaultTrab(List<SobreviventeTrab> sobreviventes, List<RecursoTrab> recursos, List<MissaoTrab> missoes){
        this.sobreviventes = new ArrayList<SobreviventeTrab>();
        this.recursos = new ArrayList<RecursoTrab>();
        this.missoes = new ArrayList<MissaoTrab>();
    }

    public List<SobreviventeTrab> getSobreviventes(){
        return sobreviventes;
    }
    public List<RecursoTrab> getRecursos(){
        return recursos;
    }
    public List<MissaoTrab> getMissoes(){
        return missoes;
    }

    public void setSobreviventes(List<SobreviventeTrab> sobreviventes){
        this.sobreviventes = sobreviventes;
    }
    public void setRecursos(List<RecursoTrab> recursos){
        this.recursos = recursos;
    }
    public void setMissoes(List<MissaoTrab> missoes){
        this.missoes = missoes;
    }

    public void addSobrevivente(SobreviventeTrab sobrevivente){
        this.sobreviventes.add(sobrevivente);
        System.out.println("\nSobrevivente adicionado com sucesso!\n");
    }
    public void addRecurso(String nomeRecurso, int quantidade){
        boolean recursoEncontrado = false;

        for(RecursoTrab recurso : this.recursos){
            if(recurso.getNome().equals(nomeRecurso)){
                recurso.setQnt(recurso.getQnt() + quantidade);
                recursoEncontrado = true;
                System.out.println("\nRecurso adicionado com sucesso!\n");
                break;
            }
        }
        if(!recursoEncontrado){
            this.recursos.add(new RecursoTrab(nomeRecurso, quantidade));
            System.out.println("\nRecurso adicionado com sucesso!\n");
        }
    }
    public void consumirRecurso(String nomeRecurso, int quantidade){
        boolean recursoEncontrado = false;

        for(RecursoTrab recurso : this.recursos){
            if(recurso.getNome().equals(nomeRecurso)){
                if(recurso.getQnt() - quantidade < 0){
                    System.out.println("\nQuantidade maior que a disponível no vault. Por favor, insira uma quantidade válida.");
                    recursoEncontrado = true;
                    break;
                }
                else if(recurso.getQnt() - quantidade == 0){
                    this.recursos.remove(recurso);
                    recursoEncontrado = true;
                    System.out.println("\nRecurso consumido com sucesso! No entanto, todos(as) " + nomeRecurso + "s foram consumidos.");
                    break;
                }
                else{
                    recurso.setQnt(recurso.getQnt() - quantidade);
                    recursoEncontrado = true;
                    System.out.println("\nRecurso consumido com sucesso!");
                    break;
                }
            }
        }
        if(!recursoEncontrado){
            System.out.println("\nRecurso inexstente. Por favor, insira um recurso válido.");
        }
    }
    public void addMissao(MissaoTrab missao){
        this.missoes.add(missao);
        System.out.println("\nMissão adicionada com sucesso!");
    }
    public void mostrarMissoes(){
        for(int i = 0; i < this.missoes.size(); i++){
            MissaoTrab missaoAtual = this.missoes.get(i);
            if(!missaoAtual.getStatusMissao().equals("Em andamento") && !missaoAtual.getStatusMissao().equals("em andamento")){
                System.out.println("\n- - - - - " + (i + 1) + "° missão: - - - - - ");
                System.out.println("\n- Nome da missão: " + missaoAtual.getNome());
                System.out.println("- Objetivo da missão: " + missaoAtual.getObjetivo());
                System.out.println("- Local da missão: " + missaoAtual.getLocal());
                System.out.println("- Status da missão: " + missaoAtual.getStatusMissao());
                System.out.println("- Recursos coletados na missão: ");
                missaoAtual.getRecursosColetados();
                System.out.print("\n");
            }
            else{
                System.out.println("\n- - - - - " + (i + 1) + "° missão: - - - - - ");
                System.out.println("\n- Nome da missão: " + missaoAtual.getNome());
                System.out.println("- Objetivo da missão: " + missaoAtual.getObjetivo());
                System.out.println("- Local da missão: " + missaoAtual.getLocal());
                System.out.println("- Status da missão: " + missaoAtual.getStatusMissao());
            }
        }
    }
    public void mostraSobreviventes(){
        for(int i = 0; i < this.sobreviventes.size(); i++){
            System.out.println("\n- - - - - " + (i + 1) + "° sobrevivente: - - - - - ");
            System.out.println("\n- Nome: " + this.sobreviventes.get(i).getNome());
            System.out.println("- ID: " + this.sobreviventes.get(i).getId());
            System.out.println("- Idade: " + this.sobreviventes.get(i).getIdade());
            System.out.println("- Status: " + this.sobreviventes.get(i).getStatus() + "\n\n");
            System.out.println("- Habilidades: \n");

            List<String> habilidades = this.sobreviventes.get(i).getHabilidades();
            for(String habilidade : habilidades){
                System.out.println("- " + habilidade);
            }
        }
    }
    public void mostraRecursos(){
        Set<String> nomesExibidos = new HashSet<>();

        System.out.println("\nRecursos: \n");
        for(RecursoTrab recurso : this.recursos){
            if(!nomesExibidos.contains(recurso.getNome())){
                nomesExibidos.add(recurso.getNome());
                System.out.println("- " + recurso.getNome() + ": " + recurso.getQnt());
            }
        }
    }
}