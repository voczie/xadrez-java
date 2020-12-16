
/**
 * Escreva a descrição da classe Cavalo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cavalo extends Peca
{
    public static final int CAVALO_BRANCO = 4,
                            CAVALO_PRETO = 5;
                            
    public Cavalo(Casa casa, int tipo){
        super(casa, tipo);
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
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca pecaDestino = destino.getPeca();
        
        int tipoDestino = pecaDestino != null ? pecaDestino.getCor() : -1;  // Condicao (retorna boolean) ? se true, atribui esse valor : se false, atribui esse valor.
        
        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
            return false;
        }
        else{
            return true; //A peca é um cavalo, ele pode pular pecas proprias e pecas inimigas, logo tem passe livre da verificacao do trajeto
        }
    }
    
    /**
     * Verificador de movimento para o cavalo
     * @return true ou false para a movimentacao do cavalo (branco ou preto)
     */
    protected boolean verifPeca(int valorX, int valorY) {
        valorX = Math.abs(valorX); //Uso do valor absoluto das coordenadas, pois a torre pode ir e voltar, entao nao e necessario o uso do sinal
        valorY = Math.abs(valorY);
        if((valorX == 2) && (valorY == 1)){ //A condicao so sera ativada se o X for igual a 2 e o Y for igual a 1 ("L" na horizontal)
            return true;
        }
        else if((valorX == 1) && (valorY == 2)){ //A condicao so sera ativada se o X for igual a 1 e o Y for igual a 2 ("L" na vertical)
            return true;
        }
        //Retorno falso padrão para coordenadas não compatíveis com a peca.
        return false;
    }
}
