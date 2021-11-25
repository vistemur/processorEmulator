package ProcessorIO.Console;

import DataHolders.Converter;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;
import ProcessorIO.ProcessorInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class ConsoleInputStream implements ProcessorInputStream {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BitSet read() throws Exception {
        String line = reader.readLine();
        char firstChar = line.charAt(0);

        if (firstChar >= '0' && firstChar <= '9' || firstChar <= '-') {
            if (line.contains("."))
                return Converter.convertDoubleToBits(Double.parseDouble(line));
            else
                return Converter.convertLongToBits(Long.parseLong(line));
        }
        return Converter.convertByteToBits((byte) firstChar);
    }
}
