import java.lang.Math;
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {
    public static final int SEM_PECA = -1;
    
    protected Casa casa;
    protected int tipo;

    
    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }

    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    /**
     * Valor    Tipo
     *   0   Branca (Peao)
     *   1   Preta (Peao)
     *   2   Branca (Torre)
     *   3   Preta (Torre)
     *   4   Branca  (Cavalo)
     *   5   Preta  (Cavalo)
     *   6   Branca (Bispo)
     *   7   Preta (Bispo)
     *   8   Branca  (Rainha)
     *   9   Preta  (Rainha)
     *   10  Branca  (Rei)
     *   11  Preta  (Rei)
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
    
    /**
     * Metodo que retorna a cor da peca em questao
     * @return 0 para pecas brancas e 1 para pecas pretas
     */
    public int getCor(){
        if((this.tipo % 2) == 0){
            return 0; //Par sao pecas brancas
        }
        else{
            return 1; //Impar sao pecas pretas
        }
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    /** Método verifMov criado para verificar se a diferenca entre as coordenadas da casa destino e da casa origem condizem com o movimento de cada tipo de peca. 
     * Se condisser, ele permite a movimentacao da peca para a casa destino.
     * 
     * Recebe parâmetros tipo -> int que nos diz o tipo da peca que estamos movendo;
     * destinoX -> int que nos diz a posicao X do destino; destinoY -> int que nos diz a posicao Y do destino;
     * origemX -> int que nos diz a posicao X do origem; origemY -> int que nos diz a posicao Y do origem.
     * tabuleiro -> recebe o tabuleiro da classe Jogo.
     * 
     * @return 1 se o movimento puder ser feito pela peca;
     * @return 0 se o movimento não puder ser feito;
     * @return -1 se nao ha movimento
     */
    public int verifMov(int tipo, int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro) {
        int x = destinoX - origemX;
        int y = destinoY - origemY;
        
        if((x == 0) && (y == 0)){ //Se nao ha movimento (diferenca entre destino e origem e zero tanto no x como no y, entao retorna -1
            return -1;
        }
        
        boolean caminhoLivre = this.verifCaminhoCome(tipo, destinoX, destinoY, origemX, origemY, tabuleiro);
        
        if(caminhoLivre){ //Verifica se o trajeto esta livre para a peca continuar
            boolean resultado;
            resultado = verifPeca(x, y);
            
            if(resultado){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{ //Se nao estiver, retorna 0
            return 0;
        }
    }
    
    protected boolean verifPeca(int valorX, int valorY){
        return false;
    }
    
    /**
     * verifCaminhoCome e um metodo que verifica o caminho que a peca vai percorrer, nos retornando se o movimento feito pelo usuario e possivel. Tambem verifica se e possivel que
     * a peca em questao possa comer/capturar uma outra peca.
     * 
     * Recebe parâmetros tipo -> int que nos diz o tipo da peca que estamos movendo;
     * destinoX -> int que nos diz a posicao X do destino; destinoY -> int que nos diz a posicao Y do destino;
     * origemX -> int que nos diz a posicao X do origem; origemY -> int que nos diz a posicao Y do origem.
     * tabuleiro -> recebe o tabuleiro da classe Jogo.
     * 
     * @return true se nao existe uma peca no caminho feito pela peca
     */
    public boolean verifCaminhoCome(int tipo, int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
        boolean resultado;
        resultado = possuiPeca(destinoX, destinoY, origemX, origemY, tabuleiro);
        
        return resultado;
    }
    
    protected boolean possuiPeca(int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
         return false;
    }
    
}