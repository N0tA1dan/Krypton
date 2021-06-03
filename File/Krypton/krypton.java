import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class krypton {
    public static void main(String args[]) {
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

    // Encryption process/method
    public static void encrypt(){
        Scanner user_encrypt = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.print("What would you like to encrypt: ");

        String user_encrypt_read = user_encrypt.nextLine();

        try {
            // gets the byte encoding of the users input in ascii.
            byte[] ascii_encode = user_encrypt_read.getBytes("US-ASCII");
            String ascii = Arrays.toString(ascii_encode);

            // filters out the unnecessary symbols and spaces in our string.
            String ascii_2 = ascii.replace("[", "");
            String ascii_3 = ascii_2.replace("]", "");
            String ascii_4 = ascii_3.replace(" ", "");
            String ascii_5 = ascii_4.replace(",", "");

            // Numbers to use in the key process and the encryption process
            BigInteger very_large_number = new BigInteger("123456789123456789123456789123456789");
            BigInteger large_number = new BigInteger("123456789123456789123456789");
            BigInteger medium_number = new BigInteger("123456789123456789");
            BigInteger small_number = new BigInteger("123456789");

            // Making the key
            // Generates random number thats 6 digits long
            Random rnd = new Random();
            int key_random = 10000000 + rnd.nextInt(100000000 - 10000000);

            // Turns key into BigInteger so we can handle it easier
            BigInteger key = new BigInteger("" + key_random);
            BigInteger key_1 = key.multiply(medium_number);
            BigInteger key_2 = key_1.multiply(small_number);
            String key_to_string = key_2.toString();


            // Reverses the key.
            StringBuilder key_reverse = new StringBuilder(key_to_string);
            key_reverse.reverse();
            // Turns reversed key into big integer
            String key_reversed = key_reverse.toString();
            BigInteger key_3 = new BigInteger(key_reversed);


            // Key 4
            BigInteger key_4 = key_3.multiply(small_number);
            String key_4_to_string = key_4.toString();

            // Reverses key 4 to key
            StringBuilder key_reverse_key_4 = new StringBuilder(key_4_to_string);
            key_reverse_key_4.reverse() ;
            // Turns reversed key into big integer
            String key_reversed_key_4 = key_reverse_key_4.toString();
            BigInteger key_5 = new BigInteger(key_reversed_key_4);


            // converts string to biginteger then uses math to encrypt it.
            BigInteger cipher_1 = new BigInteger(ascii_5);
            BigInteger cipher_2 = cipher_1.multiply(key_1);
            BigInteger cipher_3 = cipher_2.multiply(small_number);
            BigInteger cipher_4 = cipher_3.divide(medium_number);
            BigInteger cipher_5 = cipher_4.multiply(key_2);
            BigInteger cipher_6 = cipher_5.subtract(medium_number);
            BigInteger cipher_7 = cipher_6.multiply(key_3);
            BigInteger cipher_8 = cipher_7.multiply(large_number);
            BigInteger cipher_9 = cipher_8.multiply(key_4);
            BigInteger cipher_10 = cipher_9.divide(small_number);
            BigInteger cipher_11 = cipher_10.multiply(key_5);
            BigInteger cipher_12 = cipher_11.divide(large_number);
            BigInteger cipher_13 = cipher_12.divide(medium_number);
            BigInteger cipher_14 = cipher_13.multiply(small_number);
            BigInteger cipher_15 = cipher_14.divide(key_4);

            System.out.println("-------------------------------------------------------------------");
            System.out.print("Your key is: ");
            System.out.println(key_5);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Your encrypted text is below...");
            System.out.println();
            System.out.println(cipher_15);

        }
        catch (Exception error) {
            System.out.print("Error. Invalid input or error encrypting text.");
        }
    }

    // Decryption process/method
    public static void decrypt(){
        // Numbers to be used in the math process.
        BigInteger very_large_number = new BigInteger("123456789123456789123456789123456789");
        BigInteger large_number = new BigInteger("123456789123456789123456789");
        BigInteger medium_number = new BigInteger("123456789123456789");
        BigInteger small_number = new BigInteger("123456789");

        // Takes users key and encrypted text as input.
        Scanner user_key_input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Please enter in your key: ");

        String user_key_input_read = user_key_input.nextLine();

        Scanner user_encrypted_text = new Scanner(System.in);
        System.out.print("Please enter in your encrypted text: ");

        String user_encrypted_text_read = user_encrypted_text.nextLine();

        // Converts users key into a big integer
        BigInteger key = new BigInteger(user_key_input_read);

        // Reverses key 4 to key
        String key_to_string = key.toString();
        StringBuilder key_reverse_key = new StringBuilder(key_to_string);
        key_reverse_key.reverse() ;
        // Turns reversed key into big integer
        String key_reversed_key = key_reverse_key.toString();
        BigInteger key_5 = new BigInteger(key_reversed_key);

        // key 4
        BigInteger key_4 = key_5.divide(small_number);

        //reverses key
        String key_4_to_string = key_4.toString();
        StringBuilder key_4_reverse = new StringBuilder(key_4_to_string);
        key_4_reverse.reverse();

        // Turns reversed key into big integer
        String key_4_reversed = key_4_reverse.toString();
        BigInteger key_3 = new BigInteger(key_4_reversed);

        // Decrypting process of users key
        BigInteger key_2 = key_3.divide(small_number);
        BigInteger key_1 = key_2.divide(medium_number);

        // Converts users encrypted text to a BigInteger.
        BigInteger cipher = new BigInteger(user_encrypted_text_read);

        // Decrypts users encrypted text.
        BigInteger cipher_15 = cipher.multiply(key_5);
        BigInteger cipher_14 = cipher_15.divide(small_number);
        BigInteger cipher_13 = cipher_14.multiply(medium_number);
        BigInteger cipher_12 = cipher_13.multiply(large_number);
        BigInteger cipher_11 = cipher_12.divide(key);
        BigInteger cipher_10 = cipher_11.multiply(small_number);
        BigInteger cipher_9 = cipher_10.divide(key_5);
        BigInteger cipher_8 = cipher_9.divide(large_number);
        BigInteger cipher_7 = cipher_8.divide(key_4);
        BigInteger cipher_6 = cipher_7.add(medium_number);
        BigInteger cipher_5 = cipher_6.divide(key_3);
        BigInteger cipher_4 = cipher_5.multiply(medium_number);
        BigInteger cipher_3 = cipher_4.divide(small_number);
        BigInteger cipher_2 = cipher_3.divide(key_2);

        System.out.println();
        System.out.println("Your decrypted text is below...");
        System.out.println("-------------------------------------------------------------------");

        String cipher_1 = cipher_2.toString();
        int len = cipher_1.length();

        int num = 0;
        for (int i = 0; i < len; i++) {

            // Append the current digit
            // note: this line takes a number from our string for example 9 then multiplies by 10 which is 90. then we add the next number in our string(str) for example 7. Finally we subract '0' to convert the character into a integer. finally we are left with "97" which is the character "a" in ascii.
            num = num * 10 + (cipher_1.charAt(i) - '0');

            // If num is within the required range
            if (num >= 32 && num <= 255) {

                // Convert num to char
                char ch = (char)num;
                System.out.print(ch);

                // Reset num to 0
                num = 0;
            }
        }
        System.out.println();
    }
}