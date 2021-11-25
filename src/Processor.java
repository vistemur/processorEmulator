import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.*;
import Interpreter.*;
import ProcessorCommands.*;
import ProcessorCommands.Convert.*;
import ProcessorCommands.Functions.*;
import ProcessorCommands.InOut.*;
import ProcessorCommands.Jump.*;
import ProcessorCommands.Logic.*;
import ProcessorCommands.Math.*;
import ProcessorCommands.Shift.*;
import ProcessorIO.Console.*;
import ProcessorIO.ProcessorStreams;

public class Processor {

    ProcessorRegisters registers = new ProcessorRegisters();
    ProcessorStreams streams = new ProcessorStreams();
    Memory memory = new Memory(100, registers.system.bdp, registers.system.itp);
    int stackSize = 50;

    Interpreter interpreter = new Interpreter(
            new InterpreterRegisters(
                    new RegistersForInterpreter() {

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
                    }
            ),
            streams,
            new MOV(),
            new ADD(),
            new SUB(),
            new MUL(),
            new DIV(),
            new DADD(),
            new DSUB(),
            new DMUL(),
            new DDIV(),
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
            new RET(),
            new NOP(),
            new LTD(),
            new DTL(),
            new IN(),
            new OUT()
    );

    public Processor() {
        registers.system.bdp.setData(Converter.convertIntToBits(stackSize));
    }
}
