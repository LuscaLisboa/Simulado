import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> dadosA = readFile("A"); // Pessoas
        List<String> dadosB = readFile("B"); // Endereços

        writeFile(dadosA, dadosB);

        List<String> dadosC = readFile("C");

        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < dadosC.size(); i++) {
            String[] partesC = dadosC.get(i).split(";");
            Pessoa pessoa = new Pessoa(partesC[0], partesC[1], partesC[2], partesC[3]);
            pessoas.add(pessoa);
        }
    }

    public static List<String> readFile(String name) throws FileNotFoundException {

        File file = new File("C:\\Users\\autologon\\Desktop\\Simulado\\" + name + ".txt");
        Scanner read = new Scanner(file);

        List<String> dados = new ArrayList<>();

        while (read.hasNext()) {
            String dado = read.nextLine();
            dados.add(dado);
        }

        read.close();

        return dados;
    }

    public static void writeFile(List<String> dadosA, List<String> dadosB) throws IOException {

        FileWriter arquivo = new FileWriter("C:\\Users\\autologon\\Desktop\\Simulado\\C.txt");

        for (int i = 0; i < dadosA.size(); i++) {
            for (int j = 0; j < dadosB.size(); j++) {

                String[] partesA = dadosA.get(i).split(";");
                String[] partesB = dadosB.get(j).split(";");

                if (partesA[0].equals(partesB[2]))
                    arquivo.write(dadosA.get(i) + ";" + dadosB.get(j));
            }
        }
        arquivo.close();
    }
}