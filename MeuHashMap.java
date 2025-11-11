import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MeuHashMap<K, V> {
    private static final int TAMANHO_INICIAL = 16;
    private List<No<K, V>>[] tabela;

    @SuppressWarnings("unchecked")
    public MeuHashMap() {
        tabela = new LinkedList[TAMANHO_INICIAL];
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(K chave) {
        return Math.abs(chave.hashCode() % TAMANHO_INICIAL);
    }

    public void put(K chave, V valor) {
        int indice = hash(chave);
        List<No<K, V>> lista = tabela[indice];

        for (No<K, V> no : lista) {
            if (no.chave.equals(chave)) {
                no.valor = valor; // atualiza valor existente
                return;
            }
        }

        lista.add(new No<>(chave, valor)); // adiciona novo
    }

    public V get(K chave) {
        int indice = hash(chave);
        List<No<K, V>> lista = tabela[indice];

        for (No<K, V> no : lista) {
            if (no.chave.equals(chave)) {
                return no.valor;
            }
        }

        return null; // não encontrado
    }

    public List<K> chaves() {
        List<K> todas = new ArrayList<>();
        for (List<No<K, V>> lista : tabela) {
            for (No<K, V> no : lista) {
                todas.add(no.chave);
            }
        }
        return todas;
    }

    // Classe auxiliar interna para armazenar pares chave-valor
    private static class No<K, V> {
        K chave;
        V valor;

        No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    // Classe para exportar chave e valor facilmente
    public static class Entry<K, V> {
        public K chave;
        public V valor;

        public Entry(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}
