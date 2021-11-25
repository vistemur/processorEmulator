import DataHolders.Converter;
import DataHolders.Memory.Memory;
import DataHolders.Registers.*;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();
    }

    private static void testMemory() {
        Memory memory = new Memory(100, new Register(), new Register());
        Register register = new Register();

        try {
            memory.set(1, Converter.convertIntToBits(15));
            memory.set(2, Converter.convertIntToBits(6));
            memory.set(3, Converter.convertIntToBits(-1));
            register.setData(memory.get(1).getData());
            System.out.println(register);
            register.setData(memory.get(2).getData());
            System.out.println(register);
            register.setData(memory.get(3).getData());
            System.out.println(register);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testFlagsRegister() {
        FlagsRegister flagsRegister = new FlagsRegister("U", "T", "I", "O", "S", "C", "Z");

        try {
            flagsRegister.setFlag("u", true);
            flagsRegister.setFlag("t", true);
            flagsRegister.setFlag("I", true);
            flagsRegister.setFlag("O", false);
            flagsRegister.setFlag("s", true);
            flagsRegister.setFlag("i", false);
            flagsRegister.setFlag("z", true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(flagsRegister);

        try {
            boolean zFlag = flagsRegister.getFlag("Z");
            System.out.println("Z = " + zFlag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testConverter() {
        Registers registers = new Registers(8);

        try {
            System.out.println("\nLong");

            registers.getRegister(0).setData(Converter.convertLongToBits(1L));
            registers.getRegister(1).setData(Converter.convertLongToBits(2L));
            registers.getRegister(2).setData(Converter.convertLongToBits(3L));
            registers.getRegister(3).setData(Converter.convertLongToBits(Long.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertLongToBits(-1L));
            registers.getRegister(5).setData(Converter.convertLongToBits(-2L));
            registers.getRegister(6).setData(Converter.convertLongToBits(-3L));
            registers.getRegister(7).setData(Converter.convertLongToBits(-4L));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToLong(registers.getRegister(registerNumber).getData()));

            System.out.println("\nDouble");

            registers.getRegister(0).setData(Converter.convertDoubleToBits(1.0));
            registers.getRegister(1).setData(Converter.convertDoubleToBits(2.0));
            registers.getRegister(2).setData(Converter.convertDoubleToBits(3.0));
            registers.getRegister(3).setData(Converter.convertDoubleToBits(Double.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertDoubleToBits(-1.0));
            registers.getRegister(5).setData(Converter.convertDoubleToBits(-2.0));
            registers.getRegister(6).setData(Converter.convertDoubleToBits(-3.0));
            registers.getRegister(7).setData(Converter.convertDoubleToBits(-4.0));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToDouble(registers.getRegister(registerNumber).getData()));

            System.out.println("\nInt");

            registers.getRegister(0).setData(Converter.convertIntToBits(1));
            registers.getRegister(1).setData(Converter.convertIntToBits(2));
            registers.getRegister(2).setData(Converter.convertIntToBits(3));
            registers.getRegister(3).setData(Converter.convertIntToBits(Integer.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertIntToBits(-1));
            registers.getRegister(5).setData(Converter.convertIntToBits(-2));
            registers.getRegister(6).setData(Converter.convertIntToBits(-3));
            registers.getRegister(7).setData(Converter.convertIntToBits(-4));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToInt(registers.getRegister(registerNumber).getData()));

            System.out.println("\nFloat");

            registers.getRegister(0).setData(Converter.convertFloatToBits(1.0f));
            registers.getRegister(1).setData(Converter.convertFloatToBits(2.0f));
            registers.getRegister(2).setData(Converter.convertFloatToBits(3.0f));
            registers.getRegister(3).setData(Converter.convertFloatToBits(Float.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertFloatToBits(-1.0f));
            registers.getRegister(5).setData(Converter.convertFloatToBits(-2.0f));
            registers.getRegister(6).setData(Converter.convertFloatToBits(-3.0f));
            registers.getRegister(7).setData(Converter.convertFloatToBits(-4.0f));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToFloat(registers.getRegister(registerNumber).getData()));

            System.out.println("\nShort");

            registers.getRegister(0).setData(Converter.convertShortToBits((short) 1));
            registers.getRegister(1).setData(Converter.convertShortToBits((short) 2));
            registers.getRegister(2).setData(Converter.convertShortToBits((short) 3));
            registers.getRegister(3).setData(Converter.convertShortToBits(Short.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertShortToBits((short) -1));
            registers.getRegister(5).setData(Converter.convertShortToBits((short) -2));
            registers.getRegister(6).setData(Converter.convertShortToBits((short) -3));
            registers.getRegister(7).setData(Converter.convertShortToBits((short) -4));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToShort(registers.getRegister(registerNumber).getData()));

            System.out.println("\nByte");

            registers.getRegister(0).setData(Converter.convertByteToBits((byte) 1));
            registers.getRegister(1).setData(Converter.convertByteToBits((byte) 2));
            registers.getRegister(2).setData(Converter.convertByteToBits((byte) 3));
            registers.getRegister(3).setData(Converter.convertByteToBits(Byte.MAX_VALUE));
            registers.getRegister(4).setData(Converter.convertByteToBits((byte) -1));
            registers.getRegister(5).setData(Converter.convertByteToBits((byte) -2));
            registers.getRegister(6).setData(Converter.convertByteToBits((byte) -3));
            registers.getRegister(7).setData(Converter.convertByteToBits((byte) -4));
            System.out.println(registers);

            for (int registerNumber = 0; registerNumber < registers.getRegistersAmount(); registerNumber++)
                System.out.println(Converter.convertBitsToByte(registers.getRegister(registerNumber).getData()));
        } catch (RegistersException e) {
            System.out.println(e.getMessage());
        }
    }
}