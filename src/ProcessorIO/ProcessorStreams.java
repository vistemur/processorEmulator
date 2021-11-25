package ProcessorIO;

import java.util.ArrayList;
import java.util.BitSet;

public class ProcessorStreams implements ProcessorInputStream, ProcessorOutputStream {

    private final ArrayList<ProcessorOutputStream> outputStreams;
    private final ArrayList<ProcessorInputStream> inputStreams;

    public ProcessorStreams() {
        this.outputStreams = new ArrayList<ProcessorOutputStream>();
        this.inputStreams = new ArrayList<ProcessorInputStream>();
    }

    public void add(ProcessorOutputStream stream) {
        outputStreams.add(stream);
    }

    public void add(ProcessorInputStream stream) {
        inputStreams.add(stream);
    }

    public BitSet read() throws Exception {
        for (ProcessorInputStream stream : inputStreams) {
            try {
                return stream.read();
            } catch (Exception ignored) { }
        }
        throw new Exception("no data to read");
    }

    public void write(BitSet data) {
        for (ProcessorOutputStream stream : outputStreams)
            stream.write(data);
    }
}
