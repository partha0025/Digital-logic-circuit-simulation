package LogicCircuits;

public class FullSub {
    private int difference;
    private int borrow;

    public FullSub(int A, int B, int Bin) throws Exception {
        Gates gates = new Gates();

        int xor1 = gates.XOR(A, B);
        this.difference = gates.XOR(xor1, Bin);

        int notA = gates.NOT(A);
        int and1 = gates.AND(notA, B);
        int and2 = gates.AND(gates.NOT(xor1), Bin);
        this.borrow = gates.OR(and1, and2);
    }

    public int getDifference() {
        return difference;
    }

    public int getBorrow() {
        return borrow;
    }
}
