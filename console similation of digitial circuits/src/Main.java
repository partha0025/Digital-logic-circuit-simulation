import LogicCircuits.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Gates gates = new Gates();

        System.out.println("AND(1, 1): " + gates.AND(1, 1));
        System.out.println("OR(0, 1): " + gates.OR(0, 1));
        System.out.println("NOT(0): " + gates.NOT(0));
        System.out.println("NAND(1, 1): " + gates.NAND(1, 1));
        System.out.println("NOR(0, 0): " + gates.NOR(0, 0));
        System.out.println("XOR(1, 0): " + gates.XOR(1, 0));
        System.out.println("XNOR(1, 1): " + gates.XNOR(1, 1));

        FlipFlop ff = new FlipFlop();

            // SR Flip-Flop
            ff.SR(1, 0);  // Set
            System.out.println("SR Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            ff.SR(0, 1);  // Reset
            System.out.println("SR Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            // D Flip-Flop
            ff.D(1, 1);   // Clocked, D=1
            System.out.println("D Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            ff.D(0, 1);   // Clocked, D=0
            System.out.println("D Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            // JK Flip-Flop
            ff.JK(1, 0, 1); // Set
            System.out.println("JK Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            ff.JK(0, 1, 1); // Reset
            System.out.println("JK Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            ff.JK(1, 1, 1); // Toggle
            System.out.println("JK Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            // T Flip-Flop
            ff.T(1, 1); // Toggle
            System.out.println("T Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());

            ff.T(1, 1); // Toggle again
            System.out.println("T Flip-Flop Output: Q=" + ff.getQ() + ", notQ=" + ff.getNotQ());


        try 
        {
            HalfAdder ha = new HalfAdder(1, 1);
            System.out.println("Sum: " + ha.getSum());
            System.out.println("Carry: " + ha.getCarry());
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        } 

        try {
            HalfSub hs = new HalfSub(1, 0);
            System.out.println("Half Subtractor - Diff: " + hs.getDifference() + ", Borrow: " + hs.getBorrow());

            FullAdder fa = new FullAdder(1, 1, 1);
            System.out.println("Full Adder - Sum: " + fa.getSum() + ", Carry: " + fa.getCarry());

            FullSub fs = new FullSub(0, 1, 1);
            System.out.println("Full Subtractor - Diff: " + fs.getDifference() + ", Borrow: " + fs.getBorrow());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

         int[] inputBits = {1, 1};  // Change as needed
        boolean enableDecoder = true; // Set to false to disable

        Decoder decoder = new Decoder(inputBits, enableDecoder);
        decoder.decode(); 

        int[] input = {0, 0, 0, 0, 0, 0, 0, 1};
        boolean enable = true;

        Encoder encoder = new Encoder(input, enable);
         encoder.encode(); 

         // Test MUX
            int[] muxInputs = {0, 1, 1, 0};
            int[] selector = {1, 0}; // binary 2
            Mux mux = new Mux(muxInputs, selector, true);
            mux.muxOutput();

            // Test DEMUX
            int[] demuxSelector = {1, 1}; // binary 3
            Demux demux = new Demux(1, demuxSelector, true);
            demux.demuxOutput();

    }
}
