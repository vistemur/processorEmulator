package ProcessorCommands.InOut;

import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.TypedRegister;

import java.util.BitSet;

public class IN implements ExecutableCommand {

    private boolean dataIsRead = false;
    private BitSet dataRead;

    public String getLine() {
        return "IN";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        if (dataIsRead) {
            R1.register.setData(dataRead);
        }
    }

    public void changeData(CommandData data) throws Exception {
        if (dataIsRead) {
            data.pc.incrementPC();
            return;
        }

        try {
            dataRead = data.processorStreams.read();
            dataIsRead = true;
        } catch (Exception ignored) { }
    }
}
