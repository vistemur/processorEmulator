package Interpreter;

public class InterpreterException extends Exception {

    private String message;
    public InterpreterException(int line, String message) {
        this.message = "Error on line " + line + '\n' + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
