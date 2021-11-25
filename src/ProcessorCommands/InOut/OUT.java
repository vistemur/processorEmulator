package ProcessorCommands.InOut;

import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.TypedRegister;

import java.util.BitSet;

public class OUT implements ExecutableCommand {

    private BitSet outputData;

    public String getLine() {
        return "OUT";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        outputData = R1.register.getData();
    }

    public void changeData(CommandData data) throws Exception {
        data.processorStreams.write(outputData);
        data.pc.incrementPC();
    }
}
