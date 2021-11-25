package ProcessorCommands.Logic;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;

public class AND implements ExecutableCommand {

    public String getLine() {
        return "AND";
    }

    public int getRegistersRequired() {
        return 2;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        if (R1.type == RegisterType.memory && R2.type == RegisterType.memory)
            throw new Exception(getLine() + " can't AND data between memory");

        long a = Converter.convertBitsToLong(R1.register.getData());
        long b = Converter.convertBitsToLong(R2.register.getData());
        R1.register.setData(Converter.convertLongToBits(a & b));
    }
}
