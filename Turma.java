
public class Turma
{
    int MAX = 30; // número máximo de alunos para uma turma
    
    Aluno[] alunos = new Aluno[MAX]; // cria um vetor de objetos instanciados a classe Aluno
    int numeroDeAlunos = 0;
    String professor;
    String disciplina;
    
    void alterarProfessor(String nomeProfessor)
    {
        professor = nomeProfessor;
    }
    
    void alterarDisciplina(String nomeDisciplina)
    {
        disciplina = nomeDisciplina;
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
                    System.out.println("Ação negada. O aluno já está matriculado nesta turma!");
                    
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
            System.out.println("Ação negada. O número máximo de alunos na turma foi atingido!");
        }
    }
    
    void mostrarAlunosENotas()
    {
        if (numeroDeAlunos > 0) // se houver algum aluno
        {
            System.out.println("==========================");
            System.out.println("Listando os alunos e suas respectivas notas:");
            
            for(int aluno = 0; aluno < numeroDeAlunos; aluno++) // percorre o vetor de alunos, no qual cada posição é um objeto instanciado a classe Aluno
            {
                System.out.println("==========================");
                System.out.println("Nome: " + alunos[aluno].nome);
                
                for(int nota = 0; nota < alunos[aluno].numeroDeNotas; nota++) // percorre o vetor de notas do objeto em questão instanciado a classe Aluno
                {
                    System.out.println("Nota " + (nota + 1) + ": " + alunos[aluno].notas[nota]);
                }
            }
        }
        else
        {
            System.out.println("Ação negada. Não há alunos matriculados nesta turma ainda!");
        }
    }
}
