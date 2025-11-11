import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContadorDePalavras {
    public static void main(String[] args) {
        String caminhoArquivo = "texto.txt"; // arquivo a ser lido
        MeuHashMap<String, Integer> mapa = new MeuHashMap<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                // Remove pontuação e converte para minúsculo
                linha = linha.replaceAll("[^a-zA-Zà-úÀ-Ú0-9 ]", "").toLowerCase();
                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        Integer atual = mapa.get(palavra);
                        if (atual == null)
                            mapa.put(palavra, 1);
                        else
                            mapa.put(palavra, atual + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Coloca todas as entradas em uma lista para ordenar
        List<MeuHashMap.Entry<String, Integer>> lista = new ArrayList<>();
        for (String chave : mapa.chaves()) {
            lista.add(new MeuHashMap.Entry<>(chave, mapa.get(chave)));
        }

        // Ordena pela frequência (valor) em ordem decrescente
        Collections.sort(lista, new Comparator<MeuHashMap.Entry<String, Integer>>() {
            @Override
            public int compare(MeuHashMap.Entry<String, Integer> e1, MeuHashMap.Entry<String, Integer> e2) {
                return e2.valor.compareTo(e1.valor);
            }
        });

        // Exibe o resultado
        System.out.println("=== Frequência de Palavras ===");
        for (MeuHashMap.Entry<String, Integer> e : lista) {
            System.out.println(e.chave + " (" + e.valor + ")");
        }
    }
}
