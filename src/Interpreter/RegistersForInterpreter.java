package Interpreter;

import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.Register;
import DataHolders.Registers.RegistersException;

public interface RegistersForInterpreter {

    public Register getPoh(int number) throws RegistersException;
    public CounterRegister getPc();
    public Register getPtp();
    public Register getIta();
    public Register getBva();
    public Register getBdp();
    public Register getFlagsRegister();
    public Memory getMemory();
}
