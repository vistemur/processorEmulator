package ProcessorIO;

import DataHolders.Converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;

public class FileLongOutputStream implements ProcessorOutputStream {

    private String fileName;

    public FileLongOutputStream(String fileName) {
        this.fileName = fileName;
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
