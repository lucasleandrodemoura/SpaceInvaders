/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.util.Arrays;

/**
 *
 * @author lmoura
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inimigo Ini[] = new Inimigo[20];
        int QuantTiros = 0;
        int MoveBonecos = 0;
        int QuantInimigos = Ini.length;
        int Jogo = 0;
        
        
        Inimigo Ini1 = new Inimigo(1, 1, 8);
        Inimigo Ini2 = new Inimigo(18, 1, 3);
        Inimigo Ini3 = new Inimigo(36, 1, 6);
        Inimigo Ini4 = new Inimigo(54, 1, 2);
        Inimigo Ini5 = new Inimigo(70, 1, 10);
        Inimigo Ini6 = new Inimigo(1, 8, 12);
        Inimigo Ini7 = new Inimigo(18, 8, 1);
        Inimigo Ini8 = new Inimigo(36, 8, 3);
        Inimigo Ini9 = new Inimigo(54, 8, 6);
        Inimigo Ini10 = new Inimigo(70, 8, 8);
        Inimigo Ini11 = new Inimigo(1, 16, 7);
        Inimigo Ini12 = new Inimigo(18, 16, 3);
        Inimigo Ini13 = new Inimigo(36, 16, 6);
        Inimigo Ini14 = new Inimigo(54, 16, 8);
        Inimigo Ini15 = new Inimigo(70, 16, 10);
        Inimigo Ini16 = new Inimigo(1, 24, 3);
        Inimigo Ini17 = new Inimigo(18, 24, 6);
        Inimigo Ini18 = new Inimigo(36, 24, 4);
        Inimigo Ini19 = new Inimigo(54, 24, 5);
        Inimigo Ini20 = new Inimigo(70, 24, 6);
        Ini[0] = Ini1;
        Ini[1] = Ini2;
        Ini[2] = Ini3;
        Ini[3] = Ini4;
        Ini[4] = Ini5;
        Ini[5] = Ini6;
        Ini[6] = Ini7;
        Ini[7] = Ini8;
        Ini[8] = Ini9;
        Ini[9] = Ini10;
        Ini[10] = Ini11;
        Ini[11] = Ini12;
        Ini[12] = Ini13;
        Ini[13] = Ini14;
        Ini[14] = Ini15;
        Ini[15] = Ini16;
        Ini[16] = Ini17;
        Ini[17] = Ini18;
        Ini[18] = Ini19;
        Ini[19] = Ini20;
      
        Tiro tiro[] = new Tiro[50];
        
        
        
        
        Space.init();
        do {
            if (Space.apertouDireita()) {
                if (Space.getPlatX() != 75) {
                    Space.setPlatX(Space.getPlatX() + 1);
                }
            }
            if (Space.apertouEsquerda()) {
                if (Space.getPlatX() != 1) {
                    Space.setPlatX(Space.getPlatX() - 1);
                }
            }
            if (Space.apertouEspaco()) {
                if (QuantTiros != 50) {
                    tiro[QuantTiros] = new Tiro(Space.getPlatX(), 77);
                    QuantTiros++;
                }
            }
            //Move os bonecos a cada 20 laços
            if (MoveBonecos > 20) {
                for (int a = 0; a < Ini.length; a++) {

                    if (Ini[a].y < 70) {
                        Ini[a].y = Ini[a].y + 1;
                    } else {
                        Space.gameOver();
                        Jogo=1;
                    }
                }
                MoveBonecos = 0;
            } else {
                MoveBonecos++;
            }
            
            
            //move as balas
            if (QuantTiros > 0) {
                for (int a = 0; a < QuantTiros; a++) {
                    tiro[a].y = tiro[a].y - 1;

                    //Controla se o tiro já saiu da tela
                    if (tiro[a].y < 0) {
                        //Retira do Vetor e ordena novamente
                        for (int V1 = a; V1 < tiro.length - 1; V1++) {
                            Tiro aux = tiro[V1];
                            tiro[V1] = tiro[V1 + 1];
                            tiro[V1 + 1] = aux;
                        }
                        QuantTiros--;
                    }
                }
            }
            
            
            //Compara se tem alguma bala sobre algum monstro
            //Se QuantInimigos for > 0
            if (QuantInimigos > 0) {
                //Pega todos os tiros e todos os inimigos
                for (int a = 0; a < QuantTiros; a++) {
                    for (int b = 0; b < QuantInimigos; b++) {
                        //se tiro esta sobre o ponto do monstro
                        if (tiro[a].y == Ini[b].y + 6) {
                            if (tiro[a].x >= Ini[b].x
                                    || tiro[a].x == (Ini[b].x - 1)
                                    || tiro[a].x == (Ini[b].x + 1)
                                    || tiro[a].x == (Ini[b].x + 2)
                                    || tiro[a].x == (Ini[b].x + 3)
                                    || tiro[a].x == (Ini[b].x + 4)
                                    || tiro[a].x == (Ini[b].x + 5)
                                    || tiro[a].x == (Ini[b].x + 6)
                                    || tiro[a].x == (Ini[b].x + 7)
                                    || tiro[a].x == (Ini[b].x + 8)
                                    || tiro[a].x == (Ini[b].x + 9)
                                    || tiro[a].x == (Ini[b].x + 10)) {

                                //Se não tem mais vida mata inimigo, se não minimiza uma vida
                                if (Ini[b].vida == 0) {
                                    //Retira do Vetor e ordena novamente
                                    for (int V1 = b; V1 < QuantInimigos - 1; V1++) {
                                        Inimigo aux = Ini[V1];
                                        Ini[V1] = Ini[V1 + 1];
                                        Ini[V1 + 1] = aux;
                                    }
                                    QuantInimigos--;



                                    //Retira do Vetor a bala e ordena novamente
                                    for (int V1 = a; V1 < QuantTiros - 1; V1++) {
                                        Tiro aux = tiro[V1];
                                        tiro[V1] = tiro[V1 + 1];
                                        tiro[V1 + 1] = aux;
                                    }
                                    QuantTiros--;
                                } else {
                                    Ini[b].vida = Ini[b].vida - 1;
                                     //Retira do Vetor a bala e ordena novamente
                                    for (int V1 = a; V1 < QuantTiros - 1; V1++) {
                                        Tiro aux = tiro[V1];
                                        tiro[V1] = tiro[V1 + 1];
                                        tiro[V1 + 1] = aux;
                                    }
                                    QuantTiros--;
                                }
                            }
                        }
                    }
                }
            } else {
                Space.ganhou();
                Jogo = 1;
            }
            Space.desenha(Ini, QuantInimigos, tiro, QuantTiros);
        } while (Jogo == 0);
    }
}
