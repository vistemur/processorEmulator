package DataHolders.Commands;

import DataHolders.Memory.Memory;
import DataHolders.Registers.CounterRegister;
import DataHolders.Registers.TypedRegister;

public class Command {

    private final TypedRegister R1, R2, R3;
    private final ExecutableCommand command;
    private final CommandData data;

    public Command(ExecutableCommand command,
                   TypedRegister R1,
                   TypedRegister R2,
                   TypedRegister R3,
                   CommandData data) {
        this.command = command;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.data = data;
    }

    public void execute() throws Exception {
        command.execute(R1, R2, R3);
        command.changeData(data);
    }
}
