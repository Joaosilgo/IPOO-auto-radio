
/**
 * A classe Musica vai ser usada sempre que for criada uma nova musica e vai conter 
 * o titulo da musica, o interprete, o nome do ficheiro onde se encontra e o seu tamanho em KB.
 *  
 * @author (Hugo Pereira, João Gomes) 
 * @version (21/12/15)
 */
public class Musica
{
    
    private String titulo;
    
    private String interprete;
    
    private String ficheiro;
    
    private double tamanho;
        

    /**
     *O construtor para cada nova música.
     */
    public Musica(String ficheiro, double tamanho)
    {
      if(ficheiro!= null)
      {  this.ficheiro=ficheiro; }
      else
      {  this.ficheiro="ficheiro desconhecido"; }
     
      if(tamanho<1)
      {
          this.tamanho=1;
        }else 
        this.tamanho=tamanho;
      
      
      
    }
    public Musica(String titulo, String interprete, String ficheiro, double tamanho)
    {
      if(ficheiro!= null)
      {  this.ficheiro=ficheiro; }
      else
      {  this.ficheiro="ficheiro desconhecido"; }
     
      if(tamanho<1)
      {
          this.tamanho=1;
        }else 
        this.tamanho=tamanho;
      
       if(titulo!= null)
      {  this.titulo=titulo; }
      
      if(interprete!= null)
      {  this.interprete=interprete; }
      
    }

    /**
     *Devolve o tamanho do ficheiro
     *@return tamanho que foi criado no construtor
     */
    public double getTamanho()
    {
        return tamanho;
    }
    /**
     *Devolve o titulo da musica
     *@return titulo adicionado para cada musica
     */
    public String getTitulo()
    {
        return titulo;
    }
    /**
     *Dar o titulo da musica
     *
     */
    public void setTitulo(String titulo)
    {
        if(titulo!= null)
      {  this.titulo=titulo; }
    }
    /**
     *Dar o interprete da musica
     */
    public void setInterprete(String interprete)
    {
        if(interprete!= null)
      {  this.interprete=interprete; }
    }
    /**
     *Devolve o interprete da musica
     *@return interprete 
     */
    public String getInterprete()
    {
        return interprete;
    }
    /**
     *Devolve o nome do ficheiro onde a musica esta guardada
     *@return ficheiro 
     */
    public String getFicheiro()
    {
        return ficheiro;
    }
    /**
     *Faz o metodo toString que passa toda a informaçao da musica para uma String para ser usado noutro lado
     *@return informaçao do ficheiro de musica.
     */
    public String toString()
    {
        return "Titulo: " + getTitulo() + "/nInterprete: " + getInterprete() + "/nTamanho:" +getTamanho()+"KB"; 
        
    }
}
