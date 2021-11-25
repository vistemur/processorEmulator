package ProcessorCommands.Convert;

import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.TypedRegister;

public class DTL implements ExecutableCommand {

    public String getLine() {
        return "DTL";
    }

    public int getRegistersRequired() {
        return 1;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        double dValue = Converter.convertBitsToDouble(R1.register.getData());
        long lValue = Double.valueOf(dValue).longValue();
        R1.register.setData(Converter.convertLongToBits(lValue));
    }
}
