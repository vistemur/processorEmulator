package DataHolders.Commands;

import DataHolders.Registers.Register;
import DataHolders.Registers.TypedRegister;

public interface ExecutableCommand {
    public String getLine();
    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3);
    public default boolean increasePC() {
        return true;
    }
}
