package DataHolders.Registers;

public class FlagsRegister extends Register {

    private final String[] flagNames;

    public FlagsRegister(String ... flagNames) {
        this.flagNames = flagNames;
    }

    public void setFlag(String name, boolean value) throws Exception {
        for (int bitNumber = 0; bitNumber < flagNames.length; bitNumber++)
            if (flagNames[bitNumber].equalsIgnoreCase(name)) {
                getData().set(bitNumber, value);
                return;
            }
        throw new Exception("unable to set flag\nno flag named " + name);
    }

    public boolean getFlag(String name) throws Exception {
        for (int bitNumber = 0; bitNumber < flagNames.length; bitNumber++)
            if (flagNames[bitNumber].equalsIgnoreCase(name))
                return getData().get(bitNumber);
        throw new Exception("unable to get flag\nno flag named " + name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("FlagsRegister {\n");
        for (int bitNumber = 0; bitNumber < flagNames.length; bitNumber++) {
            String name = flagNames[bitNumber];
            stringBuilder.append(name);
            stringBuilder.append(" : ");
            stringBuilder.append(getData().get(bitNumber));
            stringBuilder.append('\n');
        }
        stringBuilder.append(super.toString());
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}
