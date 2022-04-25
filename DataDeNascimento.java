
public class DataDeNascimento
{
    private int dia, mes, ano;
    
    public void setDia(int dia) // altera o dia da data de nascimento
    {
        if(dia > 0 && dia < 32) // verifica se o dia é válido
        {
            this.dia = dia;
        }
        else
        {
            System.out.println("O valor inserido no campo DIA é inválido! Tente um número de 1 a 31.");
        }
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public void setMes(int mes) // altera o mês da data de nascimento
    {
        if(mes > 0 && mes < 13) // verifica se o mês é válido
        {
            this.mes = mes;
        }
        else
        {
            System.out.println("O valor inserido no campo MÊS é inválido! Tente um número de 1 a 12.");
        }
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public void setAno(int ano) // altera o ano da data de nascimento
    {
        if(ano > 0) // verifica se o ano é válido
        {
            this.ano = ano;
        }
        else
        {
            System.out.println("O valor inserido no campo ANO é inválido! Tente um número maior que 0.");
        }
    }
    
    public int getAno()
    {
        return ano;
    }
}
