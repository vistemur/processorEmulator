package ProcessorCommands.Math;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;

public class DADD implements ExecutableCommand {

    public String getLine() {
        return "DADD";
    }

    public int getRegistersRequired() {
        return 2;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        if (R1.type == RegisterType.memory && R2.type == RegisterType.memory)
            throw new Exception(getLine() + " can't add data between memory");

        Double a = Converter.convertBitsToDouble(R1.register.getData());
        Double b = Converter.convertBitsToDouble(R2.register.getData());
        R1.register.setData(Converter.convertDoubleToBits(a + b));
    }
}
