package ProcessorCommands.Jump;

import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
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

    public void changeData(CommandData data) throws Exception {
        if (jump > -1)
            data.pc.setData(Converter.convertLongToBits(jump));
        else
            throw new Exception(getLine() + " can't jump to negative values");
        jump = -1;
    }
}
