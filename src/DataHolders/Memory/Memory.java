package DataHolders.Memory;

import DataHolders.Registers.Register;
import DataHolders.Registers.Registers;
import DataHolders.Registers.RegistersException;

import java.util.BitSet;

public class Memory {

    private Registers data;

    public Memory() {
        this(1024);
    }

    public Memory(int size) {
        data = new Registers(size);
    }

    public Register get(int address) throws RegistersException {
        return this.data.getRegister(address);
    }

    public void set(int address, BitSet data) throws RegistersException {
        Register destination = this.data.getRegister(address);

        destination.setData(data);
    }
}
