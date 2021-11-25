package DataHolders.Commands;

import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.TypedRegister;

public interface ExecutableCommand {

    public String getLine();
    public int getRegistersRequired();
    public void execute(TypedRegister R1, TypedRegister R2, TypedRegister R3) throws Exception;
    public default void changeData(CounterRegister pc, Memory memory) throws Exception {
        pc.incrementPC();
    }
}
