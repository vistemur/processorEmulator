package ProcessorCommands.Functions;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.TypedRegister;

import java.util.BitSet;

public class CALL implements ExecutableCommand {

    private BitSet jump;

    public String getLine() {
        return "CALL";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        jump = R1.register.getData();
    }

    public void changeData(CounterRegister pc, Memory memory) throws Exception {
        long jumpValue = Converter.convertBitsToLong(jump);
        if (jumpValue < 0)
            throw new Exception(getLine() + " can't call negative positions");

        memory.push(pc.getData());
        pc.setData(jump);
    }
}
