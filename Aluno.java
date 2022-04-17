
/**
 * Escreva a descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Aluno
{
    String nome;
    DataDeNascimento dataNascimento = new DataDeNascimento();
    double[] notas;
    int numeroDeNotas;
    
    
    void alterarNome(String novoNome)
    {
        nome = novoNome;
    }
    
    void alterarDataDeNascimento(int diaNasc, int mesNasc, int anoNasc)
    {
        dataNascimento.dia = diaNasc;
        dataNascimento.mes = mesNasc;
        dataNascimento.ano = anoNasc;
    }
    
    void calcularMedia()
    {
        if(numeroDeNotas < 0)
        {
            double soma = 0;
            
            for(int i = 0; i < numeroDeNotas; i++)
            {
                soma += notas[i];
            }
            
            double media = soma / numeroDeNotas;
            
            System.out.println("A média do aluno " + nome + " é " + media);
        }
        else
        {
            System.out.println("Ação negada. Nenhuma nota foi atribuída a este aluno!");
        }
    }
    
    void calcularIdade()
    {
        
    }
}
