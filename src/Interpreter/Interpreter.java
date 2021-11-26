package Interpreter;

import DataHolders.Commands.Command;
import DataHolders.Commands.CommandData;
import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Registers.*;
import ProcessorIO.ProcessorStreams;

import java.util.BitSet;

public class Interpreter {

    private final ExecutableCommand[] executableCommands;
    private final ProcessorStreams processorStreams;
    private final InterpreterRegisters interpreterRegisters;
    private String[] program;

    public Interpreter(InterpreterRegisters interpreterRegisters, ProcessorStreams processorStreams, ExecutableCommand ... executableCommands) {
        this.interpreterRegisters = interpreterRegisters;
        this.processorStreams = processorStreams;
        this.executableCommands = executableCommands;
    }

    public void loadProgram(String[] program) {
        this.program = program;
        fillCP();
    }

    private void fillCP() {
        CounterRegister pc = interpreterRegisters.registers.getPc();
        BitSet pcSave = pc.getData();

        while (Converter.convertBitsToInt(pc.getData()) < program.length) {
            int pcData = Converter.convertBitsToInt(pc.getData());
            if (program[pcData].charAt(0) == '_')
                pc.save(program[pcData].split(" ")[0].toUpperCase());
            pc.incrementPC();
        }
        pc.setData(pcSave);
    }

    public void run() throws InterpreterException {
        Register pc = interpreterRegisters.registers.getPc();

        while (Converter.convertBitsToInt(pc.getData()) < program.length) {
            runNextCommand();
        }
    }

    public void runNextCommand() throws InterpreterException {
        Register pc = interpreterRegisters.registers.getPc();
        int pcData = Converter.convertBitsToInt(pc.getData());

        try {
            Command command = getCommand(program[pcData]);
            command.execute();
        } catch (Exception e) {
            throw new InterpreterException(pcData, program[pcData], e.getMessage());
        }
    }

    private Command getCommand(String line) throws InterpreterException {
        String[] words = line.split(" ");
        TypedRegister[] R = new TypedRegister[3];

        ExecutableCommand executableCommand = getExecutableCommand(words[0].toUpperCase());
        for (int registerNumber = 0; registerNumber < words.length - 1 && registerNumber < 3 && registerNumber < executableCommand.getRegistersRequired(); registerNumber++) {
            R[registerNumber] = getRegister(words[registerNumber + 1]);
        }
        CommandData commandData = new CommandData(  interpreterRegisters.registers.getPc(),
                                                    interpreterRegisters.registers.getMemory(),
                                                    processorStreams);
        return new Command
                (
                        executableCommand,
                        R[0],
                        R[1],
                        R[2],
                        commandData
                );
    }

    private ExecutableCommand getExecutableCommand(String name) throws InterpreterException {
        CounterRegister pc = interpreterRegisters.registers.getPc();

        if (name.charAt(0) == '_') {
            pc.save(name);
            return getExecutableCommand("NOP");
        }

        for (ExecutableCommand command : executableCommands) {
            if (command.getLine().equals(name)) {
                return command;
            }
        }
        int pcData = Converter.convertBitsToInt(pc.getData());
        throw new InterpreterException(pcData, program[pcData], "unable to find command " + name);
    }

    private TypedRegister getRegister(String name) throws InterpreterException {
        char firstChar = name.charAt(0);

        if (firstChar == '\'') {
            return new TypedRegister(getRegisterFromChar(name), RegisterType.value);
        } else if (name.contains("[")) {
            return new TypedRegister(getMemory(name), RegisterType.memory);
        } else if (firstChar == '_') {
            return new TypedRegister(getSavedValue(name), RegisterType.value);
        } else if ((firstChar >= '0' && firstChar <= '9' || firstChar <= '-')) {
            return new TypedRegister(getNumber(name), RegisterType.value);
        } else {
            return new TypedRegister(getSystemRegister(name), RegisterType.register);
        }
    }

    private Register getRegisterFromChar(String name) {
        Register answer = new Register();
        answer.setData(Converter.convertByteToBits((byte) name.charAt(1)));
        return answer;
    }

    private Register getMemory(String text) throws  InterpreterException {
        try {
            return interpreterRegisters.getMemory(text.toUpperCase());
        } catch (Exception e) {
            int pcData = Converter.convertBitsToInt(interpreterRegisters.registers.getPc().getData());
            throw new InterpreterException(pcData, program[pcData], e.getMessage());
        }
    }

    private Register getSavedValue(String text) throws  InterpreterException {
        try {
            return interpreterRegisters.getSavedValue(text.toUpperCase());
        } catch (Exception e) {
            int pcData = Converter.convertBitsToInt(interpreterRegisters.registers.getPc().getData());
            throw new InterpreterException(pcData, program[pcData], e.getMessage());
        }
    }

    private Register getNumber(String text) {
        if (text.contains("."))
            return getRegisterFromDouble(text);
        else
            return getRegisterFromLong(text);
    }

    private Register getSystemRegister(String text) throws  InterpreterException {
        try {
            return interpreterRegisters.getSystemRegister(text.toUpperCase());
        } catch (Exception e) {
            int pcData = Converter.convertBitsToInt(interpreterRegisters.registers.getPc().getData());
            throw new InterpreterException(pcData, program[pcData], e.getMessage());
        }
    }

    private Register getRegisterFromLong(String name) {
        Register answer = new Register();
        answer.setData(Converter.convertLongToBits(Long.parseLong(name)));
        return answer;
    }

    private Register getRegisterFromDouble(String name) {
        Register answer = new Register();
        answer.setData(Converter.convertDoubleToBits(Double.parseDouble(name)));
        return answer;
    }
}
