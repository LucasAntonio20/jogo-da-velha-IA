package jogadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seiya extends Jogador{
    
    private List<String> ultimasJogadas = new ArrayList<>();
    private int simbolo;

    public Seiya(String nome) {
        super(nome);
        simbolo = getSimbolo();
    }

    @Override
    public int[] jogar(int[][] tabuleiro) {
        int[] jogada = new int[2];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] == simboloDoInimigo()) {
                    //Direita
                    if (j < tabuleiro.length && i+1 < tabuleiro.length)  {
                        if (tabuleiro[i+1][j] == -1) {
                            jogada[0] = i + 1;
                            jogada[1] = j;
                            return jogada;
                        }
                    }
                    //Cima
                    if (i > 0 && j-1 > 0) {
                        if (tabuleiro[i][j-1] == -1) {
                            jogada[0] = i;
                            jogada[1] = j - 1;
                            return jogada;
                        }
                    }
                    //Baixo
                    if (i < tabuleiro.length && j+1 < tabuleiro.length) {
                        if (tabuleiro[i][j+1] == -1) {
                            jogada[0] = i;
                            jogada[1] = j + 1;
                            return jogada;
                        }
                    }
                    //Esquerda
                    if (j > 0 && i-1 > 0) {
                        if  (tabuleiro[i-1][j] == -1) {
                            jogada[0] = i - 1;
                            jogada[1] = j;
                            return jogada;
                        }
                    }
                }
                    int x;
                    int y;

                    do {
                        x = new Random().nextInt(tabuleiro.length);
                        y = new Random().nextInt(tabuleiro.length);
                    } while (tabuleiro[x][y] != -1);

                    jogada[0] = x;
                    jogada[1]= y;
                
            }
        }

        return jogada;
    }

    private int simboloDoInimigo() {
        if (simbolo == 'X') return 0;
        else return 1;
    }
    
}
