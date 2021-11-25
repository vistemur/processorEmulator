package ProcessorCommands.Functions;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.Register;
import DataHolders.Registers.TypedRegister;

import java.util.BitSet;

public class RET implements ExecutableCommand {

    public String getLine() {
        return "RET";
    }

    public int getRegistersRequired() {
        return 0;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {}

    public void changeData(CounterRegister pc, Memory memory) throws Exception {
        pc.setData(memory.pop().getData());
        pc.incrementPC();
    }
}
