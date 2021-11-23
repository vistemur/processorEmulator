package DataHolders.Commands;

import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.Register;
import DataHolders.Registers.TypedRegister;

public class Command {

    private String line;
    private final CounterRegister pc;
    private final TypedRegister R1, R2, R3;
    private final ExecutableCommand command;

    public Command(String line, ExecutableCommand command, TypedRegister R1, TypedRegister R2, TypedRegister R3, CounterRegister pc) {
        this(command, R1, R2, R3, pc);
        this.line = line;
    }

    public Command(ExecutableCommand command, TypedRegister R1, TypedRegister R2, TypedRegister R3, CounterRegister pc) {
        this.command = command;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.pc = pc;
    }

    public void execute() {
        command.execute(R1, R2, R3);
        if (command.increasePC())
            pc.incrementPC();
    }
}
