
public class Curso
{
    int MAX = 100; // determina um limite de tamanho para os vetores
    
    String nome;
    String coordenador;
    Turma[] turmas = new Turma[MAX]; // cria um vetor de objetos instanciados a classe Turma
    String[] professores = new String[MAX];
    String[] disciplinas = new String[MAX];
    Aluno[] egressos = new Aluno[MAX]; // cria um vetor de objetos instanciados a classe Aluno
    Aluno[] alunos = new Aluno[MAX]; // cria um vetor de objetos instanciados a classe Aluno
    int numeroDeTurmas = 0, numeroDeProfessores = 0, numeroDeDisciplinas = 0, numeroDeEgressos = 0, numeroDeAlunos = 0; // contadores
    
    void alterarNome(String novoNome)
    {
        nome = novoNome;
    }
    
    void alterarCoordenador(String nomeCoordenador)
    {
        coordenador = nomeCoordenador;
    }
    
    void matricularAluno(Aluno novoAluno)
    {
        if(numeroDeAlunos < MAX) // verifica se o número total de alunos na turma já foi atingido
        {
            boolean achou = false;
            
            for(int aluno = 0; aluno < numeroDeAlunos; aluno++)
            {
                if(alunos[aluno] == novoAluno) // verifica se este objeto aluno já foi matriculado nesta turma
                {
                    System.out.println("Ação negada. O aluno já está matriculado neste curso!");
                    
                    achou = true;
                    
                    break;
                }
            }
            
            if(!achou) // se ele ainda não está matriculado
            {
                alunos[numeroDeAlunos] = novoAluno; // adiciona um objeto aluno que já está criado na interface
            
                numeroDeAlunos++;
            }
        }
        else
        {
            System.out.println("Ação negada. O número máximo de alunos no curso foi atingido!");
        }
    }
    
    void adicionarTurma(Turma novaTurma)
    {
        if(numeroDeTurmas < MAX) // verifica se o número máximo de turmas no curso já foi atingido
        {
            boolean achou = false;
            
            for(int turma = 0; turma < numeroDeTurmas; turma++)
            {
                if(turmas[turma] == novaTurma) // verifica se este objeto novaTurma já foi adicionado ao curso
                {
                    System.out.println("Ação negada. A turma já foi adicionada a este curso!");
                    
                    achou = true;
                    
                    break;
                }
            }
            
            if(!achou) // se não foi adicionado ainda
            {
                turmas[numeroDeTurmas] = novaTurma; // adiciona o objeto novaTurma no vetor de turmas
                numeroDeTurmas++;
                
                professores[numeroDeProfessores] = novaTurma.professor; // adiciona o professor dessa novaTurma ao vetor de professores
                numeroDeProfessores++;
                
                disciplinas[numeroDeDisciplinas] = novaTurma.disciplina; // adiciona a disciplina dessa novaTurma ao vetor de disciplinas
                numeroDeDisciplinas++;
                
                for(int aluno = 0; aluno < novaTurma.numeroDeAlunos; aluno++) // vai adicionando os alunos da novaTurma ao vetor de alunos
                {
                    matricularAluno(novaTurma.alunos[aluno]);
                    
                    if(novaTurma.alunos[aluno].status == 'e' || novaTurma.alunos[aluno].status == 'E')
                    {
                        egressos[numeroDeEgressos] = novaTurma.alunos[aluno];
                        
                        numeroDeEgressos++;
                    }
                }
            }
        }
        else
        {
            System.out.println("Ação negada. O número máximo de turmas para este curso foi atingido!");
        }
    }
    
