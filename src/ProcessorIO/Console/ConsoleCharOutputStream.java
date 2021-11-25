package ProcessorIO.Console;

import DataHolders.Converter;
import ProcessorIO.ProcessorOutputStream;

import java.util.BitSet;

public class ConsoleCharOutputStream implements ProcessorOutputStream {

    public void write(BitSet data) {
        System.out.print((char) Converter.convertBitsToByte(data));
    }
}
