
/**
 * Escreva a descrição da classe Torre aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Torre extends Peca
{
    public static final int TORRE_BRANCA = 2,
                            TORRE_PRETA = 3;
                            
    public Torre(Casa casa, int tipo){
        super(casa, tipo);
    }
    
    /**
     * Verificador de movimento para a torre
     * @return true ou false para a movimentacao da torre (branca ou preta)
     */
    protected boolean verifPeca(int valorX, int valorY) {
        valorX = Math.abs(valorX); //Uso do valor absoluto das coordenadas, pois a torre pode ir e voltar, entao nao e necessario o uso do sinal
        valorY = Math.abs(valorY);
        if((valorX > 0) ^ (valorY > 0)){ //A condicao so sera ativada quando apenas uma das variaveis for maior que 0. 
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
        int x = origemX;
        int y = origemY;
        
        int difX = (destinoX - origemX); //Diferenca entre o X do destino e o X da origem
        int difY = (destinoY - origemY); //Diferenca entre o Y do destino e o Y da origem
        
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
}
