
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private int i;
    private int j=0;


    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        Casa casa1 = tabuleiro.getCasa(0, 0);
        Peca peca1 = new Peca(casa1, Peca.TORRE_BRANCA);
        
        Casa casa2 = tabuleiro.getCasa(1, 0);
        Peca peca2 = new Peca(casa2, Peca.CAVALO_BRANCO);
        
        Casa casa3 = tabuleiro.getCasa(2, 0);
        Peca peca3 = new Peca(casa3, Peca.BISPO_BRANCO);
        
        Casa casa4 = tabuleiro.getCasa(3, 0);
        Peca peca4 = new Peca(casa4, Peca.RAINHA_BRANCA);
        
        Casa casa5 = tabuleiro.getCasa(4, 0);
        Peca peca5 = new Peca(casa5, Peca.REI_BRANCO);
        
        Casa casa6 = tabuleiro.getCasa(5, 0);
        Peca peca6 = new Peca(casa6, Peca.BISPO_BRANCO);
        
        Casa casa7 = tabuleiro.getCasa(6, 0);
        Peca peca7 = new Peca(casa7, Peca.CAVALO_BRANCO);
        
        Casa casa8 = tabuleiro.getCasa(7, 0);
        Peca peca8 = new Peca(casa8, Peca.TORRE_BRANCA);
        
        for(i=9; i<=16; i++){
            Casa casai = tabuleiro.getCasa(j, 1);
            Peca pecai = new Peca(casai, Peca.PEAO_BRANCO);
            j++;
        }
        
        j=0;
        
        for(i=9; i<=16; i++){
            Casa casai = tabuleiro.getCasa(j, 6);
            Peca pecai = new Peca(casai, Peca.PEAO_PRETO);
            j++;
        }
        
        Casa casa25 = tabuleiro.getCasa(0, 7);
        Peca peca25 = new Peca(casa25, Peca.TORRE_PRETA);
        
        Casa casa26 = tabuleiro.getCasa(1, 7);
        Peca peca26 = new Peca(casa26, Peca.CAVALO_PRETO);
        
        Casa casa27 = tabuleiro.getCasa(2, 7);
        Peca peca27 = new Peca(casa27, Peca.BISPO_PRETO);
        
        Casa casa28 = tabuleiro.getCasa(3, 7);
        Peca peca28 = new Peca(casa28, Peca.RAINHA_PRETA);
        
        Casa casa29 = tabuleiro.getCasa(4, 7);
        Peca peca29 = new Peca(casa29, Peca.REI_PRETO);
        
        Casa casa30 = tabuleiro.getCasa(5, 7);
        Peca peca30 = new Peca(casa30, Peca.BISPO_PRETO);
        
        Casa casa31 = tabuleiro.getCasa(6, 7);
        Peca peca31 = new Peca(casa31, Peca.CAVALO_PRETO);
        
        Casa casa32 = tabuleiro.getCasa(7, 7);
        Peca peca32 = new Peca(casa32, Peca.TORRE_PRETA);
    
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        peca.mover(destino);
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
