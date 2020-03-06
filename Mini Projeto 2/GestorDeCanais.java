import java.util.ArrayList;
/**
 * Está classe vai possuir canais memorizados para cada uma das bandas (AM/FM), irá também permitir adicionar e remover canais memorizados. 
 * 
 * @author (Hugo Pereira e João Gomes) 
 * @version (21-12-2015)
 */
public class GestorDeCanais
{
    
    private Canal[] canaisAM;
    
    private Canal[] canaisFM;
    
    private Canal canalSelecionado;
    
    private Banda bandaSelecionada;
    

    /**
     * COnstrutor para objetos da classe GestorDeCanais
     * Cria 2 arrays uma para FM outra para AM, e seleciona uma frequencia e uma banda
     */
    public GestorDeCanais()
    {
        canaisAM = new Canal[10];
        canaisFM = new Canal[10];
        bandaSelecionada = Banda.FM;
        canalSelecionado = canaisFM[0];
    }

    /**
     * adicionarCanal()- faz a validaçao da posiçao e do canal visto que a posição faz referencia á posição do array tivemos de subtrair uma unidade, 
     * assim para adicionar o canal no array este irá para a posição pretendida.
     * 
     * @param  posicao tipo int
     * @param  canal    objeto da classe Canal
     * 
     */
    public void adicionarCanal(int posicao, Canal canal)
    {
        // ponha seu código aqui
        if(posicao<=10 && posicao >0){
            if(canal != null){
               if (bandaSelecionada == Banda.AM)
                 canaisAM[posicao-1]=canal;
               else if(bandaSelecionada ==Banda.FM)
                 canaisFM[posicao-1]=canal;
            }
        } 
    }
    /**
     * 
     * removerCanal() -este recebe a posição e faz as validações do mesmo, mas desta vez coloca a posição a null
     */
  
    
    public void removerCanal(int posicao)
    {
        // ponha seu código aqui
        if(posicao<=10 && posicao >0){
            
               if (bandaSelecionada == Banda.AM)
                 canaisAM[posicao-1]= null;
               else if(bandaSelecionada ==Banda.FM)
                 canaisFM[posicao-1]=null;
            
        } 
    }
    /**
     * informacaoCanal()- da-nos a informaçao da posiçao pretendida
     * @param posicao tipo int, representa a posiçao no Array
     * @return informaçao
     */
    public String informacaoCanal(int posicao)
    {
        
        if(posicao<=10 && posicao >0){
            
               if (bandaSelecionada == Banda.AM)
                 return canaisAM[posicao-1].toString();
               else if(bandaSelecionada ==Banda.FM)
                 return canaisFM[posicao-1].toString();
            
        } 
        return "";
        
    }
    /**
     * trocarBanda()
     */
    
    public void trocarBanda()
    {
        if (bandaSelecionada == Banda.AM)
        {
            bandaSelecionada = Banda.FM;
            int posicao = 0;
            for(int i=0 ;i<canaisAM.length;i++){
            if(canaisAM[i] == canalSelecionado){
            posicao = i;}}
            canalSelecionado = canaisFM[posicao];
        }else
        {
            bandaSelecionada = Banda.AM;
            int posicao = 0;
            for(int i=0 ;i<canaisFM.length;i++){
            if(canaisAM[i] == canalSelecionado){
            posicao = i;}}
            canalSelecionado = canaisAM[posicao];
        }
    }
    /**
     *  avancarCanal()-Metodo que avança canal este verifica a banda selecionada(AM/FM), procura o canal selecionado e avança retrocede uma posição sendo exceção na posição 9
     *  onde avança para a posiçao 0
     */
    public void avancarCanal()
    {
        if (bandaSelecionada == Banda.AM)
        {
            int posicao = 0;
            for(int i=0 ;i<canaisAM.length;i++){
             if(canaisAM[i] == canalSelecionado){
                posicao = i;}}
            if(posicao ==9){
                canalSelecionado = canaisAM[0];}
            canalSelecionado = canaisAM[posicao+1];
        }else
        {
            int posicao = 0;
            for(int i=0 ;i<canaisFM.length;i++){
             if(canaisAM[i] == canalSelecionado){
                posicao = i;}}
            if(posicao ==9){
                canalSelecionado = canaisFM[0];}
            canalSelecionado = canaisFM[posicao+1];
        }
    }
    /**
     * retrocederCanal()-Este metodo seleciona a banda (FM/FM), procura o canal selecionado e retocede uma posição com ao canal 0 que retocede até á posição 9
     */
    public void retrocederCanal()
    {
        if (bandaSelecionada == Banda.AM)
        {
            
            int posicao = 0;
            for(int i=0 ;i<canaisAM.length;i++){
             if(canaisAM[i] == canalSelecionado){
                posicao = i;}}
            if(posicao ==0){
                canalSelecionado = canaisAM[9];}
            canalSelecionado = canaisAM[posicao-1];
        }else
        {
            int posicao = 0;
            for(int i=0 ;i<canaisFM.length;i++){
             if(canaisAM[i] == canalSelecionado){
                posicao = i;}}
            if(posicao ==0){
                canalSelecionado = canaisFM[9];}
            canalSelecionado = canaisFM[posicao-1];
        }
    }
    /**
     * primeiroCanal()- Seleciona o primeiro canal dependendo da banda selecionada
     */
    public void primeiroCanal()
    {
        if (bandaSelecionada == Banda.AM)
        {
            canalSelecionado = canaisAM[0];
        }else
        {
            canalSelecionado = canaisFM[0];
        }
    }
    /**
     * ultimoCanal()-Seleciona o último canal
     * dependendo da banda selecionada
     */
    public void ultimoCanal()
    {
        if (bandaSelecionada == Banda.AM)
        {
            canalSelecionado = canaisAM[9];
        }else
        {
            canalSelecionado = canaisFM[9];
        }
    }
    /**
     *  informacao()-Retorna a informaçao do canal selecionado, implementado na classe anterior
     *  @return informacao do canal selecionado
     */
    public String informacao()
    {
        return canalSelecionado.toString();        
    }
}
