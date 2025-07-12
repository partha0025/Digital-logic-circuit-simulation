package LogicCircuits;

public class FullAdder {
    private int sum;
    private int carry;

    public FullAdder(int A, int B, int Cin) throws Exception {
        Gates gates = new Gates();

        int xor1 = gates.XOR(A, B);
        this.sum = gates.XOR(xor1, Cin);

        int and1 = gates.AND(A, B);
        int and2 = gates.AND(xor1, Cin);
        this.carry = gates.OR(and1, and2);
    }

    public int getSum() {
        return sum;
    }

    public int getCarry() {
        return carry;
    }
}
