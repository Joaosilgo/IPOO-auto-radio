import java.util.Iterator;
import java.util.Random;

/**
 * Está classe tem como função inserir e ejetar os cd´s,
 * possui também dois tipos de reprodução dos mesmos, 
 * e poderá navegar entre as coleções de ficheiros em que o cd possui.
 * 
 * @author (João Gomes e Hugo Pereira) 
 * @version (21-12-2015)
 */
public class LeitorDeCD
{
    
    private Musica musica;
        
    private boolean aleatorio;
    
    private CD cdInserido;
    
    

    /**
     * COnstrutor para objetos da classe LeitorDeCD
     */
    public LeitorDeCD()
    {
        aleatorio = false;
        musica =null;
    }

   /**
     * inserirCd()-Este metodo recebe um cd em que faz a sua validação
     * 
     * @param  cd Objeto da classe CD
     *  
     */
    public void inserirCD(CD cd)
    {
        if(cd != null)
        cdInserido = cd;
    }
    /**
     * ejetarCD()-Este metodo verifica se existe um cd inserido, se houver este faz uma copia do mesmo e retorna-a
     * passando o cdInserido a null
     * @return copia
     */
    public CD ejetarCD()
    {
        if(cdInserido==null)
        {
            System.out.println("Nao existe CD inserido");
        }else{
        CD copia = cdInserido;
        cdInserido = null;
        return copia;
        }
        return null;
    }
    /**
     * setAleatorio()- Este metodo muda o estado do atributo aleatorio.
     */
    public void setAleatorio()
    {
        aleatorio = !aleatorio;
    }
    /**
     * play()- Este metodo toca  1º musica 
     * @return musica Representa a musica que está a tocar
     */
    public Musica play()
    {
        this.musica = cdInserido.getMusica(0);
        return musica;
    }
    /**
     * playAutomatico()-Este metodo tem como funçao reproduzir uma lista seguida ou aleatoria dependendo da opçao que esta selecionada
     */
    public void playAutomatico()
    {
        Iterator<Musica> iterador = cdInserido.getLista().iterator();
        if(aleatorio ==false)
        {
            int posicao = cdInserido.getLista().indexOf(musica);
            while(iterador.hasNext()||posicao == cdInserido.getLista().size()){
                posicao = cdInserido.getLista().indexOf(musica);
                if(posicao == cdInserido.getLista().size())
                  this.musica = cdInserido.getMusica(0);
                  else
                  this.musica = iterador.next();
                
        }
        }else{
            Random gerar = new Random();
            int posicao =0;
            do{
                posicao = gerar.nextInt(cdInserido.getLista().size());
                this.musica = cdInserido.getMusica(posicao);
                
            }while(false);
        }
        
    }
    /**
     *  proximaMusica()- Este metodo avança uma posiçao na lista de musicas, mas no caso de a posiçao ser o limite volta para a 1º posiçao e seleciona essa musica
     */
    public void proximaMusica()
    {
        int posicao = cdInserido.getLista().indexOf(musica);
        if(posicao == cdInserido.getLista().size())
        this.musica = cdInserido.getMusica(0);
        else
        this.musica = cdInserido.getMusica(posicao+1);
    }
    /**
     * retrocederMusica()- Retrocede uma posição mas no caso desta ser o limite (1º posiçao) passa para a ultima posiçao
     */
    public void retrocederMusica()
    {
        int posicao = cdInserido.getLista().indexOf(musica);
        if(posicao == 0)
        this.musica = cdInserido.getMusica(cdInserido.getLista().size());
        else
        this.musica = cdInserido.getMusica(posicao-1);
    }
    /**
     * primeiraMusica()- Seleciona a 1º musica
     */
    public void primeiraMusica()
    {
        this.musica = cdInserido.getMusica(0);
    }
    /**
     * ultimaMusica()-Seleciona a ultima musica
     */
    public void ultimaMusica()
    {
        this.musica = cdInserido.getMusica(9);
    }
    /**
     * informacao()- retorna-nos a informaçao sobre o cd e a musica actual
     * @return informacao
     */
    public String informacao()
    {
        String informacao ="";
        informacao += "CD inserido/n";
        informacao += cdInserido.toString();
        informacao += "Musica atual/n";
        informacao += musica.toString();
        return informacao;
    }
}
