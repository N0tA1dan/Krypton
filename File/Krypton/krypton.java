import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class krypton {

    // ---------- NUMBERS TO PROCESS ENCRYPTION/DECRYPTION ---------
    public static BigInteger small_number = new BigInteger("123456789");
    public static BigInteger medium_number = new BigInteger("123456789123456789");
    public static BigInteger large_number = new BigInteger("123456789123456789123456789");


    public static void main(String[] args){
        Scanner start_input = new Scanner(System.in, "US-ASCII");
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

            // gets the byte encoding of the users input in utf-8.
            byte[] utf_8_encode = user_cipher.getBytes(StandardCharsets.UTF_8);



            // ---------- Key generation ----------
            SecureRandom random = new SecureRandom();
            BigInteger key_limit = new BigInteger("10000000000000000000000000000000000000000");
            int key_length = key_limit.bitLength();
            BigInteger key_1 = new BigInteger(key_length, random);

            // Reverses key_1
            String key_1_string = key_1.toString();
            StringBuilder stringbuilder = new StringBuilder(key_1_string);
            stringbuilder.reverse();
            String key_1_reversed = stringbuilder.toString();

            BigInteger key_reversed = new BigInteger(key_1_reversed);

            BigInteger key_2 = key_reversed.multiply(small_number);
            BigInteger key_3 = key_2.divide(small_number);
            BigInteger key_4 = key_3.divide(small_number);

            // Reverses key_4
            String key_4_string = key_4.toString();
            StringBuilder stringbuilder_2 = new StringBuilder(key_4_string);
            stringbuilder.reverse();
            String key_4_reversed = stringbuilder_2.toString();

            BigInteger key_5 = new BigInteger(key_4_reversed);


            // --------- ENCRYPTION PROCESS ----------
            // turns users input from utf-8 encoding into hexadecimal then into a biginteger
            BigInteger cipher_1 = new BigInteger(utf_8_encode);
            // math adding onto the hexadecimal numbers
            BigInteger cipher_2 = cipher_1.multiply(key_1);
            BigInteger cipher_3 = cipher_2.multiply(key_reversed);
            BigInteger cipher_4 = cipher_3.divide(medium_number);
            BigInteger cipher_5 = cipher_4.multiply(key_3);
            BigInteger cipher_6 = cipher_5.divide(small_number);
            BigInteger cipher_7 = cipher_6.multiply(key_4);
            BigInteger cipher_8 = cipher_7.divide(key_5);
            BigInteger cipher_9 = cipher_8.multiply(large_number);
            BigInteger cipher_10 = cipher_9.divide(key_5);
            BigInteger cipher_11 = cipher_10.multiply(key_reversed);
            BigInteger cipher_12 = cipher_11.multiply(key_5);
            BigInteger cipher_13 = cipher_12.divide(medium_number);
            BigInteger cipher_14 = cipher_13.divide(key_reversed);


            // ---------- PRINTING RESULTS ---------
            System.out.println("--------------------------------------------");
            System.out.print("Your key is: ");
            System.out.println(key_1);
            System.out.println("--------------------------------------------");
            System.out.println("Your encrypted text is below");
            System.out.println();
            System.out.println(cipher_14);

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

        BigInteger key_1 = new BigInteger(key_input.nextLine());

        // Reverses key_1
        String key_1_string = key_1.toString();
        StringBuilder stringbuilder = new StringBuilder(key_1_string);
        stringbuilder.reverse();
        String key_1_reversed = stringbuilder.toString();

        BigInteger key_reversed = new BigInteger(key_1_reversed);

        BigInteger key_2 = key_reversed.multiply(small_number);
        BigInteger key_3 = key_2.divide(small_number);
        BigInteger key_4 = key_3.divide(small_number);

        // Reverses key_4
        String key_4_string = key_4.toString();
        StringBuilder stringbuilder_2 = new StringBuilder(key_4_string);
        stringbuilder.reverse();
        String key_4_reversed = stringbuilder_2.toString();

        BigInteger key_5 = new BigInteger(key_4_reversed);


        // ---------- GETTING USERS CIPHER -----------
        Scanner cipher_input = new Scanner(System.in);
        System.out.print("Please enter your encrypted text: ");
        BigInteger cipher = new BigInteger(cipher_input.nextLine());
        // ---------- DECRYPTING THE CIPHERS ----------
        BigInteger cipher_14 = cipher.multiply(key_reversed);
        BigInteger cipher_13 = cipher_14.multiply(medium_number);
        BigInteger cipher_12 = cipher_13.divide(key_5);
        BigInteger cipher_11 = cipher_12.divide(key_reversed);
        BigInteger cipher_10 = cipher_11.multiply(key_5);
        BigInteger cipher_9 = cipher_10.divide(large_number);
        BigInteger cipher_8 = cipher_9.multiply(key_5);
        BigInteger cipher_7 = cipher_8.divide(key_4);
        BigInteger cipher_6 = cipher_7.multiply(small_number);
        BigInteger cipher_5 = cipher_6.divide(key_3);
        BigInteger cipher_4 = cipher_5.multiply(medium_number);
        BigInteger cipher_3 = cipher_4.divide(key_reversed);
        BigInteger cipher_2 = cipher_3.divide(key_1);
        // I have to add one because the program when decrypting subtracts one which leaves the ascii 1 integer off
        BigInteger cipher_add = cipher_2.add(new BigInteger("1"));

        System.out.println("Your decrypted text is below");

        String cipher_1 = cipher_add.toString(16);

        byte[] hex_string_byte_array = new BigInteger(cipher_1, 16).toByteArray();
        String hex_to_utf_8 = new String(hex_string_byte_array, StandardCharsets.UTF_8);

        System.out.println(hex_to_utf_8);
    }
}
