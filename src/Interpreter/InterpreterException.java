package Interpreter;

public class InterpreterException extends Exception {

    private String message;
    public InterpreterException(int lineNumber, String line, String message) {
        this.message = "Error on line " + lineNumber + '\n' + line + '\n' + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
