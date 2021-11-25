package DataHolders.Memory;

import DataHolders.Converter;
import DataHolders.Registers.Register;
import DataHolders.Registers.Registers;
import DataHolders.Registers.RegistersException;

import java.util.BitSet;

public class Memory {

    private final Registers data;
    private final int maxStackSize = 50;
    Register userMemoryStart, lastFunctionCall;

    public Memory(int size, Register userMemoryStart, Register lastFunctionCall) {
        this.userMemoryStart = userMemoryStart;
        this.lastFunctionCall = lastFunctionCall;
        data = new Registers(size);

        int memoryStart = size / 2;
        if (memoryStart > maxStackSize)
            memoryStart = maxStackSize;
        userMemoryStart.setData(Converter.convertIntToBits(memoryStart));
        lastFunctionCall.setData(Converter.convertIntToBits(memoryStart));
    }

    public Register get(int address) throws RegistersException {
        return this.data.getRegister(address);
    }

    public void set(int address, BitSet data) throws RegistersException {
        Register destination = this.data.getRegister(address);

        destination.setData(data);
    }

    public int push(BitSet value) throws RegistersException {
        int lastFunctionCallData = Converter.convertBitsToInt(lastFunctionCall.getData());

        lastFunctionCallData -= 1;
        lastFunctionCall.setData(Converter.convertIntToBits(lastFunctionCallData));
        data.getRegister(lastFunctionCallData).setData(value);
        return lastFunctionCallData;
    }

    public Register pop() throws RegistersException {
        int lastFunctionCallData = Converter.convertBitsToInt(lastFunctionCall.getData());
        Register answer;

        answer = data.getRegister(lastFunctionCallData);
        lastFunctionCallData += 1;
        lastFunctionCall.setData(Converter.convertIntToBits(lastFunctionCallData));
        return answer;
    }
}
