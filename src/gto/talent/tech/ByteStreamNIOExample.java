package gto.talent.tech;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ByteStreamNIOExample {
    public static void main(String[] args) {
        // crear un archivo
        writeToFile("inputByteNIO.txt", "Ejemplo de Byte Stream NIO");

        // leer un archivo
        //readFromFile("inputNIO.txt");

        // copiar un archivo
        //copyFile("inputNIO.txt", "outputNIO.txt");

        // leer archivo copiado
        //readFromFile("outputNIO.txt");
    }

    public static void writeToFile(String fileName, String text) {
        Path path = Paths.get(fileName);
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8));
            fileChannel.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
