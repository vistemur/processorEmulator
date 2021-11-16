package DataHolders.Registers;

import DataHolders.Converter;

public class SystemRegisters {

    public CounterRegister pc = new CounterRegister();
    public FlagsRegister flagsRegister = new FlagsRegister("U", "T", "I", "O", "S", "C", "Z");
    public Register ptp = new Register();
    public Register itp = new Register();
    public Register bva = new Register();
    public Register bdp = new Register();
}
