package Experimento;

import java.util.Arrays;
import java.util.Random;

public class Gera_Experimento {
    public static double mediaSequentialSearch(int n, int iter) {
        double mediaST = 0;
        for (int j = 0; j < iter; j++) {
            SequentialSearchST<Integer, String> a = new SequentialSearchST<Integer, String>();
            while(a.size() < n) {//Gereando N chaves aleatórias
                Random i = new Random();
                a.put(i.nextInt(n), ("val" + i));
            }
            Stopwatch pesquisaB = new Stopwatch();
            for (int i = 0; i < n; i++) {//Pesquisa bem suscedidas N chaves aleatórias
                for (int k = 0; k < 10; k++) {
                    a.get(i);
                }
            }
            mediaST += pesquisaB.elapsedTime();

            Stopwatch pesquisaM = new Stopwatch();
            for (int i = 0; i < n; i++) {//Pesquisa bem suscedidas N chaves aleatórias
                for (int k = 0; k < 10; k++) {
                    a.get(n + 1);
                }
            }
            mediaST += pesquisaM.elapsedTime();
            n = n * 2;
            System.out.println("-----------------SEQUENTIAL_SEARCH_ST = " + (j + 1) + "-------------------");
        }
        System.out.println("Media: " + mediaST/iter);
        System.out.println("-----------------------------------------------\n");
        return mediaST/iter;
    }

    public static double mediaBInarySearch(int n, int iter) {
        double mediaBS =0;
        for (int k = 0; k < iter; k++) {
            System.out.println("-----------------BINARY_SEARCH_ST = " + (k + 1) + "-------------------");
            //int[] lista = new int[n];
            BinarySearchST<Integer,String> lis = new BinarySearchST<Integer,String>();
            for (int i = 0; i < n; i++) {
               // lista[i] = i;
                lis.put(i, ("valor_"+i));
            }
            // sort the array
            //Arrays.sort(lista);
            
            Stopwatch pesquisaB = new Stopwatch();
            //Pesquisa bem suscedidas N chaves aleatórias
            for (int i = 0; i < n; i++) {//Pesquisa bem suscedidas N chaves aleatórias
                for (int j = 0; j < 10; j++) {
                    lis.contains(i);
                }
            }
            mediaBS += pesquisaB.elapsedTime();

            Stopwatch pesquisaM = new Stopwatch();
            for (int i = 0; i < n; i++) {//Pesquisa bem suscedidas N chaves aleatórias
                for (int j = 0; j < 10; j++) {
                    lis.contains(i+n);
                }
            }
            n = n * 2;
            mediaBS += pesquisaM.elapsedTime();
        }
        System.out.println("Media: " + mediaBS/iter);
        System.out.println("-----------------------------------------------\n");
        return mediaBS/iter;
    }

}
