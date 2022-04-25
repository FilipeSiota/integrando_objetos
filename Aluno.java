
public class Aluno
{
    private int MAX = 5; // número máximo de notas
    
    private String nome;
    private char status = 'M';
    private DataDeNascimento dataNascimento = new DataDeNascimento();
    private int idade;
    private double[] notas = new double[MAX];
    private int numeroDeNotas = 0;
    
    public Aluno(String nome) // método construtor
    {
        setNome(nome);
    }
    
    public void setNome(String nome) // altera o nome do aluno
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setStatus(char status) // altera o status do aluno
    {
        if(status == 'M' || status == 'm' ||
           status == 'E' || status == 'e' ||
           status == 'C' || status == 'c') // verifica se o status inserido é válido
       {
           this.status = status;
       }
       else
       {
           System.out.println("O valor inserido para STATUS é inválido! Tente colocar 'M' (MATRICULADO) ou 'E' (EGRESSO) ou 'C' (CANCELADO).");
       }
    }
    
    public char getStatus()
    {
        return status;
    }
    
    public void setDataDeNascimento(int dia, int mes, int ano) // altera a data de nascimento do aluno
    {
        dataNascimento.setDia(dia);
        dataNascimento.setMes(mes);
        dataNascimento.setAno(ano);
    }
    
    public void adicionarNota(double nota)
    {
        if(numeroDeNotas < MAX) // verifica se o número máximo de notas já foi atingido
        {
            notas[numeroDeNotas] = nota; // adiciona a nota ao vetor notas
            
            numeroDeNotas++;
            
            System.out.println("Nota adicionada com sucesso!");
        }
        else
        {
            System.out.println("Ação negada. O número máximo de notas para este aluno foi atingido!");
        }
    }
    
    public int getNumeroDeNotas()
    {
        return numeroDeNotas;
    }
    
    public double getNota(int posicao)
    {
        return notas[posicao];
    }
    
    public void calcularMediaAritmetica()
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
    
    public void calcularIdade(int diaAtual, int mesAtual, int anoAtual)
    {
        if(dataNascimento.getAno() > 0) // se houver data de nascimento cadastrada para o aluno
        {
            int diasDataAtual = mesAtual * 30 + diaAtual; // transforma os meses e dias da data atual em dias
            int diasDataNascimento = dataNascimento.getMes() * 30 + dataNascimento.getAno(); // transforma os meses e dias da data de nascimento em dias
            
            if(diasDataAtual >= diasDataNascimento) // se a data atual em dias for maior ou igual a data de nascimento em dias, significa que o aluno já fez aniversário
            {
                idade = anoAtual - dataNascimento.getAno();
            }
            else
            {
                idade = anoAtual - dataNascimento.getAno() - 1; // senão, ainda não fez aniversário no ano atual
            }
            
            System.out.println("O aluno <" + nome + "> tem " + idade + " anos.");
        }
        else
        {
            System.out.println("Ação negada. A data de nascimento do aluno ainda não foi informada!");
        }
    }
}
