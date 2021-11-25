package DataHolders.Registers;

import DataHolders.Converter;

import java.util.ArrayList;

public class CounterRegister extends Register {

    ArrayList<SavedPosition> savedPositions = new ArrayList<SavedPosition>();

    public void setPC(long value) {
        setData(Converter.convertLongToBits(value));
    }

    public void incrementPC() {
        long currentPC = Converter.convertBitsToLong(getData());
        setData(Converter.convertLongToBits(currentPC + 1L));
    }

    public void save(String name) {
        try {
            getPosition(name);
        } catch (Exception e) {
            SavedPosition savedPosition = new SavedPosition(Converter.convertBitsToInt(getData()), name.toLowerCase());
            savedPositions.add(savedPosition);
        }
    }

    public int getPosition(String name) throws Exception {
        String nameLow = name.toLowerCase();
        for (SavedPosition savedPosition : savedPositions)
            if (nameLow.equals(savedPosition.name))
                return savedPosition.position;
        throw new Exception("no position named " + name);
    }

    private static class SavedPosition {

        int position;
        String name;

        SavedPosition(int position, String name) {
            this.position = position;
            this.name = name;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());
        stringBuilder.append("saved positions {");
        for (SavedPosition savedPosition : savedPositions) {
            stringBuilder.append("\n");
            stringBuilder.append(savedPosition.name);
            stringBuilder.append(" : ");
            stringBuilder.append(savedPosition.position);
        }
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}