    void listarAlunos()
    {
        if(numeroDeAlunos > 0) // se houver algum aluno matriculado no curso
        {
            System.out.println("==========================");
            System.out.println("Listando os alunos do curso <" + nome + ">:");
            
            for(int aluno = 0; aluno < numeroDeAlunos;aluno++)
            {
                System.out.println("==========================");
                System.out.println("Nome: " + alunos[aluno].nome);
                
                switch(alunos[aluno].status)
                {
                    case 'M':
                    case 'm':
                        System.out.println("Status: MATRICULADO");
                        
                        break;
                        
                    case 'E':
                    case 'e':
                        System.out.println("Status: EGRESSO");
                        
                        break;
                        
                    case 'C':
                    case 'c':
                        System.out.println("Status: CANCELADO");
                        
                        break;
                }
            }
        }
        else
        {
            System.out.println("Ação negada. Ainda não há alunos matriculados no curso!");
        }
    }
    
    void listarTurmas()
    {
        if(numeroDeTurmas > 0) // se houver alguma turma no curso
        {
            System.out.println("==========================");
            System.out.println("Listando as turmas do curso <" + nome + ">:");
            
            for(int turma = 0; turma < numeroDeTurmas; turma++)
            {
                System.out.println("==========================");
                System.out.println("Disciplina: " + turmas[turma].disciplina);
                System.out.println("Professor: " + turmas[turma].professor);
                System.out.println("Alunos: ");
                
                for(int aluno = 0; aluno < turmas[turma].numeroDeAlunos; aluno++)
                {
                    System.out.println(">> " + turmas[turma].alunos[aluno].nome);
                }
            }
        }
        else
        {
            System.out.println("Ação negada. Ainda não há turmas neste curso!");
        }
    }
    
    void listarProfessores()
    {
        if(numeroDeProfessores > 0) // se houver algum professor no curso
        {
            System.out.println("==========================");
            System.out.println("Listando os professores do curso <" + nome + ">:");
            
            for(int professor = 0; professor < numeroDeProfessores; professor++)
            {
                System.out.println("==========================");
                System.out.println("Professor: " + professores[professor]);
            }
        }
        else
        {
            System.out.println("Ação negada. Ainda não há professores neste curso!");
        }
    }
    
    void moverAlunoParaEgresso(Aluno alunoParaEgresso)
    {
        boolean achou = false;
        
        for(int aluno = 0; aluno < numeroDeAlunos; aluno++)
        {
            if(alunos[aluno] == alunoParaEgresso) // verifica se o aluno em questão já foi adicionado ao curso
            {
                achou = true;
                
                alunoParaEgresso.status = 'E';
                
                egressos[numeroDeEgressos] = alunoParaEgresso; // além de ser adicionado ao vetor que consta os alunos egressos
                numeroDeEgressos++;
                
                System.out.println("O status  do aluno <" + alunoParaEgresso.nome + "> foi alterado para EGRESSO com sucesso!");
                
                break;
            }
        }
        
        if(!achou)
        {
            System.out.println("Ação negada. O aluno informado não está matriculado no curso!");
        }
    }
    
    void excluirAluno(Aluno alunoParaExclusao)
    {
        boolean achou = false;
        
        for(int aluno = 0; aluno < numeroDeAlunos; aluno++)
        {
            if(alunos[aluno] == alunoParaExclusao) // procura pelo aluno em questão
            {
                achou = true;
                
                /*
                for(int realoca = aluno; realoca < numeroDeAlunos; realoca++) // reorganiza o vetor
                {
                    if(realoca == numeroDeAlunos - 1)
                    {
                        alunos[realoca] = null; // sendo que a última posição do vetor acaba recebendo um valor nulo
                    }
                    else
                    {
                        alunos[realoca] = alunos[realoca + 1]; // trazendo os objetos uma posição para trás
                    }
                }
                
                numeroDeAlunos--;
                */
               
                alunos[aluno].status = 'C'; // troca o status do aluno para CANCELADO
                
                System.out.println("O aluno <" + alunoParaExclusao.nome + "> foi excluído do curso <" + nome + "> com sucesso!");
                
                break;
            }
        }
        
        if(!achou)
        {
            System.out.println("Ação negada. O aluno informado não está matriculado no curso!");
        }
    }
}
