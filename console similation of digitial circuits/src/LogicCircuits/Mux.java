package LogicCircuits;

public class Mux {

    private int[] inputs;
    private int[] selector;
    private boolean enable;

    public Mux(int[] inputs, int[] selector, boolean enable) {
        this.inputs = inputs;
        this.selector = selector;
        this.enable = enable;
    }

   
    public boolean inputVerify() {
        for (int i : inputs) {
            if (i != 0 && i != 1) return false;
        }
        for (int s : selector) {
            if (s != 0 && s != 1) return false;
        }
        return true;
    }


    private int getSelectedIndex() {
        int index = 0;
        int n = selector.length;
        for (int i = 0; i < n; i++) {
            index += selector[i] * Math.pow(2, n - 1 - i);
        }
        return index;
    }

    public void muxOutput() throws Exception {
        if (!inputVerify()) {
            throw new Exception("Invalid binary input or selector");
        }

        if (!enable) {
            System.out.println("MUX is disabled.");
            return;
        }

        int selectedIndex = getSelectedIndex();

        if (selectedIndex >= inputs.length) {
            System.out.println("Selector index out of bounds for input lines.");
            return;
        }

        System.out.println("Selected input (D" + selectedIndex + ") = " + inputs[selectedIndex]);
    }
}
