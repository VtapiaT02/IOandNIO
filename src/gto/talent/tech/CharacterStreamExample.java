package gto.talent.tech;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

public class CharacterStreamExample {
    public static void main(String[] args) {
        // crear un archivo
        writeToFile("input.txt", "Ejemplo de Characters Stream");

        // leer un archivo
        readFromFile("input.txt");

        // copiar un archivo
        copyFile("input.txt", "output.txt");

        // leer archivo copiado
        readFromFile("output.txt");
    }

    public static void writeToFile(String fileName, String data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) { // try with resources
            fileWriter.write(data);
            System.out.println("Data written to: " + fileName);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public static void readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            int charData;
            System.out.println("Reading...");
            while((charData = fileReader.read()) != -1) {
                System.out.print((char) charData);
            }
            System.out.println();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void copyFile(String inputFile, String outputFile) {
        try (FileReader fileReader = new FileReader(inputFile);
             FileWriter fileWriter = new FileWriter(outputFile)) {
            char[] buffer = new char[1024];

            int charData;

            while ((charData = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, charData);
            }
            System.out.println("Copied from " + inputFile + " to " + outputFile);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
