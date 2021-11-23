import DataHolders.Commands.ExecutableCommand;
import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.*;
import Interpreter.*;
import ProcessorCommands.MOV;

import java.lang.reflect.Executable;

public class Processor {

    ProcessorRegisters registers = new ProcessorRegisters();
    Memory memory = new Memory(100);
    Interpreter interpreter = new Interpreter(new InterpreterRegisters(new RegistersForInterpreter() {

        public Register getPoh(int number) throws RegistersException {
            return registers.poh.getRegister(number);
        }

        public CounterRegister getPc() {
            return registers.system.pc;
        }

        public Register getPtp() {
            return registers.system.ptp;
        }

        public Register getIta() {
            return registers.system.bdp;
        }

        public Register getBva() {
            return registers.system.bva;
        }

        public Register getBdp() {
            return registers.system.bdp;
        }

        public Register getFlagsRegister() {
            return registers.system.flagsRegister;
        }

        public Register getMemoryRegister(int number) throws RegistersException {
            return memory.get(number);
        }
    }),
            new MOV());

    public Processor() {

        String[] program = new String[] {
                "MOV R0 7",
                "MOV R1 R0",
                "MOV [0] 15",
                "MOV R0 [0]",
                "MOV R1[R0] R0",
                "MOV R2 R1[R0]",
        };

        interpreter.loadProgram(program);
        try {
            interpreter.run();
            System.out.println(registers);
        } catch (InterpreterException e) {
            System.out.println(e.getMessage());
        }
    }
}
