package ProcessorCommands.Jump;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.TypedRegister;

public class JZ implements ExecutableCommand {

    private long jump = -1;
    private boolean needsToJump = false;

    public String getLine() {
        return "JZ";
    }

    public int getRegistersRequired() {
        return 3;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        needsToJump = Converter.convertBitsToLong(R2.register.getData()) == 0L;
        jump = Converter.convertBitsToLong(R1.register.getData());
    }

    public void changeData(CounterRegister pc, Memory memory) throws Exception {
        if (needsToJump) {
            if (jump > -1)
                pc.setData(Converter.convertLongToBits(jump));
            else
                throw new Exception(getLine() + " can't jump to negative values");
        } else {
            ExecutableCommand.super.changeData(pc, memory);
        }
        needsToJump = false;
    }
}
