package ProcessorIO;

import DataHolders.Converter;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

public class FileLongOutputStream implements ProcessorOutputStream {

    private String fileName;

    public FileLongOutputStream(String fileName) {
        try {
            String filePath = FileLongOutputStream.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            filePath = URLDecoder.decode(filePath, "UTF-8");
            filePath = filePath.substring(0, filePath.length() - 21);
            filePath += fileName;
            this.fileName = filePath;
            PrintWriter writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(BitSet data) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(Converter.convertBitsToLong(data)));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
