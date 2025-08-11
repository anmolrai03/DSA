package assessment.collage;
import java.util.*;

//public class Main {
//   public static void main(String args[]) {
//      Scanner s = new Scanner(System.in);
//      int N = Integer.parseInt(s.nextLine());
//
//      for (int i = 0; i < N; i++) {
//         String phoneNumber = s.nextLine();
//         System.out.println(isValidPhoneNumber(phoneNumber));
//      }
//   }
//
//   public static boolean isValidPhoneNumber(String phoneNumber) {
//      // Check if it starts with valid prefix
//      boolean validPrefix = false;
//      boolean internationalFormat = false;
//      boolean nationalFormat = false;
//
//      if (phoneNumber.startsWith("+91")) {
//         internationalFormat = true;
//         validPrefix = true;
//      } else if (phoneNumber.startsWith("0")) {
//         nationalFormat = true;
//         validPrefix = true;
//      } else if (phoneNumber.length() >= 1) {
//         char firstChar = phoneNumber.charAt(0);
//         if (firstChar == '7' || firstChar == '8' || firstChar == '9') {
//            validPrefix = true;
//         }
//      }
//
//      if (!validPrefix) {
//         return false;
//      }
//
//      // Check for spaces in allowed positions
//      String numberWithoutSpaces = phoneNumber.replaceAll(" ", "");
//      if (internationalFormat) {
//         if (!phoneNumber.startsWith("+91 ")) {
//            // If it's international format but doesn't have space after +91, check if it's +91xxxxxxxxxx
//            if (phoneNumber.length() != 13 || !phoneNumber.startsWith("+91")) {
//               return false;
//            }
//         } else {
//            // Check space positions for international format: +91 xxxxx xxxxx
//            String[] parts = phoneNumber.split(" ");
//            if (parts.length != 3 || !parts[0].equals("+91") || parts[1].length() != 5 || parts[2].length() != 5) {
//               return false;
//            }
//         }
//      } else if (nationalFormat) {
//         if (phoneNumber.contains(" ")) {
//            // Check space positions for national format: 0xxxxx xxxxx
//            String[] parts = phoneNumber.split(" ");
//            if (parts.length != 2 || parts[0].length() != 6 || parts[1].length() != 5) {
//               return false;
//            }
//         }
//      } else {
//         // For numbers starting with 7,8,9 - no spaces allowed
//         if (phoneNumber.contains(" ")) {
//            return false;
//         }
//      }
//
//      // Check all characters are digits or + (only at start)
//      for (int i = 0; i < phoneNumber.length(); i++) {
//         char c = phoneNumber.charAt(i);
//         if (c == '+') {
//            if (i != 0) {
//               return false;
//            }
//         } else if (c == ' ') {
//            continue;
//         } else if (!Character.isDigit(c)) {
//            return false;
//         }
//      }
//
//      // Check total digits is 10 (excluding +91, 0, and spaces)
//      String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
//      if (internationalFormat) {
//         if (digitsOnly.length() != 12) { // +91 contributes 2 digits (9 and 1)
//            return false;
//         }
//         if (!digitsOnly.startsWith("91")) {
//            return false;
//         }
//         String actualNumber = digitsOnly.substring(2);
//         if (actualNumber.length() != 10) {
//            return false;
//         }
//      } else if (nationalFormat) {
//         if (digitsOnly.length() != 11) { // 0 contributes 1 digit
//            return false;
//         }
//         String actualNumber = digitsOnly.substring(1);
//         if (actualNumber.length() != 10) {
//            return false;
//         }
//      } else {
//         if (digitsOnly.length() != 10) {
//            return false;
//         }
//      }
//
//      return true;
//   }
//}




import java.util.Scanner;
import java.util.Arrays; // For initializing the DP array if needed, or loop

class Main {
   public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);

      // Read N and K
      int N = scanner.nextInt();
      int K = scanner.nextInt();

      // Read G[] (gift voucher values)
      int[] G = new int[N];
      for (int i = 0; i < N; i++) {
         G[i] = scanner.nextInt();
      }

      // Read P[] (item prices)
      int[] P = new int[N];
      for (int i = 0; i < N; i++) {
         P[i] = scanner.nextInt();
      }

      scanner.close(); // Close the scanner after reading all input

      // DP array: dp[j] will store the maximum voucher value for a budget 'j'
      int[] dp = new int[K + 1];

      // Initialize dp array (all zeros, which is default for int arrays in Java)
      // Arrays.fill(dp, 0); // This line is optional as ints are default 0

      // Iterate through each item
      for (int i = 0; i < N; i++) {
         int currentPrice = P[i];
         int currentVoucher = G[i];

         // Iterate through the budget from K down to the current item's price
         for (int j = K; j >= currentPrice; j--) {
            // Option 1: Don't take the current item (value is dp[j] from previous iterations)
            // Option 2: Take the current item (value is dp[j - currentPrice] + currentVoucher)
            dp[j] = Math.max(dp[j], dp[j - currentPrice] + currentVoucher);
         }
      }

      // The maximum gift voucher value for budget K is in dp[K]
      System.out.println(dp[K]);
   }
}