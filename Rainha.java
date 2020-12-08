
/**
 * Escreva a descrição da classe Rainha aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rainha extends Peca
{
    public static final int RAINHA_BRANCA = 8,
                            RAINHA_PRETA = 9;
                            
    public Rainha(Casa casa, int tipo){
        super(casa, tipo);
    }
    
    /**
     * Verificador de movimento para a rainha
     * @return true ou false para a movimentacao da rainha (branca ou preta)
     */
    protected boolean verifPeca(int valorX, int valorY) {
        valorX = Math.abs(valorX); //Uso do valor absoluto das coordenadas, pois a torre pode ir e voltar, entao nao e necessario o uso do sinal
        valorY = Math.abs(valorY);
        
        if((valorX > 0) ^ (valorY > 0)){
            return true;
        }
        else if(valorX == valorY){
            return true;
        }
        //Retorno falso padrão para coordenadas não compatíveis com a peca.
        return false;
    }
    
    /**
     * Metodo criado para ser usado no verifCaminhoCome e verificar se o caminho de um peao esta livre e se ele pode se mover na diagonal para capturar outra peca
     * @return um booleano, se true, ele permite que a movimentacao da peca ocorra, se false, ele nao permite.
     */
    protected boolean possuiPeca(int destinoX, int destinoY, int origemX, int origemY, Tabuleiro tabuleiro){
        int difX = Math.abs((destinoX - origemX)); //O modulo da diferenca entre o X do destino e o X da origem
        int difY = Math.abs((destinoY - origemY)); //O modulo da diferenca entre o Y do destino e o Y da origem
        
        if((difX == 0) ^ (difY == 0)){
            int x = origemX;
            int y = origemY;
            
            difX = (destinoX - origemX); //Diferenca entre o X do destino e o X da origem
            difY = (destinoY - origemY); //Diferenca entre o Y do destino e o Y da origem
            
            Casa destino = tabuleiro.getCasa(destinoX, destinoY);
            Peca pecaDestino = destino.getPeca();
            
            int tipoDestino = pecaDestino != null ? pecaDestino.getCor() : -1;  // Condicao (retorna boolean) ? se true, atribui esse valor : se false, atribui esse valor.
            
            if((difX == 0) && (difY < 0)){ //Indo para baixo
                for(y--; y >= destinoY; y--){
                    Casa teste = tabuleiro.getCasa(origemX, y);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if(y != destinoY){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX == 0) && (difY > 0)){ //Indo para cima
                for(y++; y <= destinoY; y++){
                    Casa teste = tabuleiro.getCasa(origemX, y);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if(y != destinoY){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX < 0) && (difY == 0)){ //Indo para esquerda
                for(x--; x >= destinoX; x--){
                    Casa teste = tabuleiro.getCasa(x, origemY);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if(x != destinoX){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX > 0) && (difY == 0)){ //Indo para direita
                for(x++; x <= destinoX; x++){
                    Casa teste = tabuleiro.getCasa(x, origemY);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if(x != destinoX){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        else if(difX == difY){
            int x = origemX;
            int y = origemY;
            
            difX = (destinoX - origemX); //Diferenca entre o X do destino e o X da origem
            difY = (destinoY - origemY); //Diferenca entre o Y do destino e o Y da origem
            
            Casa destino = tabuleiro.getCasa(destinoX, destinoY);
            Peca pecaDestino = destino.getPeca();
            
            int tipoDestino = pecaDestino != null ? pecaDestino.getCor() : -1;  // Condicao (retorna boolean) ? se true, atribui esse valor : se false, atribui esse valor.
            
            if((difX < 0) && (difY < 0)){ // Diagonal para baixo-esquerda
                for(x--, y--; x >= destinoX && y >= destinoY; x--, y--){
                    Casa teste = tabuleiro.getCasa(x, y);
                    Peca pecaTeste = teste.getPeca();
                    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if((x != destinoX) && (y != destinoY)){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX < 0) && (difY > 0)){ //Diagonal para cima-esquerda
                for(x--, y++; x >= destinoX && y <= destinoY; x--, y++){
                    Casa teste = tabuleiro.getCasa(x, y);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if((x != destinoX) && (y != destinoY)){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX > 0) && (difY < 0)){ //Diagonal para baixo-direita
                for(x++, y--; x <= destinoX && y >= destinoY; x++, y--){
                    Casa teste = tabuleiro.getCasa(x, y);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if((x != destinoX) && (y != destinoY)){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            else if((difX > 0) && (difY > 0)){ //Diagonal para cima-direita
                for(x++, y++; x <= destinoX && y <= destinoY; x++, y++){
                    Casa teste = tabuleiro.getCasa(x, y);
                    Peca pecaTeste = teste.getPeca();
    
                    if(pecaTeste != null){ //Se a casa atual tiver uma peca, entra na condicao
                        if((x != destinoX) && (y != destinoY)){ //Se a casa atual nao for o destino final e tiver uma peca (primeira condicao), retorna falso
                            return false;
                        }
                        if((this.getCor() == tipoDestino)){ //Se a cor da peca da casa de origem for igual a cor da peca da casa atual, retorna falso, pois nao pode ser comida.
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}
