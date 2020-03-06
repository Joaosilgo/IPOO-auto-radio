import java.util.ArrayList;
/**
 * A classe Gravador vai ser responsavel pela gravação de conteudos de musicas nos cd´s ,Está é uma classe autonoma do Autorradio, o gravador possui já uma colecção de
 * musicas em que podem ser removidas ou adicionadas musicas á coleçao que o gravador possui, estas musicas seram depois gravadas no Cd, este recebe cd´s virgens e formatados
 * tem tambem a capacidade de formata-los e fecha-los.
 * 
 * @author (João Gomes; Hugo Pereira) 
 * @version (21-12-2015)
 */
public class Gravador
{
   
    private ArrayList<Musica> listaInterna ;
     
    private CD cdInserido;
   
    

    /**
     * COnstrutor para objetos da classe Gravador
     */
    public Gravador()
    {
         
             listaInterna = new ArrayList<Musica>();
             
             
         
       
         
    }
    /**
     * inserirCd()-Este metodo recebe um cd em que faz a sua validação
     */
    public void inserirCd(CD cd)
    {
        if(cd != null)
        this.cdInserido = cd;
    }
     /**
     * formatarCd()- Recebe um titulo para o cd, executa as validações neçessaria para saber e existe um cd inserido
     * e depois formata-o e inser um titulo ao mesmo
     * @param String tituloParaCd - titulo definido para o cd depos de formatado
     */
    public void formatarCd(String tituloParaCd)
    {
        if(cdInserido==null)
        {
            System.out.println("Nao existe CD inserido");
        }else{
            cdInserido.formatar();
            cdInserido.setTituloCD(tituloParaCd);
        }
    }
    /**
     * adicionarMusica()-Este metodo recebe uma musica faz as validaçoes nesseçarias e adiciona-a á coleçao interna do gravador
     * @param Musica musica- objecto criado pela classe musica
     */
    public void adicionarMusica(Musica musica)
    {
        if(musica!=null)
        listaInterna.add(musica);
    }
    /**
     * removerMusica()- Este metodo recebe o nome do ficheiro procura-o na coleçao de musicas internas e remove-o
     * @param String ficheiro - nome do ficheiro de musica criado
     */
    public void removerMusica(String ficheiro)
    {
        if(ficheiro!= null)
        {
            for(int i=0;i<listaInterna.size();i++)
            {
                if(listaInterna.get(i).getFicheiro().equals(ficheiro))
                listaInterna.remove(i);
            }
        }
    }
    /**
     * removerMusica()-Este metodo recebe a posição faz a sua validação, corre a lista e remove essa posição
     * @param int posicao- subtraindo uma unidade da-nos o indice na lista 
     */
    public void removerMusica(int posicao)
    {
        if(posicao <= listaInterna.size())
        {
            for(int i=0;i<listaInterna.size();i++)
            {
                if(i==posicao-1)
                listaInterna.remove(i);
            }
        }
    }
    /**
     * removerTodasMusicas()- este metodo cria uma nova lista interna, ou seja apaga toda a outra lista e cria uma nova sem nenhuns elementos
     */
    public void removerTodasMusicas()
    {
        listaInterna = new ArrayList<Musica>();
    }
    /**
     * gravarCd-Este método serve para passar os ficheiros da coleçao interna do gravador 
     * para o cdInserido, fazendo todas as validações nesseçárias, como objecto cdInserido 
     * a capacidade do cd inserido, a formatação, passando estas validações o cd é gravado- 
     * 
     * @param fechar tipo booleano que serve para se não quiser voltar a gravar no cdInserido
     */
    public void gravarCd(boolean fechar)
    {
        if(cdInserido==null)
        {
            System.out.println("Nao existe CD inserido");
        }else if(getEspacoNaListaInterna()>cdInserido.capacidade())
        {
            System.out.println("Não existe espaço sufeciente no CD para as musica existentes no gravador");
        }else if(cdInserido.isFormatado())
        {
            System.out.println("O CD nao esta formatado");
        }else{
           for(int i=0; i<listaInterna.size();i++)
           {
            cdInserido.gravar(listaInterna.get(i));
           }
           if(fechar)
           cdInserido.fechar();
        }
    }
    /**
     * trocarPosicaoMusicas()- este metodo recebe as posições das 2 musicas a trocar, e faz a validação
     * das mesmas, quanto ao tamanho do Array, de segunda faz as copias das mesmas e seleciona-as nas 
     * posiçoes a trocar da lista interna(ás posiçoes subtraimos 1 unidade devido ao formato do Array)
     * @param musica1posicao tipo int, representa as posições das musicas a trocar
     * @param musica2posicao tipo int, representa as posições das musicas a trocar
     */
    public void trocarPosicaoMusicas(int musica1posicao, int musica2posicao)
    {
        if(musica1posicao<=listaInterna.size() && musica2posicao<=listaInterna.size())
        {
          Musica copia1 = listaInterna.get(musica1posicao-1);
          Musica copia2 = listaInterna.get(musica2posicao-1);
          listaInterna.set(musica1posicao-1,copia2);
          listaInterna.set(musica2posicao-1,copia1);
        }
    }
    /**
     * inserirMusicaNumaPosicao()- Este metodo recebe a posição e uma musica e insere-a na lista 
     * interna fazendo a validação neçessaria.
     * @param posicao tipo int, representa a posição desejada
     * @param musica Da Classe Musica representa um objecto musica
     */
    public void inserirMusicaNumaPosicao(int posicao, Musica musica)
    {
        if(posicao <= listaInterna.size())
        listaInterna.set(posicao-1,musica);
    }
    /**
     * cdInformacao()- Este metodo mosta a imformaçao do cd a partir do metodo toString
     * implementado na classe anterior
     */
    public void cdInformacao()
    {
        System.out.println(cdInserido.toString());
    }
    /**
     * getEspacoNaListaInterna()-Este metodo pecorre a coleçao da lista, e para cada elemento 
     * ele retorna o tamanho e junta-os no espaço, este faz as convergencias neçessaria, 
     * por fim retorna o espaço da lista interna
     * @return espaço tipo double refente ao espaço ocupado na lista interna
     */
    public double getEspacoNaListaInterna()
    {
        double espaco = 0;
        for (int i=0; i<listaInterna.size();i++){
             espaco += listaInterna.get(i).getTamanho();}
             espaco = espaco*0.001;
             return espaco;
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
     * informacaoGravador()-Este metodo mostra a informaçao das faixas de musicas existentes
     */
    public void informacaoGravador()
    {
        System.out.println("FAIXAS");
        System.out.println("Nº de Faixas: "+listaInterna.size());
        for(int i=0; i<listaInterna.size(); i++)
        {        
            System.out.println(listaInterna.get(i)) ;
        }
        
    }
}
        

