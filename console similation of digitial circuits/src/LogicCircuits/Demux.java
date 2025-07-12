package LogicCircuits;

public class Demux {

    private int input;
    private int[] selector;
    private boolean enable;

    public Demux(int input, int[] selector, boolean enable) {
        this.input = input;
        this.selector = selector;
        this.enable = enable;
    }

    public boolean inputVerify() {
        return input == 0 || input == 1 && selector != null && selector.length > 0 &&
               java.util.Arrays.stream(selector).allMatch(s -> s == 0 || s == 1);
    }

    
    private int getSelectedIndex() {
        int index = 0;
        int n = selector.length;
        for (int i = 0; i < n; i++) {
            index += selector[i] * Math.pow(2, n - 1 - i);
        }
        return index;
    }

    public void demuxOutput() throws Exception {
        if (!inputVerify()) {
            throw new Exception("Invalid input or selector bits");
        }

        if (!enable) {
            System.out.println("DEMUX is disabled.");
            return;
        }

        int outputLines = (int) Math.pow(2, selector.length);
        int[] outputs = new int[outputLines];
        int selectedIndex = getSelectedIndex();

        outputs[selectedIndex] = input;

       
        System.out.print("DEMUX Output Lines: ");
        for (int i = 0; i < outputs.length; i++) {
            System.out.print("Y" + i + "=" + outputs[i] + "  ");
        }
        System.out.println();
    }
}
