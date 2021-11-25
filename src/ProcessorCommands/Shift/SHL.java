package ProcessorCommands.Shift;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;

public class SHL implements ExecutableCommand {

    public String getLine() {
        return "SHL";
    }

    public int getRegistersRequired() {
        return 2;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        if (R1.type == RegisterType.memory && R2.type == RegisterType.memory)
            throw new Exception(getLine() + " can't shift left data between both memory values");

        long a = Converter.convertBitsToLong(R1.register.getData());
        long b = Converter.convertBitsToLong(R2.register.getData());
        R1.register.setData(Converter.convertLongToBits(a << b));
    }
}
