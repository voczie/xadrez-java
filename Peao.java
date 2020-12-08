
/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Peao extends Peca
{
    public static final int PEAO_BRANCO = 0,
                            PEAO_PRETO = 1;
    
    public Peao(Casa casa, int tipo){
        super(casa, tipo);
    }
  
    /** Método verifMov criado para verificar se a diferenca entre as coordenadas da casa destino e da casa origem condizem com o movimento de cada tipo de peca. 
     * Se condisser, ele permite a movimentacao da peca para a casa destino.
     * 
     * Recebe parâmetros das diferenças entre as coordenadas x = (destinoX - origemX), y = (destinoY - origemY), origemY = origemY.
     * @return true ou false para a movimentacao da peca.
     */
    public boolean verifMov(int x, int y, int origemY, int tipo) {
        boolean resultado;
        if(tipo == 0){ //Caso a peca seja um peao branco
            resultado = this.verifPeaoBranco(x, y, origemY);
            return resultado;
        }
        else if(tipo == 1){ //Caso a peca seja um peao preto
            resultado = this.verifPeaoPreto(x, y, origemY);
            return resultado;
        }
        else{ //Caso impossivel, mas aplicado por seguranca do codigo
            return false;
        }
    }
    
    /**
     * verifCaminhoCome e um metodo que verifica o caminho que a peca vai percorrer, nos retornando se o movimento feito pelo usuario e possivel. Tambem verifica se e possivel que
     * a peca em questao possa comer/capturar uma outra peca.
     * 
     * Recebe parâmetros tipo -> int que nos diz o tipo da peca que estamos movendo;
     * destinoX -> int que nos diz a posicao X do destino; destinoY -> int que nos diz a posicao Y do destino;
     * origemX -> int que nos diz a posicao X do origem; origemY -> int que nos diz a posicao Y do origem.
     * tabuleiro -> recebe o tabuleiro da classe Jogo.
     * @return true se nao existe uma peca no caminho feito pela peca
     */
    public boolean verifCaminhoCome(int tipo, int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
        boolean resultado;
        if(tipo == 0){ //Caso a peca seja um peao branco
            resultado = possuiPecaPeaoBranco(destinoX, destinoY, origemX, origemY, tabuleiro);
            return resultado;
        }
        else if(tipo == 1){ //Caso a peca seja um peao preto
            resultado = possuiPecaPeaoPreto(destinoX, destinoY, origemX, origemY, tabuleiro);
            return resultado;
        }
        else{ //Caso impossivel, mas aplicado por seguranca do codigo
            return false;
        }
    }
    
    /**
     * Verificador de movimento para o peao branco
     * Recebe parametro origemY para saber se ja ocorreu a primeira jogada de um peao branco
     * @return true ou false para a movimentacao do peao branco
     */
    protected boolean verifPeaoBranco(int valorX, int valorY, int origemY) {
        if(valorX == 0){ //O peao nao pode andar pro lado, logo seu X tem que mudar em 0 casas
            if(origemY == 1){ //Se o peao ainda esta no Y = 1 (logo nao se moveu), ainda e sua primeira jogada e ele pode andar duas casas ou apenas uma
                if((valorY == 1) || (valorY == 2)){
                    return true;
                }     
            }
            else{ //Se nao for a primeira jogada do peao, ele so podera aumentar seu Y em 1
                if(valorY == 1){
                    return true;
                }
            }
        }
        else if((valorX == 1) || (valorX == -1)){
            if(valorY == 1){
                return true;
            }
        }
        //Retorno falso padrão para coordenadas não compatíveis com a peca.
        return false;
    }
    
    /**
     * Verificador de movimento para o peao preto
     * Recebe parametro origemY para saber se ja ocorreu a primeira jogada de um peao preto
     * @return true ou false para a movimentacao do peao preto
     */
    protected boolean verifPeaoPreto(int valorX, int valorY, int origemY) {
        if(valorX == 0){ //O peao nao pode andar pro lado, logo seu X tem que mudar em 0 casas
            if(origemY == 6){ //Se o peao ainda esta no Y = 6 (logo nao se moveu), ainda e sua primeira jogada e ele pode andar duas casas ou apenas uma
                if(((valorY == -1) || (valorY == -2))){
                    return true;
                }
            }
            else{ //Se nao for a primeira jogada do peao, ele so podera aumentar seu Y em 1
                if(valorY == -1){
                    return true;
                }
            }
        }
        else if((valorX == 1) || (valorX == -1)){
            if(valorY == -1){
                return true;
            }
        }
        //Retorno falso padrão para coordenadas não compatíveis com a peca.
        return false;
    }
    
    /**
     * Metodo criado para ser usado no verifCaminhoCome e verificar se o caminho de um peao esta livre e se ele pode se mover na diagonal para capturar outra peca
     * @return um booleano, se true, ele permite que a movimentacao da peca ocorra, se false, ele nao permite.
     */
    protected boolean possuiPecaPeaoBranco(int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
        int x = origemX;
        int y = origemY;
        
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca pecaDestino = destino.getPeca();
        
        int tipoDestino = pecaDestino != null ? pecaDestino.getCor() : -1;  // Condicao (retorna boolean) ? se true, atribui esse valor : se false, atribui esse valor.
        
        if(destinoX == origemX){
            for(y++ ; y <= destinoY; y++){
                Casa teste = tabuleiro.getCasa(origemX, y);
                Peca pecaTeste = teste.getPeca();
                
                if(pecaTeste != null){ //Se a casa atual tiver uma peca, retorna falso, pois peao nao come pra frente
                    return false;
                }
            }
        }
        else{
            if((tipoDestino == -1) || (tipoDestino == this.getCor())){//Se o peao tentar andar na diagonal, mas for uma casa vazia (null) ou uma casa com peca da mesma cor, retorna
                                                                        //falso
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodo criado para ser usado no verifCaminhoCome e verificar se o caminho de um peao esta livre e se ele pode se mover na diagonal para capturar outra peca
     * @return um booleano, se true, ele permite que a movimentacao da peca ocorra, se false, ele nao permite.
     */
    protected boolean possuiPecaPeaoPreto(int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
        int x = origemX;
        int y = origemY;
        
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca pecaDestino = destino.getPeca();
        
        int tipoDestino = pecaDestino != null ? pecaDestino.getCor() : -1;  // Condicao (retorna boolean) ? se true, atribui esse valor : se false, atribui esse valor.
        
        if(destinoX == origemX){
            for(y--; y >= destinoY; y--){
                Casa teste = tabuleiro.getCasa(origemX, y);
                Peca pecaTeste = teste.getPeca();

                if(pecaTeste != null){ //Se a casa atual tiver uma peca, retorna falso, pois peao nao come pra frente
                    return false;
                }
            }
        }
        else{
            if((tipoDestino == -1) || (tipoDestino == this.getCor())){ //Se o peao tentar andar na diagonal, mas for uma casa vazia (null) ou uma casa com peca da mesma cor, retorna
                                                                        //falso
                return false;
            }
        }
        return true;
    }
}
