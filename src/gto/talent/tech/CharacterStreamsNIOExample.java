package gto.talent.tech;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class CharacterStreamsNIOExample {
    public static void main(String[] args) {
        // crear un archivo
        writeToFile("inputNIO.txt", "Ejemplo de Characters Stream NIO");

        // leer un archivo
        readFromFile("inputNIO.txt");

        // copiar un archivo
        copyFile("inputNIO.txt", "outputNIO.txt");

        // leer archivo copiado
        readFromFile("outputNIO.txt");
    }

    public static void writeToFile(String fileName, String content) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            System.out.println("File created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void copyFile(String inputFile, String outputFile) {
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        try {
            Files.copy(inputPath, outputPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
