package DataHolders.Commands;

import DataHolders.Registers.TypedRegister;

public interface ExecutableCommand {

    public String getLine();
    public int getRegistersRequired();
    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception;
    public default void changeData(CommandData data) throws Exception {
        data.pc.incrementPC();
    }
}
