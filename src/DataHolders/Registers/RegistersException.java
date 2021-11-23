package DataHolders.Registers;

public class RegistersException extends Exception {

    public RegistersException(int amount, int number) {
        super("Error \"unable to get register" +
                "\nregister address = " + number +
                "\ntotal registers amount = " + amount);
    }
}
