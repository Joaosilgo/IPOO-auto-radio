
/**
 * Está classe tem como função adicionar as informações essenciais num canal.
 * Estas são a banda a frequência e o nome do canal que quisermos escolher. 
 * 
 * @author (Hugo Pereira e João Gomes) 
 * @version (21-12-2015)
 */
public class Canal
{
    
    private Banda banda ;
    private double frequencia;
    private String nomeCanal;
    

    /**
     * Constructor for objects of class CanalRadio
     */
    public Canal(double frequencia)
    {
        if(frequencia>=88 && frequencia <= 108)
        {
            this.frequencia=frequencia;
            this.banda = banda.FM;
        }
        if(frequencia>=520 && frequencia <= 1610)
        {
            this.frequencia=frequencia;
            this.banda = banda.AM;
        }
       
    }
    /**
     * setNomeCanal()- Este metodo dá um nome ao canal criado,
     * fazendo as validações necessárias.
     * @param nome tipo String , nome dado ao canal
     */

    public void setNomeCanal(String nome)
    {
        if (nome!= null)
        {
            this.nomeCanal=nome;
        }
    }
    /**
     * getBanda()-Representa a banda selecionada 
     * @return banda
     */
    public Banda getBanda()
    {
       return banda;
       
    }
    /**
     * getFrequencia()- Representa a frequencia selecionado
     * @return frequencia
     */
    public double getFrequencia()
    {
        return this.frequencia;
    }
    /**
     * setFrequencia()-Modifica a frequencia e assim um determinado tipo de banda
     * consequente
     * @param frequencia tipo double
     */
    public void setFrequencia(double frequencia)
    {
        if(frequencia>=88 && frequencia <= 108)
        {
            this.frequencia=frequencia;
            this.banda = Banda.FM;
        }
        if(frequencia>=520 && frequencia <= 1610)
        {
            this.frequencia=frequencia;
            this.banda = Banda.AM;
        }
    }
    /**
     * toString()-Este metodo retorna a informação do canal sendo este 
     * a frequência e a determinada banda para essa frequência.
     * @return informacao
     */
    
    public String toString()
    {
        String informacao ="";
        if(frequencia>=88 && frequencia <= 108)
        {
            informacao = "FM " + frequencia + "MHz";
        }
        if(frequencia>=520 && frequencia <= 1610)
        {
            informacao = "AM " + frequencia + "KHz";
        }
        return informacao;
    }
    
    
    
    
}
