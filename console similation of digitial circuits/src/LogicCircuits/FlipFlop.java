package LogicCircuits;

public class FlipFlop {
    private int Q = 0;
    private int notQ = 1;

    // Utility validation
    private void validate(int... inputs) throws Exception {
        for (int input : inputs) {
            if (input != 0 && input != 1)
                throw new Exception("Invalid input: only 0 or 1 allowed.");
        }
    }

    // ✅ SR Flip-Flop
    public void SR(int S, int R) throws Exception {
        validate(S, R);
        if (S == 1 && R == 1)
            throw new Exception("Invalid state for SR Flip-Flop: S=1, R=1");

        if (S == 1 && R == 0) {
            Q = 1;
            notQ = 0;
        } else if (S == 0 && R == 1) {
            Q = 0;
            notQ = 1;
        }

    }

    // ✅ D Flip-Flop (edge-triggered)
    public void D(int D, int clock) throws Exception {
        validate(D, clock);
        if (clock == 1) {
            Q = D;
            notQ = (D == 1) ? 0 : 1;
        }
    }

    // ✅ JK Flip-Flop
    public void JK(int J, int K, int clock) throws Exception {
        validate(J, K, clock);
        if (clock == 1) {
            if (J == 0 && K == 0) {
                // hold
            } else if (J == 0 && K == 1) {
                Q = 0;
                notQ = 1;
            } else if (J == 1 && K == 0) {
                Q = 1;
                notQ = 0;
            } else { // toggle
                Q = (Q == 1) ? 0 : 1;
                notQ = (Q == 1) ? 0 : 1;
            }
        }
    }

    // ✅ T Flip-Flop
    public void T(int T, int clock) throws Exception {
        validate(T, clock);
        if (clock == 1 && T == 1) {
            Q = (Q == 1) ? 0 : 1;
            notQ = (Q == 1) ? 0 : 1;
        }
        // else hold
    }

    // Accessors
    public int getQ() { return Q; }
    public int getNotQ() { return notQ; }
}

