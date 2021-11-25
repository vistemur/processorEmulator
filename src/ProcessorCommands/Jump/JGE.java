package ProcessorCommands.Jump;

import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.TypedRegister;

public class JGE implements ExecutableCommand {

    private long jump = -1;
    private boolean needsToJump = false;

    public String getLine() {
        return "JGE";
    }

    public int getRegistersRequired() {
        return 3;
    }

    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception {
        needsToJump = Converter.convertBitsToLong(R2.register.getData()) >= Converter.convertBitsToLong(R3.register.getData());
        jump = Converter.convertBitsToLong(R1.register.getData());
    }

    public void changeData(CommandData data) throws Exception {
        if (needsToJump) {
            if (jump > -1)
                data.pc.setData(Converter.convertLongToBits(jump));
            else
                throw new Exception(getLine() + " can't jump to negative values");
        } else {
            ExecutableCommand.super.changeData(data);
        }
        needsToJump = false;
    }
}
