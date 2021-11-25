package ProcessorCommands;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;

public class MOV implements ExecutableCommand  {

    public String getLine() {
        return "MOV";
    }

    public int getRegistersRequired() {
        return 2;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        if (R1.type == RegisterType.memory && R2.type == RegisterType.memory)
            throw new Exception(getLine() + " can't move data between memory");
        R1.register.setData(R2.register.getData());
    }
}
