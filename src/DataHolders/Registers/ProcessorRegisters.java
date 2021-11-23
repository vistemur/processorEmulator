package DataHolders.Registers;

public class ProcessorRegisters {
    public SystemRegisters system = new SystemRegisters();
    public Registers poh = new Registers(8);

    @Override
    public String toString() {
        return "ProcessorRegisters{" +
                "\nsystem=" + system +
                "\npoh=" + poh +
                '}';
    }
}
