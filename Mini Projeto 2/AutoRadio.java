
/**
 *faz a gestão do áudio no carro permitindo selecionar entre
 *ouvir rádio ou reproduzir um CD. 
 *No rádio pode-se escolher qual a banda (i.e. AM ou FM) 
 *e o canal em particular que se pretende ouvir. 
 *No Leitor de CDs pode-se selecionar a música que se pretende reproduzir.
 * 
 * @author (Hugo Pereira e João Gomes) 
 * @version (21-12-2015)
 */
public class AutoRadio
{
    // instance variables - replace the example below with your own
    private String marca;
    
    private LeitorDeCD leitor;
    
    private GestorDeCanais gestor;
    
    private boolean radio;
    
    private boolean ligado;
    
    private boolean play;

    /**
     * Constructor for objects of class AutoRadio
     * Este cria um leitorDeCD e um GestorDeCanais
     * radio e o estado do autooradio serão ligados
     */
    public AutoRadio()
    {
        leitor = new LeitorDeCD ();
        gestor = new GestorDeCanais();
        radio = true;
        ligado = true;
    }

    /**
     * botaoPower()- muda os estado do autorradio e se estiver ligado começa a tocar
     * se não não toca
     * 
     * 
     */
    public void botaoPower()
    {
        ligado = !ligado;
        if(ligado)
        play=true;
        else
        play=false;
    }
    /**
     * adicionarCanal()-Se setiver ligado adiciona um canal a partir do metodo 
     * implementado no festor de canais
     * 
     * @param posicao Do tipo int, representa a posiçao 
     * 
     * @param canal Objeto da classe canal
     */
   
    public void adicionarCanal(int posicao, Canal canal)
    {
        if (ligado)
        gestor.adicionarCanal(posicao,canal);
    }
    /**
     * removerCanal()- Se estiver ligado remove o canal a partir
     * do metodo implementado no gestor de canais
     * 
     * @param posicao Do tipo int, representa a posiçao 
     */
    
    public void removerCanal(int posicao)
    {
        if (ligado)
        gestor.removerCanal(posicao);
    }
    /**
     * proximo()-Se estiver ligado avnça a posiçao do canal, ou
     *  avança de musica
     */
    public void proximo()
    {
        if (ligado)
        {
            if(radio)
            gestor.avancarCanal();
            else
            leitor.proximaMusica();
        }
    }
    /**
     * anterior()-Se estiver ligado retrocede um canal de radio ou, retocede 
     * uma musica
     */
    public void anterior()
    {
        if (ligado)
        {
            if(radio)
            gestor.retrocederCanal();
            else
            leitor.retrocederMusica();
        }
    }
    /**
     *play()- Muda o estado booleano do atributo play
     */
    
    public void play()
    {
        play=!play;
    }
    /**
     * primeiro()-Se estiver ligado seleciona o 1º musica/canal dependendo
     * do que esta selecionado
     */
    public void primeiro()
    {
        if (ligado)
        {
            if(radio)
            gestor.primeiroCanal();
            else
            leitor.primeiraMusica();
        }
    }
    /**
     * ultimo()-Se estiver ligado, seleciona o ultimo canal ou a ultima musica
     * dependendo se estiver o radio ou a ser reproduzido um cd
     */
    public void ultimo()
    {
        if (ligado)
        {
            if(radio)
            gestor.ultimoCanal();
            else
            leitor.ultimaMusica();
        }
    }
    /**
     * informacaoAtual()-se estiver ligado mostranos , a informaçao do sistema que estamos
     * a utilizar
     */
    public void informacaoAtual()
    {
        if (ligado)
        {
            if(radio)
               System.out.println(gestor.informacao());
            else
               System.out.println(leitor.informacao());
        }
    }
    /**
     * modoAutomaticoLeitor()-liga o modo automatico do leitor de cd´s
     */
    public void modoAutomaticoLeitor()
    {
        if(ligado)
        if(!radio)
        leitor.playAutomatico();
    }
    /**
     * modoAleatorio()-liga o modo aleatorio do leitor de cd´s
     */
   
    public void modoAleatorio()
    {
        if(ligado)
        if(!radio)
        leitor.setAleatorio();
    }
}
