import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class exercicio {
    public static String lerArquivo(String caminho) {
        try {
            return new String(Files.readAllBytes(Paths.get(caminho)));
        } catch (IOException e) {
            return null;
        }
    }

    

    public static void  contarPalavras(String textoArquivo){
        
    }


    public static void main(String[] args) {
        String conteudo = lerArquivo("palavras.txt");
        System.out.println(conteudo);
    }
}