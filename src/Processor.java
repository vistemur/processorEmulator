import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.*;
import Interpreter.*;
import ProcessorCommands.*;
import ProcessorCommands.Functions.*;
import ProcessorCommands.Jump.*;
import ProcessorCommands.Logic.*;
import ProcessorCommands.Math.*;
import ProcessorCommands.Shift.*;

public class Processor {

    ProcessorRegisters registers = new ProcessorRegisters();
    Memory memory = new Memory(100, registers.system.bdp, registers.system.itp);
    int memoryStartIndex = 50;
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

        public Memory getMemory() {
            return memory;
        }

        public Register getMemoryRegister(int number) throws RegistersException {
            return memory.get(number);
        }
    }),
            new MOV(),
            new ADD(),
            new SUB(),
            new MUL(),
            new DIV(),
            new AND(),
            new OR(),
            new XOR(),
            new SHR(),
            new SHL(),
            new JMP(),
            new JZ(),
            new JNZ(),
            new JE(),
            new JNE(),
            new JG(),
            new JGE(),
            new CALL(),
            new RET()
    );

    public Processor() {

        registers.system.bdp.setData(Converter.convertIntToBits(memoryStartIndex));

        String[] program = new String[] {
                "JMP 3",
                "MOV R0 1",
                "RET",
                "ADD R1 1",
                "CALL 1",
                "ADD R2 1",
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
