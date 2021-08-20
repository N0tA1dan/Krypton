// To change the encoding of the encryption go to line 33, 42, 78, 105, and 146. do StandardCharsets.your_charset to set it to your liking

import java.math.BigInteger;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class krypton_custom_key {

    public static void main(String[] args){
        Scanner start_input = new Scanner(System.in);
        System.out.print("What would you like to do (encrypt/decrypt): ");

        String start_input_read = start_input.nextLine();

        if (start_input_read.contains("encrypt")) {
            encrypt();
        }
        else if (start_input_read.contains("decrypt")) {
            decrypt();
        }
    }

    // Encryption Process
    public static void encrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What would you like to encrypt?: ");

        String user_cipher = scanner.nextLine();

        try {

            // encodes user input into a byte array using said Encoding
            byte[] encode = user_cipher.getBytes(StandardCharsets.UTF_8);



            // -------------- Key Input --------------
            Scanner key_scanner = new Scanner(System.in);
            System.out.print("Please enter a 320-bit prefered sized key: ");

            String user_key = key_scanner.nextLine();
            // Turns user key into a byte array using said Encoding.
            byte[] key_encoded = user_key.getBytes(StandardCharsets.UTF_8);
            BigInteger key_1 = new BigInteger(key_encoded);


            // Reverses key_1
            String key_1_string = key_1.toString();
            StringBuilder stringbuilder = new StringBuilder(key_1_string);
            stringbuilder.reverse();
            String key_1_reversed = stringbuilder.toString();

            BigInteger key_2 = new BigInteger(key_1_reversed);

            // --------- ENCRYPTION PROCESS ----------
            // turns users input from its encoding into hexadecimal then into a biginteger
            BigInteger cipher_1 = new BigInteger(encode);
            // math adding onto the hexadecimal numbers
            BigInteger cipher_2 = cipher_1.multiply(key_1);
            BigInteger cipher_3 = cipher_2.multiply(key_2);

            // reverses user cipher
            String cipher_3_to_string = cipher_3.toString();
            StringBuilder stringbuilder_2 = new StringBuilder(cipher_3_to_string);
            stringbuilder_2.reverse();
            String cipher_4_string = stringbuilder_2.toString();

            // reversed user cipher
            BigInteger cipher_4 = new BigInteger(cipher_4_string);

            BigInteger cipher_5 = cipher_4.multiply(key_1);


            String key_decoded = key_1.toString(16);

            // converts the hexadecimal string into a byte array
            byte[] key_to_byte_array = new BigInteger(key_decoded, 16).toByteArray();
            // converts the byte array back into utf-8 encoded chars
            String decoded_key = new String(key_to_byte_array, StandardCharsets.UTF_8);


            // ---------- PRINTING RESULTS ---------
            System.out.println("--------------------------------------------");
            System.out.print("Your key is: ");
            System.out.println(decoded_key);
            System.out.println("--------------------------------------------");
            System.out.println("Your encrypted text is below");
            System.out.println();
            System.out.println(cipher_5);

        }

        catch(Exception Unknown_Error){
            System.out.println("Error. The program has experience a unsuspected error. Please try again later.");
        }
    }

    // ---------- DECRYPTION PROCESS ---------
    public static void decrypt() {

        // --------- KEYS ----------
        Scanner key_input = new Scanner(System.in);
        System.out.print("Please enter your key: ");

        String key_to_string = key_input.nextLine();
        byte[] utf_key_encoded = key_to_string.getBytes(StandardCharsets.UTF_8);
        BigInteger key_1 = new BigInteger(utf_key_encoded);


        // Reverses key_1
        String key_1_string = key_1.toString();
        StringBuilder stringbuilder = new StringBuilder(key_1_string);
        stringbuilder.reverse();
        String key_1_reversed = stringbuilder.toString();

        BigInteger key_2 = new BigInteger(key_1_reversed);



        // ---------- GETTING USERS CIPHER -----------
        Scanner cipher_input = new Scanner(System.in);
        System.out.print("Please enter your encrypted text: ");
        BigInteger cipher = new BigInteger(cipher_input.nextLine());


        // ---------- DECRYPTING THE CIPHERS ----------

        BigInteger cipher_5 = cipher.divide(key_1);

        String cipher_5_to_string = cipher_5.toString();
        StringBuilder stringBuilder_2 = new StringBuilder(cipher_5_to_string);
        stringBuilder_2.reverse();
        String cipher_4_to_string = stringBuilder_2.toString();

        BigInteger cipher_4 = new BigInteger(cipher_4_to_string);

        BigInteger cipher_3 = cipher_4.divide(key_2);
        BigInteger cipher_2 = cipher_3.divide(key_1);


        // converts the bigintegers back into hexadecimal using a radix of 16
        String cipher_1 = cipher_2.toString(16);

        // converts the hexadecimal string into a byte array
        byte[] hex_string_byte_array = new BigInteger(cipher_1, 16).toByteArray();
        // converts the byte array back into its encoded chars
        String hex_to_char = new String(hex_string_byte_array, StandardCharsets.UTF_8);


        System.out.println("Your decrypted text is below");
        System.out.println(hex_to_char);
    }
}
