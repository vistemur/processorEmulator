package ProcessorCommands.Jump;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.TypedRegister;

public class JMP implements ExecutableCommand {

    private long jump = -1;

    public String getLine() {
        return "JMP";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        jump = Converter.convertBitsToLong(R1.register.getData());
    }

    public void changeData(CounterRegister pc, Memory memory) throws Exception {
        if (jump > -1)
            pc.setData(Converter.convertLongToBits(jump));
        else
            throw new Exception(getLine() + " can't jump to negative values");
        jump = -1;
    }
}
