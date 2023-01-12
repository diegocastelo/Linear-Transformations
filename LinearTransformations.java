import java.util.*;


public class TransformacaoLinear {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha qual operação deseja realizar : ");
        System.out.println("(1) Translação (em 2D e em 3D)");
        System.out.println("(2) Rotação (em 2D e em todos os eixos em 3D)");
        System.out.println("(3) Reflexão (em todos os eixos nas dimensões 2D e 3D)");
        System.out.println("(4) Projeção (em todos os eixos em 2D e m 3D)");
        System.out.println("(5) Cisalhamento (apenas em 2D)");
        System.out.println("(0) Para finalizar");

        int X = sc.nextInt();
        int Y = 0;
        int Z = 0;
        int W = 0;
        int M = 0;
        int B = 0;
        int C = 0;
        int linhas1s = 0;
        int colunas1s = 1;
        double[][] matriz1s;
        double[][] matrizt;
        double angulo;


        while (X != 0) {

            if (X == 1) {
                System.out.println("Digite a dimensão do Vetor: ");

                linhas1s = sc.nextInt();
                matriz1s = new double[linhas1s][colunas1s];

                System.out.println("Digite os valores das dimenções dos vetores: ");
                for (int l1 = 0; l1 < linhas1s; l1++) {
                    for (int c1 = 0; c1 < colunas1s; c1++) {
                        matriz1s[l1][c1] = sc.nextDouble();
                    }
                }
                System.out.println("Vetor A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz1s[l][c]);
                    }
                    System.out.printf("%n");
                }

                double[][] matriz2s = new double [linhas1s][colunas1s];

                System.out.println("Digite os elementos da matriz translação de A:");
                for (int l2 = 0; l2 < linhas1s; l2++) {
                    for (int c2 = 0; c2 < colunas1s; c2++) {
                        matriz2s[l2][c2] = sc.nextDouble();
                    }
                }
                System.out.println("Matriz translação de A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz2s[l][c]);
                    }
                    System.out.printf("%n");
                }
                double[][] matriz3s = new double[linhas1s][colunas1s];

                for (int is = 0; is < linhas1s; is++) {
                    for (int ks = 0; ks < colunas1s; ks++) {
                        matriz3s[is][ks] = matriz1s[is][ks] + matriz2s[is][ks];
                    }
                }

