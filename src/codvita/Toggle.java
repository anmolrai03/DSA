package codvita;
import java.util.*;

public class Toggle {

    // 7-segment representations of digits 0 to 9 in a 3x3 grid
    static String[] segment = {
        "1110111", // 0
        "0100100", // 1
        "1011101", // 2
        "1101101", // 3
        "0101110", // 4
        "1101011", // 5
        "1111011", // 6
        "0100101", // 7
        "1111111", // 8
        "1101111"  // 9
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the first three lines for the 7-segment representations
        String[] firstLine = sc.nextLine().split("");
        String[] secondLine = sc.nextLine().split("");
        String[] thirdLine = sc.nextLine().split("");

        // Store the faulty display's segments for each digit
        String[] inputDigits = new String[firstLine.length];
        for (int i = 0; i < firstLine.length; i++) {
            inputDigits[i] = firstLine[i] + secondLine[i] + thirdLine[i];
        }

        // List to store the possible numbers
        Set<Integer> possibleNumbers = new HashSet<>();

        // Process each digit in the input display
        for (String faultyDigit : inputDigits) {
            Set<Integer> validDigits = new HashSet<>();

            // Check which valid digits can be formed by toggling at most one LED
            for (int digit = 0; digit < 10; digit++) {
                String validSegment = segment[digit];

                // If the faulty digit matches the valid digit, add it to valid set
                if (faultyDigit.equals(validSegment)) {
                    validDigits.add(digit);
                }

                // Try toggling each of the 7 lights one by one
                for (int i = 0; i < 7; i++) {
                    char[] toggledFaultyDigit = faultyDigit.toCharArray();
                    toggledFaultyDigit[i] = (toggledFaultyDigit[i] == '1') ? '0' : '1'; // Toggle the LED
                    String toggledFaultyDigitStr = new String(toggledFaultyDigit);

                    if (toggledFaultyDigitStr.equals(validSegment)) {
                        validDigits.add(digit);
                    }
                }
            }

            // If no valid digit is found after toggling one light, print "Invalid"
            if (validDigits.isEmpty()) {
                System.out.println("Invalid");
                return;
            }

            // Add all valid digits for the current faulty digit to the possible numbers set
            possibleNumbers.addAll(validDigits);
        }

        // Calculate the sum of all possible numbers formed
        int totalSum = 0;
        for (int num : possibleNumbers) {
            totalSum += num;
        }

        // Output the total sum
        System.out.println(totalSum);
    }
}
