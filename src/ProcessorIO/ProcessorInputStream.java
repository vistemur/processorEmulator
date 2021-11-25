package ProcessorIO;

import java.util.BitSet;

public interface ProcessorInputStream {
    public BitSet read() throws Exception;
}
