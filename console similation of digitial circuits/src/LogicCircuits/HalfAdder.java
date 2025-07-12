package LogicCircuits;

public class HalfAdder {
    private int sum = 0;
    private int carry = 0;

    public HalfAdder(int input1, int input2) throws Exception {
        Gates gates = new Gates(); // using your previous Gates class
        this.sum = gates.XOR(input1, input2);   // Sum = A ⊕ B
        this.carry = gates.AND(input1, input2); // Carry = A ∧ B
    }

    public int getSum() {
        return sum;
    }

    public int getCarry() {
        return carry;
    }
}
