package ProcessorCommands.Functions;

import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.TypedRegister;

public class RET implements ExecutableCommand {

    public String getLine() {
        return "RET";
    }

    public int getRegistersRequired() {
        return 0;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {}

    public void changeData(CommandData data) throws Exception {
        data.pc.setData(data.memory.pop().getData());
        data.pc.incrementPC();
    }
}
