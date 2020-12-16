
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    
    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
     /**
      * Metodo para checar se o turno e compativel com a peca clicada
      * parametros recebidos -> turnoJogo: recebe um inteiro que vai dizer de qual cor e o turno atual (0 para pecas brancas, 1 para pecas pretas)
      * cliqueX e cliqueY -> recebem um inteiro, cada, representando as coordenadas do objeto da classe CasaGUI, na classe JanelaPrincipal
      * @return true se a peca clicada for do turno atual, false se nao for
      */
    public boolean checarTurno(int turnoJogo, int cliqueX, int cliqueY){ //Metodo para verificar se o turno bate com a cor da peca clicada
        Casa casaClicada = tabuleiro.getCasa(cliqueX, cliqueY); //Define a casa clicada
        Peca pecaClicada = casaClicada.getPeca(); //Pega a peca dentro da casa clicada
        int corPecaClicada = pecaClicada.getCor(); //Verifica a cor da peca clicada
        
        if(turnoJogo == corPecaClicada){ //Se o turno tiver o mesmo valor que a cor da peca, retorna true (0 para pecas brancas, 1 para pecas pretas)
            return true;
        }
        
        return false; //Se nao, retorna false
    }
    
    /**
     * Metodo para atualizar o valor do turno
     * @return um inteiro representando o turno dos tipos de peca. 0 para pecas brancas e 1 para pecas pretas
     */
    public int atualizarTurno(int turnoJogo){
        if(turnoJogo == 0){ //Se o turno era das pecas brancas, retorna valor do turno das pecas pretas
            return 1;
        }
        else if(turnoJogo == 1){ //Se o turno era das pecas pretas, retorna valor do turno das pecas brancas
            return 0;
        }
        return 2; //Valor de controle de erro
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    public void criarPecas() {
        int tipoBranco = 0; //Peao
        int tipoPreto = 1;
        
        for(int x = 0; x <= 7; x++){ //O x vai da casa (0, 1) ate a (7, 1) e da casa (0, 6) ate a (7, 6) 
            Casa casaCriarPeaoBranco = tabuleiro.getCasa(x, 1); //Cria casa em (x, 1)
            Peao criarPeaoBranco = new Peao(casaCriarPeaoBranco, tipoBranco); //Cria peca na casa
            Casa casaCriarPeaoPreto = tabuleiro.getCasa(x, 6); //Cria casa em (x, 6)
            Peao criarPeaoPreto = new Peao(casaCriarPeaoPreto, tipoPreto); //Cria peca na casa
        }
        
        tipoBranco = 2; //Torre
        tipoPreto = 3;
        
        Casa casaCriarTorreBranca = tabuleiro.getCasa(0, 0); //Cria casa em (0, 0)
        Casa casaCriarTorreBrancaEspelhada = tabuleiro.getCasa(7, 0); //Cria casa espelhada em (7, 0)
        Torre criarTorreBranca = new Torre(casaCriarTorreBranca, tipoBranco); //Cria peca na casa
        Torre criarTorreBrancaEspelhada = new Torre(casaCriarTorreBrancaEspelhada, tipoBranco); //Cria peca na casa espelhada
        
        Casa casaCriarTorrePreta = tabuleiro.getCasa(0, 7); //Cria casa em (0, 7)
        Casa casaCriarTorrePretaEspelhada = tabuleiro.getCasa(7, 7); //Cria casa espelhada em (7, 7)
        Torre criarTorrePreta = new Torre(casaCriarTorrePreta, tipoPreto); //Cria peca na casa
        Torre criarTorrePretaEspelhada = new Torre(casaCriarTorrePretaEspelhada, tipoPreto); //Cria peca na casa espelhada
        
        tipoBranco = 4; //Cavalo
        tipoPreto = 5;
        
        Casa casaCriarCavaloBranco = tabuleiro.getCasa(1, 0); //Cria casa em (0, 0)
        Casa casaCriarCavaloBrancoEspelhada = tabuleiro.getCasa(6, 0); //Cria casa espelhada em (7, 0)
        Cavalo criarCavaloBranco = new Cavalo(casaCriarCavaloBranco, tipoBranco); //Cria peca na casa
        Cavalo criarPecaBrancaEspelhado = new Cavalo(casaCriarCavaloBrancoEspelhada, tipoBranco); //Cria peca na casa espelhada
        
        Casa casaCriarCavaloPreto = tabuleiro.getCasa(1, 7); //Cria casa em (0, 7)
        Casa casaCriarCavaloPretoEspelhada = tabuleiro.getCasa(6, 7); //Cria casa espelhada em (7, 7)
        Cavalo criarCavaloPreto = new Cavalo(casaCriarCavaloPreto, tipoPreto); //Cria peca na casa
        Cavalo criarCavaloPretoEspelhada = new Cavalo(casaCriarCavaloPretoEspelhada, tipoPreto); //Cria peca na casa espelhada
        
        tipoBranco = 6; //Bispo
        tipoPreto = 7;
        
        Casa casaCriarBispoBranco = tabuleiro.getCasa(2, 0); //Cria casa em (0, 0)
        Casa casaCriarBispoBrancoEspelhada = tabuleiro.getCasa(5, 0); //Cria casa espelhada em (7, 0)
        Bispo criarBispoBranco = new Bispo(casaCriarBispoBranco, tipoBranco); //Cria peca na casa
        Bispo criarBispoBrancoEspelhada = new Bispo(casaCriarBispoBrancoEspelhada, tipoBranco); //Cria peca na casa espelhada
        
        Casa casaCriarBispoPreto = tabuleiro.getCasa(2, 7); //Cria casa em (0, 7)
        Casa casaCriarBispoPretoEspelhada = tabuleiro.getCasa(5, 7); //Cria casa espelhada em (7, 7)
        Bispo criarBispoPreto = new Bispo(casaCriarBispoPreto, tipoPreto); //Cria peca na casa
        Bispo criarBispoPretoEspelhada = new Bispo(casaCriarBispoPretoEspelhada, tipoPreto); //Cria peca na casa espelhada
        
        tipoBranco = 8; //Rainha
        tipoPreto = 9;
        
        Casa casaCriarRainhaBranca = tabuleiro.getCasa(3, 0); //Cria casa em (4, 0)
        Rainha criarRainhaBranca= new Rainha(casaCriarRainhaBranca, tipoBranco); //Cria peca na casa
        
        Casa casaCriarRainhaPreta = tabuleiro.getCasa(3, 7); //Cria casa em (0, 7)
        Rainha criarRainhaPreta = new Rainha(casaCriarRainhaPreta, tipoPreto); //Cria peca na casa
        
        tipoBranco = 10; //Rei
        tipoPreto = 11;
        
        Casa casaCriarReiBranco = tabuleiro.getCasa(4, 0); //Cria casa em (4, 0)
        Rei criarReiBranco= new Rei(casaCriarReiBranco, tipoBranco); //Cria peca na casa
        
        Casa casaCriarReiPreto = tabuleiro.getCasa(4, 7); //Cria casa em (0, 7)
        Rei criarReiPreto = new Rei(casaCriarReiPreto, tipoPreto); //Cria peca na casa
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     * @return 1 para movimentacao com exito, 0 para movimentacao sem exito e -1 para nenhuma movimentacao feita
     */
    public int moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        int difX = (destinoX - origemX); //Diferenca entre o X do destino e o X da origem - serve para verificar se o movimento da peca e valido
        int difY = (destinoY - origemY); //Diferenca entre o Y do destino e o Y da origem - serve para verificar se o movimento da peca e valido
        
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        
        Peca peca = origem.getPeca();
        int tipoPeca = peca.getTipo();
        int movimento = peca.verifMov(tipoPeca, destinoX, destinoY, origemX, origemY, tabuleiro); //Aqui eu uso o metodo peca.verifMov() para ver se o movimento condiz com o tipo 
                                                                                                        //de peca e armazeno em "movimento"

        if(movimento == 1){
            peca.mover(destino);
            return movimento;
        }
        else{
            return movimento;
        }
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
