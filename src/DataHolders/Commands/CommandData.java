package DataHolders.Commands;

import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import ProcessorIO.ProcessorStreams;

public class CommandData {

    public CounterRegister pc;
    public Memory memory;
    public ProcessorStreams processorStreams;

    public CommandData(CounterRegister pc, Memory memory, ProcessorStreams processorStreams) {
        this.pc = pc;
        this.memory = memory;
        this.processorStreams = processorStreams;
    }
}
