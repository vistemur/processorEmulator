package DataHolders.Registers;

import java.util.BitSet;

public class Register {

    private BitSet data = new BitSet(64);

    public void setData(BitSet data) {
        this.data = data;
    }

    public BitSet getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 63; i >= 0; i--) {
            stringBuilder.append(data.get(i) ? 1 : 0);
        }
        return stringBuilder.toString();
    }
}
