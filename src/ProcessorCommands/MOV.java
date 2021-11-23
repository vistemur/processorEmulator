package ProcessorCommands;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.TypedRegister;

import java.util.BitSet;

public class MOV implements ExecutableCommand  {

    public String getLine() {
        return "MOV";
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) {
        R1.register.setData(R2.register.getData());
    }
}
