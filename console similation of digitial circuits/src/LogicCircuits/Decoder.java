package LogicCircuits;

public class Decoder {

    private int[] input;
    private boolean enable;

    public Decoder(int[] input, boolean enable) {
        this.input = input;
        this.enable = enable;
    }


    public  boolean inputVerify()
    {
        int n=input.length;
        int count=0;
        for(int i=0 ; i<n ; i++)
        {
            if(input[i] == 1 || input[i] == 0)
            {
                count+=1;
            }
        }

        if(count == input.length)
        {
            return true;
        }
        else{
            return false;
        }
    }

    // Decode method
    public void decode() throws Exception{

        if(inputVerify())
        {
             
        int n = input.length;
        int size = (int) Math.pow(2, n); 
        int[] output = new int[size];

        if (enable) {
            int index = 0;
            for (int i = 0; i < n; i++) {
                index += input[i] * Math.pow(2, n - 1 - i);
            }
            output[index] = 1;
        }

        // Display output
        System.out.print("Output pin :D"+ (output.length-1));
        
        System.out.println();
        }

        else{
            throw new Exception("invalid input for Decoder");
        }
    }
}
