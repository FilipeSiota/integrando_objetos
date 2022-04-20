
public class Aluno
{
    int MAX = 5; // número máximo de notas
    
    String nome;
    char status = 'M';
    DataDeNascimento dataNascimento = new DataDeNascimento();
    double[] notas = new double[MAX];
    int numeroDeNotas = 0;
    
    void alterarNome(String novoNome)
    {
        nome = novoNome;
    }
    
    void alterarStatus(char novoStatus)
    {
        status = novoStatus;
    }
    
    void alterarDataDeNascimento(int diaNascimento, int mesNascimento, int anoNascimento)
    {
        dataNascimento.dia = diaNascimento;
        dataNascimento.mes = mesNascimento;
        dataNascimento.ano = anoNascimento;
    }
    
    void adicionarNota(double novaNota)
    {
        if(numeroDeNotas < MAX) // verifica se o número máximo de notas já foi atingido
        {
            notas[numeroDeNotas] = novaNota; // adiciona a nota ao vetor notas
            
            numeroDeNotas++;
            
            System.out.println("Nota adicionada com sucesso!");
        }
        else
        {
            System.out.println("Ação negada. O número máximo de notas para este aluno foi atingido!");
        }
    }
    
    void calcularMediaAritmetica()
    {
        if(numeroDeNotas > 0) // se houver alguma nota
        {
            double soma = 0;
            
            for(int i = 0; i < numeroDeNotas; i++)
            {
                soma += notas[i]; // soma todas as notas
            }
            
            double media = soma / numeroDeNotas; // e divide pelo número total de notas
            
            System.out.println("A média do aluno <" + nome + "> é " + media);
        }
        else
        {
            System.out.println("Ação negada. Nenhuma nota foi atribuída a este aluno!");
        }
    }
    
    void calcularIdade(int diaAtual, int mesAtual, int anoAtual)
    {
        if(dataNascimento.ano > 0) // se houver data de nascimento cadastrada para o aluno
        {
            int idade;
            int diasDataAtual = mesAtual * 30 + diaAtual; // transforma os meses e dias da data atual em dias
            int diasDataNascimento = dataNascimento.mes * 30 + dataNascimento.dia; // transforma os meses e dias da data de nascimento em dias
            
            if(diasDataAtual >= diasDataNascimento) // se a data atual em dias for maior ou igual a data de nascimento em dias, significa que o aluno já fez aniversário
            {
                idade = anoAtual - dataNascimento.ano;
            }
            else
            {
                idade = anoAtual - dataNascimento.ano - 1; // senão, ainda não fez aniversário no ano atual
            }
            
            System.out.println("O aluno <" + nome + "> tem " + idade + " anos.");
        }
        else
        {
            System.out.println("Ação negada. A data de nascimento do aluno ainda não foi informada!");
        }
    }
}
