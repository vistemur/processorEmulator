package ProcessorCommands;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.TypedRegister;

public class NOP implements ExecutableCommand {

    public String getLine() {
        return "NOP";
    }

    public int getRegistersRequired() {
        return 0;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception { }
}
