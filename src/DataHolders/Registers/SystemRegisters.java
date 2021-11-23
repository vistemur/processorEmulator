package DataHolders.Registers;

public class SystemRegisters {

    public CounterRegister pc = new CounterRegister();
    public FlagsRegister flagsRegister = new FlagsRegister("U", "T", "I", "O", "S", "C", "Z");
    public Register ptp = new Register();
    public Register itp = new Register();
    public Register bva = new Register();
    public Register bdp = new Register();

    @Override
    public String toString() {
        return "SystemRegisters{" +
                "\npc=" + pc +
                "\nflagsRegister=" + flagsRegister +
                "\nptp=" + ptp +
                "\nitp=" + itp +
                "\nbva=" + bva +
                "\nbdp=" + bdp +
                "\n}";
    }
}
