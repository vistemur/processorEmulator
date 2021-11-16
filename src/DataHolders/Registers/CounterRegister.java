package DataHolders.Registers;

import DataHolders.Converter;

public class CounterRegister extends Register {

    public void setPC(long value) {
        setData(Converter.convertLongToBits(value));
    }

    public void incrementPC() {
        long currentPC = Converter.convertBitsToLong(getData());
        setData(Converter.convertLongToBits(currentPC + 1L));
    }
}
