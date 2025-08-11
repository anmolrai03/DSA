import java.util.*;

public class ShannonCircuit {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<String> gatesCalc = new ArrayList<>();
//
//        while(n-- > 0){
//            String gate = sc.nextLine();
//            gatesCalc.add(gate);
//        }
//
//        int cycleOfInput = sc.nextInt();
//
//        HashMap<String , ArrayList<Integer>> mapp = new HashMap<>();
//
//        while(cycleOfInput-- > 0){
//            ArrayList<Integer> data = new ArrayList<>();
//            String inputData = sc.nextLine();
//            for(int i = 1; i< inputData.length() ; i++){
//                data.add(i);
//            }
//            mapp.put(inputData, data);
//        }
//    }
//    // Function to compute gate output
//    private static int gateOutput(String gateType, int[] input1, int[] input2) {
//        int[] res = new int[input1.length];
//        res[0] = 0;
//
//        if(gateType == "AND"){
//            for(int i = 0 ; i < input1.length -1; i++){
//                res[i + 1] = input1[i] & input2[i];
//            }
//        }
//        else if(gateType == "OR"){
//            for(int i = 0 ; i < input1.length -1; i++){
//                res[i + 1] = input1[i] | input2[i];
//            }
//        }
//        else if(gateType == "XOR"){
//            for(int i = 0 ; i < input1.length -1; i++){
//                res[i + 1] = input1[i] ^ input2[i];
//            }
//        }
//        else if(gateType == "NAND"){
//            for(int i = 0 ; i < input1.length -1; i++){
//                res[i + 1] = ~ (input1[i] & input2[i]);
//            }
//        }
//
//        else if(gateType == "NOR"){
//            for(int i = 0 ; i < input1.length ; i++){
//                res[i] = ~ (input1[i] | input2[i]);
//            }
//        }
//    }
}