                System.out.println("Vetor Resultante: ");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz3s[l][c]);
                    }
                    System.out.printf("%n");
                }

            }

            if (X == 2) {
                System.out.println("Digite a dimensão do Vetor: ");

                linhas1s = sc.nextInt();
                colunas1s = 1;
                matriz1s = new double[linhas1s][colunas1s];

                System.out.println("Digite os valores das dimenções dos vetores: ");
                for (int l1 = 0; l1 < linhas1s; l1++) {
                    for (int c1 = 0; c1 < colunas1s; c1++) {
                        matriz1s[l1][c1] = sc.nextDouble();
                    }
                }

                System.out.println("Vetor A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz1s[l][c]);
                    }
                    System.out.printf("%n");
                }

                System.out.println("Digite o ângulo de rotação em graus: ");
                angulo = sc.nextInt();
                double y = Math.toRadians(angulo);
                double sen = Math.sin(y);
                double cos = Math.cos(y);

                if(linhas1s == 2){
                    matrizt = new double[2][2];
                    matrizt[0][0] = cos;
                    matrizt[0][1] = -sen;
                    matrizt[1][0] = sen;
                    matrizt[1][1] = cos;

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 2; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor Rotacionado: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }

                }

                if(linhas1s == 3){
                    matrizt = new double[3][3];
                    System.out.println("Qual eixo deseja deixar inalterado? [1]Eixo X  [2]Eixo Y [3]Eixo Z");
                    C = sc.nextInt();
                    if(C == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = cos;
                        matrizt[1][2] = -sen;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = sen;
                        matrizt[2][2] = cos;
                    }

                    if(C == 2){
                        matrizt[0][0] = cos;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = sen;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = -sen;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = cos;
                    }

                    if(C == 3){
                        matrizt[0][0] = cos;
                        matrizt[0][1] = -sen;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = sen;
                        matrizt[1][1] = cos;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 3; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor Rotacionado: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }

                }
            }

            if (X == 3) {
                System.out.println("Digite a dimensão do Vetor: ");

                linhas1s = sc.nextInt();
                colunas1s = 1;
                matriz1s = new double[linhas1s][colunas1s];

                System.out.println("Digite os valores das dimenções dos vetores: ");
                for (int l1 = 0; l1 < linhas1s; l1++) {
                    for (int c1 = 0; c1 < colunas1s; c1++) {
                        matriz1s[l1][c1] = sc.nextDouble();
                    }
                }

                System.out.println("Vetor A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz1s[l][c]);
                    }
                    System.out.printf("%n");
                }

                if(linhas1s == 2){
                    matrizt = new double[2][2];
                    System.out.println("Qual eixo deseja realizar a reflexão? [1]Eixo X  [2]Eixo Y");
                    B = sc.nextInt();
                    if(B == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = -1;
                    }
                    if(B == 2){
                        matrizt[0][0] = -1;
                        matrizt[0][1] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 2; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor Rotacionado: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }

                }

                if(linhas1s == 3){
                    matrizt = new double[3][3];
                    System.out.println("Qual eixo deseja realizar a reflexão? [1]Eixo X  [2]Eixo Y [3]Eixo Z");
                    M = sc.nextInt();
                    if(M == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = -1;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = -1;
                    }

                    if(M == 2){
                        matrizt[0][0] = -1;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = -1;
                    }

                    if(M == 3){
                        matrizt[0][0] = -1;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = -1;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 3; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor após a Reflexão: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }
                }
            }

            if (X == 4) {
                System.out.println("Digite a dimensão do Vetor: ");

                linhas1s = sc.nextInt();
                colunas1s = 1;
                matriz1s = new double[linhas1s][colunas1s];

                System.out.println("Digite os valores das dimenções dos vetores: ");
                for (int l1 = 0; l1 < linhas1s; l1++) {
                    for (int c1 = 0; c1 < colunas1s; c1++) {
                        matriz1s[l1][c1] = sc.nextDouble();
                    }
                }

                System.out.println("Vetor A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz1s[l][c]);
                    }
                    System.out.printf("%n");
                }

                if(linhas1s == 2){
                    matrizt = new double[2][2];
                    System.out.println("Qual eixo deseja realizar a projeção? [1]Eixo X  [2]Eixo Y");
                    W = sc.nextInt();
                    if(W == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 0;
                    }
                    if(W == 2){
                        matrizt[0][0] = 0;
                        matrizt[0][1] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 2; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor após a Projeção: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }

                }

                if(linhas1s == 3){
                    matrizt = new double[3][3];
                    System.out.println("Qual eixo deseja realizar a projeção? [1]Eixo X  [2]Eixo Y [3]Eixo Z");
                    Z = sc.nextInt();
                    if(Z == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 0;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = 0;
                    }

                    if(Z == 2){
                        matrizt[0][0] = 0;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = 0;
                    }

                    if(Z == 3){
                        matrizt[0][0] = 0;
                        matrizt[0][1] = 0;
                        matrizt[0][2] = 0;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 0;
                        matrizt[1][2] = 0;
                        matrizt[2][0] = 0;
                        matrizt[2][1] = 0;
                        matrizt[2][2] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 3; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor após a Projeção: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }
                }
            }

            if (X == 5) {
                linhas1s = 2;
                colunas1s = 1;
                matriz1s = new double[linhas1s][colunas1s];

                System.out.println("Digite os valores do vetor de dimensão 2: ");
                for (int l1 = 0; l1 < linhas1s; l1++) {
                    for (int c1 = 0; c1 < colunas1s; c1++) {
                        matriz1s[l1][c1] = sc.nextDouble();
                    }
                }

                System.out.println("Vetor A:");
                for (int l = 0; l < linhas1s; l++) {
                    for (int c = 0; c < colunas1s; c++) {
                        System.out.printf("| %3f | ", matriz1s[l][c]);
                    }
                    System.out.printf("%n");
                }

                if(linhas1s == 2){
                    matrizt = new double[2][2];
                    System.out.println("Qual eixo deseja realizar o Cisalhamento? [1]Eixo X  [2]Eixo Y");
                    Y = sc.nextInt();
                    System.out.printf("Qual o valor do fator de cisalhamento: ");
                    double K = sc.nextDouble();
                    if(Y == 1){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = K;
                        matrizt[1][0] = 0;
                        matrizt[1][1] = 1;
                    }
                    if(Y == 2){
                        matrizt[0][0] = 1;
                        matrizt[0][1] = 0;
                        matrizt[1][0] = K;
                        matrizt[1][1] = 1;
                    }

                    double[][] matriz3 = new double[linhas1s][1];
                    for (int g = 0; g < linhas1s; g++) {
                        for (int h = 0; h < 1; h++) {
                            matriz3[g][h] = 0;
                            for (int k = 0; k < 2; k++) {
                                matriz3[g][h] += matrizt[g][k] * matriz1s[k][h];
                            }
                        }
                    }

                    System.out.println("Vetor após o Cisalhamento: ");
                    for (int l = 0; l < linhas1s; l++) {
                        for (int c = 0; c < 1; c++) {
                            System.out.printf("| %3f | ", matriz3[l][c]);
                        }
                        System.out.printf("%n");
                    }

                }
            }

            System.out.println("");
            System.out.println("Escolha qual operação deseja realizar : ");
            System.out.println("(1) Translação (em 2D e em 3D)");
            System.out.println("(2) Rotação (em 2D e em todos os eixos em 3D)");
            System.out.println("(3) Reflexão (em todos os eixos nas dimensões 2D e 3D)");
            System.out.println("(4) Projeção (em todos os eixos em 2D e m 3D)");
            System.out.println("(5) Cisalhamento (apenas em 2D)");
            System.out.println("(0) Para finalizar");

            X = sc.nextInt();

        }
    }
}







