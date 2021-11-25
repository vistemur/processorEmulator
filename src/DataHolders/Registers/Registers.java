package DataHolders.Registers;

public class Registers {

    protected int amount;
    protected Register[] registers;

    public Registers() {
        setRegistersAmount(8);
    }

    public Registers(int amount) {
        setRegistersAmount(amount);
    }

    public Register getRegister(int number) throws RegistersException {
        if (number < amount && number >= 0)
            return registers[number];
        throw new RegistersException(amount, number);
    }

    public int getRegistersAmount() {
        return amount;
    }

    protected void setRegistersAmount(int amount) {
        this.amount = amount;
        registers = new Register[amount];
        for (int i = 0; i < amount; i++)
            registers[i] = new Register();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("DataHolders.DataHolders.Registers.Registers.Registers {\n");
        for (int i = 0; i < amount; i++) {
            stringBuilder.append(i);
            stringBuilder.append(" : ");
            stringBuilder.append(registers[i]);
            stringBuilder.append('\n');
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
