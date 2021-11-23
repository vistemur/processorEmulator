package DataHolders.Registers;

public class TypedRegister {

    public Register register;
    public RegisterType type;

    public TypedRegister(Register register, RegisterType type) {
        this.register = register;
        this.type = type;
    }
}
