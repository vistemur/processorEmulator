package ProcessorIO.Console;

import DataHolders.Converter;
import ProcessorIO.ProcessorOutputStream;

import java.util.BitSet;

public class ConsoleLongOutputStream implements ProcessorOutputStream {

    public void write(BitSet data) {
        System.out.println(Converter.convertBitsToLong(data));
    }
}
