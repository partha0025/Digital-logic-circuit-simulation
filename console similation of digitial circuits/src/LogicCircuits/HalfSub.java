package LogicCircuits;

public class HalfSub {
    private int difference;
    private int borrow;

    public HalfSub(int A, int B) throws Exception {
        Gates gates = new Gates();
        this.difference = gates.XOR(A, B);
        this.borrow = (A == 0 && B == 1) ? 1 : 0;
    }

    public int getDifference() {
        return difference;
    }

    public int getBorrow() {
        return borrow;
    }
}
