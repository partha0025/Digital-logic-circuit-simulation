package LogicCircuits;

public class Gates {

    public int AND(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 == 1 && input2 == 1) ? 1 : 0;
    }

    public int OR(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 == 1 || input2 == 1) ? 1 : 0;
    }

    public int NOT(int input) throws Exception {
        validateInput(input);
        return (input == 1) ? 0 : 1;
    }

    public int NAND(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 == 1 && input2 == 1) ? 0 : 1;
    }

    public int NOR(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 == 0 && input2 == 0) ? 1 : 0;
    }

    public int XOR(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 ^ input2); // XOR using bitwise operator
    }

    public int XNOR(int input1, int input2) throws Exception {
        validateInputs(input1, input2);
        return (input1 == input2) ? 1 : 0;
    }

    // Input validation methods
    private void validateInputs(int input1, int input2) throws Exception {
        if (!isValid(input1) || !isValid(input2)) {
            throw new Exception("Invalid inputs, please enter 0 or 1 only.");
        }
    }

    private void validateInput(int input) throws Exception {
        if (!isValid(input)) {
            throw new Exception("Invalid input, please enter 0 or 1 only.");
        }
    }

    private boolean isValid(int input) {
        return input == 0 || input == 1;
    }
}
