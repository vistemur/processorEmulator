package ProcessorCommands.Convert;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.TypedRegister;

public class LTD implements ExecutableCommand {

    public String getLine() {
        return "LTD";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        long dValue = Converter.convertBitsToLong(R1.register.getData());
        double lValue = (double) dValue;
        R1.register.setData(Converter.convertDoubleToBits(lValue));
    }
}
