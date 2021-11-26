package Interpreter;

import DataHolders.Converter;
import DataHolders.Registers.Register;
import DataHolders.Registers.RegisterType;
import DataHolders.Registers.RegistersException;
import DataHolders.Registers.TypedRegister;

public class InterpreterRegisters {

    RegistersForInterpreter registers;

    public InterpreterRegisters(RegistersForInterpreter registers) {
        this.registers = registers;
    }

    public Register getMemory(String text) throws Exception {
        String[] splitedText = text.split("\\[");
        int offset = getOffset(splitedText[0]);
        String indexText = splitedText[1].substring(0, splitedText[1].length() - 1);
        return getMemoryIndex(offset, indexText);
    }

    public Register getSavedValue(String text) throws Exception {
        Register answer = new Register();
        int savedValue = registers.getPc().getPosition(text);

        answer.setData(Converter.convertIntToBits(savedValue));
        return answer;
    }

    public Register getSystemRegister(String text) throws Exception {
        if (text.startsWith("R")) {
            int number = Integer.parseInt(text.substring(1));
            return registers.getPoh(number);
        } else if (text.equals("PC")) {
            return registers.getPc();
        }
        throw new Exception("unable to find register " + text);
    }

    private int getOffset(String text) {
        if (text.length() > 0 && (text.charAt(0) >= '0' && text.charAt(0) <= '9' || text.charAt(0) == '-'))
            return Integer.parseInt(text);
        try {
            Register startRegister = getSystemRegister(text);
            return Converter.convertBitsToInt(startRegister.getData());
        } catch (Exception e) {
            return 0;
        }
    }

    private Register getMemoryIndex(int offset, String text) throws Exception {
        int memoryStart = Converter.convertBitsToInt(registers.getBdp().getData());
        int memoryIndex = getOffset(text);

        try {
            return registers.getMemory().get(memoryStart + offset + memoryIndex);
        } catch (RegistersException e) {
            throw new Exception(e.getMessage() + "\nbdp (user memory start index) = " + memoryStart);
        }
    }
}
