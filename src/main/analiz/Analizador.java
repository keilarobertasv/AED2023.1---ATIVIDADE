package analiz;

import java.util.ArrayList;

public class Analizador {
int melhor = -1;
    double melhor_valor = 0;
    public int[] acha_sequencia(double[] probs, int[] valores){
        int tamanho = valores.length;
        ArrayList<Integer> ordem = new ArrayList<Integer>();
        ArrayList<Integer> usados = new ArrayList<Integer>();
        while (ordem.size() < tamanho){ 
            int x = seleciona(probs, valores, usados);
            ordem.add(x);
            usados.add(x); 
        }
        int[] resultado = new int[ordem.size()];
        for (int i = 0; i < ordem.size(); i++){
            resultado[i] = ordem.get(i);
        }
        return resultado;
    }

    public int seleciona(double[] probs, int[] valores, ArrayList<Integer> usados){
        melhor = -1;
        melhor_valor = 0;
        // Criar um fluxo de inteiros de 0 a 9 (exclusivo)
        for (int i = 0; i < probs.length; i++) {
            
            if (!usados.contains(i)){
                double valor = valores[i] * probs[i] * probs[i];
                if (valor > melhor_valor){
                    melhor = i;
                    melhor_valor = valor;
                }
            }
        }
        return melhor;
    }
}