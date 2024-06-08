package gto.talent.tech;

import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) {
        // crear un archivo
        //writeToFile("inputByte.dat", "Ejemplo de Byte Stream");

        // leer un archivo
        //readFromFile("inputByte.dat");

        // copiar un archivo
        copyFile("inputByte.dat", "outputByte.txt");

        // leer archivo copiado
        readFromFile("outputByte.txt");
    }

    public static void writeToFile(String fileName, String data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) { // try with resources
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
            System.out.println("File created!");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public static void readFromFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int byteData;
            while ((byteData = fileInputStream.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void copyFile(String inputFile, String outputFile) {
        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            byte [] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
