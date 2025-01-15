import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTrab{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SobreviventeTrab sobrevivente = null;
        RecursoTrab recurso = null;
        MissaoTrab missao = null;
        VaultTrab vault = new VaultTrab(new ArrayList<SobreviventeTrab>(), new ArrayList<RecursoTrab>(), new ArrayList<MissaoTrab>());

        while(true){
            System.out.println("\nMenu:\n");
            System.out.println("1. Cadastrar um sobrevivente");
            System.out.println("2. Adicionar uma habilidade a um sobrevivente");
            System.out.println("3. Remover uma habilidade de um sobrevivente");
            System.out.println("4. Adicionar um recurso ao vault");
            System.out.println("5. Consumir um recurso do vault");
            System.out.println("6. Registrar uma missão");
            System.out.println("7. Adicionar um sobrevivente a uma missão");
            System.out.println("8. Exibir os sobreviventes do vault");
            System.out.println("9. Exibir os recursos do vault");
            System.out.println("10. Exibir as missões realizadas");
            System.out.println("11. Exibir os sobreviventes de uma missão");
            System.out.println("12. Sair");
            System.out.print("\nSelecione uma opção: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); 

            switch(opc){
                case 1:{
                    int cont1 = 0;
                    int cont2 = 0;

                    System.out.print("\nDigite o nome do sobrevivente: ");
                    String nome = scanner.nextLine();
                    String id = "";
                    while(cont1 == 0){
                        cont2 = 0;

                        System.out.print("Agora, digite o ID de " + nome + ": ");
                        id = scanner.nextLine();
                        if(sobrevivente != null){
                            for(String id1 : sobrevivente.getSobreviventesId()){
                                if(id1.equals(id)){
                                    System.out.println("\nO ID " + id + " já está cadastrado. Por favor, tente novamente.\n");
                                    cont2++;
                                }
                            }
                            if(cont2 == 0){
                                cont1++;
                                cont2 = 0;
                            }
                        }
                        else{
                            cont1++;
                        }
                    }
                    System.out.print("Informe a idade de " + nome + ": ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Por fim, qual o status de " + nome + "? ");
                    String status = scanner.nextLine();

                    sobrevivente = new SobreviventeTrab(nome, id, idade, status);
                    vault.addSobrevivente(sobrevivente);
                    sobrevivente.addSobreviventeId(id);
                    break; 
                }
                case 2:{
                    if(sobrevivente != null){
                        sobrevivente.addHabilidade();
                    }
                    else{
                        System.out.println("\nNenhum sobrevivente cadastrado ainda.");
                    }
                    break;
                }
                case 3:{
                    if(sobrevivente != null){
                        sobrevivente.removeHabilidade();
                    }
                    else{
                        System.out.println("\nNenhum sobrevivente cadastrado ainda.");
                    }
                    break;
                }
                case 4:{
                    int quantidade = 0;
                    String nome = "";

                    
                    System.out.print("\nDigite o nome do recurso: ");
                    nome = scanner.nextLine();
                    while(quantidade < 1){
                        System.out.print("Agora, digite a quantidade de " + nome + ": ");
                        quantidade = scanner.nextInt();
                        scanner.nextLine();
                        if(quantidade < 1){
                            System.out.println("\nQuantidade inválida. Por favor, tente novamente.\n");
                        }
                    }
                    
                    recurso = new RecursoTrab(nome, quantidade);
                    vault.addRecurso(nome, quantidade);
                    break;
                }
                case 5:{
                    if(recurso != null){
                        int quantidade = 0;
                        String nome = "";
                        
                        System.out.print("\nDigite o nome do recurso: ");
                        nome = scanner.nextLine();
                        while(quantidade < 1){
                            System.out.print("Agora, digite a quantidade de " + nome + ": ");
                            quantidade = scanner.nextInt();
                            scanner.nextLine();
                            if(quantidade < 1){
                                System.out.println("\nQuantidade inválida. Por favor, tente novamente.\n");
                            }
                        }
                        recurso = new RecursoTrab(nome, quantidade);
                        vault.consumirRecurso(nome, quantidade);
                    }
                    else{
                        System.out.println("\nNenhum recurso adicionado ainda.");
                    }
                    break;
                }
                case 6:{
                    int cont = 0;
                    String nome = "";
                    String statusMissao = "";
                    
                    while(cont == 0){
                        System.out.print("\nDigite o nome da missão: ");
                        nome = scanner.nextLine();

                        boolean nomeExistente = false;
                        if(missao != null){
                            for(MissaoTrab missao1 : vault.getMissoes()){
                                if(missao1.getNome().equals(nome)){
                                    nomeExistente = true;
                                    System.out.println("\nJá existe uma missão com esse nome. Por favor, tente novamente.");
                                    break;
                                }
                            }
                        }
                        if(nomeExistente){
                            cont = 0; 
                        } 
                        else{
                            cont++;
                        }
                    }
                    System.out.print("Agora, digite o objetivo da missão: ");
                    String objetivo = scanner.nextLine();
                    System.out.print("Informe o local da missão: ");
                    String local = scanner.nextLine();
                    System.out.print("Digite o status da missão: ");
                    statusMissao = scanner.nextLine();

                    missao = new MissaoTrab(nome, objetivo, local, statusMissao, vault);

                    if(!statusMissao.equals("Em andamento") && !statusMissao.equals("em andamento")){
                        missao.listaRecursos();
                    }
                    vault.addMissao(missao);
                    break;
                }
                case 7:{ 
                    if(missao != null && sobrevivente != null){
                        int cont = 0;
                        
                        while(cont == 0){
                            System.out.print("\nDigite o nome da missão: ");
                            String nome = scanner.nextLine();
                            for(MissaoTrab missao2 : vault.getMissoes()){
                                if(missao2.getNome().equals(nome)){
                                    if(missao2.getSobreviventesMissao().size() != 0){
                                        if(missao2.getSobreviventesMissao().size() >= 5){
                                            cont = 3;
                                        }
                                        else if(!missao2.getStatusMissao().equals("Em andamento") && !missao2.getStatusMissao().equals("em andamento")){
                                            cont = 4;
                                        }
                                        else{
                                            cont = 2;
                                            missao = missao2;
                                        }
                                    }
                                    else{
                                        if(!missao2.getStatusMissao().equals("Em andamento") && !missao2.getStatusMissao().equals("em andamento")){
                                            System.out.println("\nEssa missão já foi finalizada.");
                                        }
                                        else{
                                            cont = 2;
                                            missao = missao2;
                                        }
                                    }
                                }
                            }
                            if(cont == 0){
                                System.out.println("\nMissão inexistente. Por favor, tente novamente.\n");
                            }
                            else if(cont == 3){
                                System.out.println("\nA missão já possui o limite de sobreviventes.\n");
                                break;
                            }
                            else if(cont == 4){
                                System.out.println("\nEssa missão já foi finalizada. Impossível adicionar sobreviventes a ela.\n");
                                break;
                            }
                        }
                        while(cont != 1){
                            cont = 0;

                            System.out.print("Digite o ID do sobrevivente: ");
                            String id = scanner.nextLine();
                            for(SobreviventeTrab sobrevivente3 : vault.getSobreviventes()){
                                if(sobrevivente3.getId().equals(id) && (!sobrevivente3.getStatus().equals("doente") && !sobrevivente3.getStatus().equals("morto") && !sobrevivente3.getStatus().equals("Doente") && !sobrevivente3.getStatus().equals("Morto"))){
                                    missao.addSobreviventeMissao(id, sobrevivente3);
                                    cont = 1;
                                    break;
                                }
                                else if(sobrevivente3.getId().equals(id) && (sobrevivente3.getStatus().equalsIgnoreCase("doente") || sobrevivente3.getStatus().equalsIgnoreCase("morto"))){
                                    cont = 2;
                                    System.out.println("\nSobrevivente doente ou morto. Impossível adicioná-lo.\n");
                                    break;
                                }
                            }
                            if(cont == 0){
                                System.out.println("\nSobrevivente inexistente. Não foi possível adicioná-lo.\n");
                            }
                        }
                    }
                    else{
                        if(missao == null){
                            System.out.println("\nNenhuma missão cadastrada ainda.");
                        }
                        else if(sobrevivente == null){
                            System.out.println("\nNenhum sobrevivente cadastrado ainda.");
                        }
                    }
                    break;
                }
                case 8:{
                    if(sobrevivente != null){
                        vault.mostraSobreviventes();
                    }
                    else{
                        System.out.println("\nNenhum sobrevivente cadastrado ainda.");
                    }
                    break;
                }
                case 9:{
                    vault.mostraRecursos();
                    break;
                }
                case 10:{
                    if(missao != null){
                        vault.mostrarMissoes();
                    }
                    else{
                        System.out.println("\nNenhuma missão cadastrada ainda.");
                    }
                    break;
                }
                case 11:{
                    int cont = 0;

                    while(cont == 0){
                        System.out.print("\nDigite o nome da missão: ");
                        String nome = scanner.nextLine();
                        for(MissaoTrab missao3 : vault.getMissoes()){
                            if(missao3.getNome().equals(nome) && missao3.getSobreviventesMissao().size() != 0){
                                missao3.mostrarSobreviventesMissao();
                                cont++;
                            }
                            else if(missao3.getNome().equals(nome) && missao3.getSobreviventesMissao().size() == 0){
                                System.out.println("\nA missão ainda não possui sobreviventes registrados.");
                                cont++;
                            }
                        }
                        if(cont == 0){
                            System.out.println("\nMissão inexistente. Por favor, tente novamente.");
                        }
                    }
                    break;
                }
                case 12:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("\nOpção inválida! Por favor, tente novamente.");
                }
            }
        }
    }
}