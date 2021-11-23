package Interpreter;

import DataHolders.Converter;
import DataHolders.Registers.Register;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.TypedRegister;

public class InterpreterRegisters {

    RegistersForInterpreter registers;

    public InterpreterRegisters(RegistersForInterpreter registers) {
        this.registers = registers;
    }

    public TypedRegister getRegister(String text) throws Exception {
        String[] splitedText = text.split("\\[");

        if (splitedText.length > 1) {
            int offset = getOffset(splitedText[1]);
            String indexText = splitedText[1].substring(0, splitedText[1].length() - 1);
            return new TypedRegister(getMemoryIndex(offset, indexText), RegisterType.memory);
        } else {
            return new TypedRegister(getSystemRegister(splitedText[0]), RegisterType.register);
        }
    }

    private int getOffset(String text) {
        try {
            Register startRegister = getSystemRegister(text);
            return Converter.convertBitsToInt(startRegister.getData());
        } catch (Exception ignored) {
            return 0;
        }
    }

    private Register getSystemRegister(String text) throws Exception {
        if (text.startsWith("R")) {
            int number = Integer.parseInt(text.substring(1));
            return registers.getPoh(number);
        } else if (text.equals("PC")) {
            return registers.getPc();
        }
        throw new Exception("unable to find register " + text);
    }
    private Register getMemoryIndex(int offset, String text) throws Exception {
        int memoryStart = Converter.convertBitsToInt(registers.getBdp().getData());
        int memoryIndex;

        if (text.charAt(0) >= '0' && text.charAt(0) <= '9') {
            memoryIndex = Integer.parseInt(text);
        } else {
            memoryIndex = getOffset(text);
        }
        return registers.getMemoryRegister(memoryStart + offset + memoryIndex);
    }
}
