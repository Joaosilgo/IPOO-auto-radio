import java.util.ArrayList;
/**
 * Representa o suporte digital onde é armazenada uma coleçao de Musicas.
 * Este possui uma capacidade em Mb(uma capacidade de musicas armazenadas)
 * Possui ainda um titulo, pode ser formatado e fechado.
 * 
 * 
 * @author (Hugo Pereira; João Gomes) 
 * @version (18-12-2015)
 */
public class CD
{
    
    private double capacidadeMaxima;//Mb
    
    private boolean formatado;//true or false formatado
    
    private boolean fechado;
    
    private boolean gravado;
    
    private String tituloCD; //nome a que se dá o CD
    
    private ArrayList<Musica> listaMusicas; //Array de musicas
    
  

    /**
     * COnstrutor para objetos da classe CD
     */
    public CD(int capacidadeMaxima)//construtor pede a capacidade Maxima em mb
    {
        if(capacidadeMaxima<=0)//validação Mb
        
        {  this.capacidadeMaxima=700;}
        else
        
        {  this.capacidadeMaxima=capacidadeMaxima;}
        
        this.formatado= false;//começa não formatado
        
        this.fechado= false;
        
        this.gravado= false;
        
        this.tituloCD="";//inicia-se sem titulo de cd
        
        
        
        
        
        
        
        
        
        
    }

   /**
     * formatar() - Este metodo modifica o atributo booleano formatado para true
     *              Mostra-o como se tivesse sido formatado.
     * 
     * 
     */
    public void formatar()//formatar
    {
        listaMusicas = new ArrayList<Musica>();
        fechado = false;
        formatado =true;//se formatado tiver fase passa par true e vice versa
        gravado=false;
    }
    /**
     * setTituloCD() - Metodo que serve para dar um titulo ao Cd, este tem de estar formatado
     * 
     * @param String tituloCD - nome do cd 
     */
    public void setTituloCD(String tituloCD)//colocar nome no cd têm de estar formatado
    {
        if(formatado==false)
        {
            this.tituloCD="";
            
        }
        else
        {
            this.tituloCD=tituloCD;
            
        }
        
        
        


    }
     /**
     * fechar()-Metodo que tem como objetivo fechar o cd de modo a não se poder regravar
     */
    public void fechar()
    {
        fechado = true;
    }
    /**
     *  getTituloCD()-Metodo que retorna o tilulo definido do Cd.
     *  
     *  @return tituloCD - retorna o tilulo definido do Cd.
     */
    public String getTituloCD()
    {
        return tituloCD;
    }
    /**
     * Capacidade()-Retorna a capacidade do cd. Este têm de se apresentar formatado para saber a capacidade
     *             Se estiver formatado mas não gravado é como se tivesse a capacidade Máxima
     *             Se estiver gravado e formatado da-nos a capacidade que ainda possui, se não retorn-nos a capacdade maxima do cd
     *        
     *@return capacidades
     * 
     */
    public double capacidade()
    {   
        double musicas =0;
        if(formatado==false)
         { System.out.println("Formatar primeiro");}
         else if(formatado == true && gravado == false)
         {
             return capacidadeMaxima;
            
             
         }else 
         {
             for (int i=0; i<listaMusicas.size();i++){
             musicas += listaMusicas.get(i).getTamanho();}
             musicas = musicas*0.001;
             musicas =capacidadeMaxima - musicas;
             return musicas ;
             
             
            }
            return capacidadeMaxima;
    }
     /**
     * getMusica()- Este metodo recebe o indice da musica e vai buscar essa musica á coleção 
     * @param int index 
     * @return a musica selecionada da coleção
     */
    public Musica getMusica(int index)
    {
        if(index>=0 &&index<listaMusicas.size())
        return listaMusicas.get(index);
        return null;
    }
    /**
     * isFormatado()- Retorna um valor boleano do atributo formatado.
     * @return formatado
     * 
     */
   
    public boolean isFormatado()
    {
        return formatado;
    }
     /**
     * gravar() Metodo que recebe uma musica, e se estiver fechado impossiblita de gravar,  se não grava e adiciona á coleção a musica recebida, e passa o atributo 
     * gravado a true.
     * 
     * @param Musica musica - objecto criado na classe Musica 
     */
    public void gravar(Musica musica)
    {
        if ( fechado == false){
        listaMusicas.add(musica);
        gravado = true;}
        else
        System.out.println("CD Fechado se quiser alterar as musicas formate");
    }
    /**
     * getLista()-metodo que retorna a listaMusicas em ArrayList.
     * @return listaMusicas
     */
    public ArrayList getLista()
    {
        return listaMusicas;
    }
    /**
     * toString()-Metodo que retorna as informações do cd com certas condições por exemplo se o cd não tiver sido gravado pede nos para o formatar e gravar . caso
     * contrario da-nos a informção de todas as faixas de musica que ira ser retirada da classe musica
     * 
     * @return informacao-informção de todas as faixas.
     */
    public String toString()
    {
        String informacao ="";
        if(gravado==false)//se estiver nao estiver formatado ou nao estiver gravado
        {informacao+="Têm de formatar e de gravar o cd";//txt erro
        }
        else{
        informacao+="FAIXAS/nNº de Faixas: "+listaMusicas.size();
        
        for(int i=0; i<listaMusicas.size(); i++)
        {
            informacao+="/n"+listaMusicas.get(i);}
        }
        return informacao;

    }
}


