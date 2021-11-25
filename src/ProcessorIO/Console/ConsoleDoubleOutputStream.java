package ProcessorIO.Console;

import DataHolders.Converter;
import ProcessorIO.ProcessorOutputStream;

import java.util.BitSet;

public class ConsoleDoubleOutputStream implements ProcessorOutputStream {

    public void write(BitSet data) {
        System.out.println(Converter.convertBitsToDouble(data));
    }
}
