package LogicCircuits;

public class Encoder {

    private int[] input;
    private boolean enable;

    public Encoder(int[] input, boolean enable) {
        this.input = input;
        this.enable = enable;
    }

    // Input should be binary (0 or 1)
    public boolean inputVerify() {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0 && input[i] != 1) {
                return false;
            }
        }
        return true;
    }

    // Encode method
    public void encode() throws Exception {
        if (!inputVerify()) {
            throw new Exception("Invalid input: Inputs must be binary (0 or 1)");
        }

        int n = input.length;

        if (!enable) {
            System.out.println("Encoder is disabled.");
            return;
        }

        int outputBits = (int)(Math.log(n) / Math.log(2));
        int[] output = new int[outputBits];

        int activeIndex = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (input[i] == 1) {
                activeIndex = i;
                break;
            }
        }

        if (activeIndex == -1) {
            System.out.println("No active input found (all zeros).");
            return;
        }

        for (int i = 0; i < outputBits; i++) {
            output[outputBits - 1 - i] = (activeIndex >> i) & 1;
        }

        System.out.print("Encoded output (Y" + (outputBits - 1) + " to Y0): ");
        for (int bit : output) {
            System.out.print(bit);
        }
        System.out.println();
    }
}
