package DataHolders;

import java.util.BitSet;

public class Converter {

    private static final int bitLen = 64;

    // Byte (8 bit)

    public static BitSet convertByteToBits(byte value) {
        BitSet bitSet = new BitSet(bitLen);

        for (int i = 0; i < Byte.SIZE; i++) {
            bitSet.set(i, ((value >> i) & 1) > 0);
        }
        return bitSet;
    }

    public static byte convertBitsToByte(BitSet bitSet) {
        byte value = 0;
        boolean bit;

        for (int i = 0; i < Integer.SIZE; i++) {
            bit = bitSet.get(i);
            if (bit) {
                value = (byte) (value | (1 << i));
            }
        }
        return value;
    }

    // DByte (16 bit)

    public static BitSet convertShortToBits(short value) {
        BitSet bitSet = new BitSet(bitLen);

        for (int i = 0; i < Short.SIZE; i++) {
            bitSet.set(i, ((value >> i) & 1) > 0);
        }
        return bitSet;
    }

    public static short convertBitsToShort(BitSet bitSet) {
        short value = 0;
        boolean bit;

        for (int i = 0; i < Short.SIZE; i++) {
            bit = bitSet.get(i);
            if (bit) {
                value = (short) (value | (1 << i));
            }
        }
        return value;
    }

    // Int (32 bit)

    public static BitSet convertIntToBits(int value) {
        BitSet bitSet = new BitSet(bitLen);

        for (int i = 0; i < Integer.SIZE; i++) {
            bitSet.set(i, ((value >> i) & 1) > 0);
        }
        return bitSet;
    }

    public static int convertBitsToInt(BitSet bitSet) {
        int value = 0;
        boolean bit;

        for (int i = 0; i < Integer.SIZE; i++) {
            bit = bitSet.get(i);
            if (bit) {
                value = value | (1 << i);
            }
        }
        return value;
    }

    // Long (64 bit)

    public static BitSet convertLongToBits(long value) {
        BitSet bitSet = new BitSet(bitLen);

        for (int i = 0; i < Long.SIZE; i++) {
            bitSet.set(i, ((value >> i) & 1) > 0);
        }
        return bitSet;
    }

    public static long convertBitsToLong(BitSet bitSet) {
        long value = 0;
        boolean bit;

        for (int i = 0; i < Long.SIZE; i++) {
            bit = bitSet.get(i);
            if (bit) {
                value = value | (1L << i);
            }
        }
        return value;
    }
}
