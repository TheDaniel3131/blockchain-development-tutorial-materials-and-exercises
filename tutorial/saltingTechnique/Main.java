import java.security.MessageDigest;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Hex;
import org.mindrot.jbcrypt.BCrypt;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static class Salt {
        public static byte[] generate() {
            SecureRandom sr = new SecureRandom();
            byte[] b = new byte[16];
            sr.nextBytes(b);
            return b;
        }
    }

    private static String hash(String input, byte[] salt, String algorithm) {
        MessageDigest md;
        try {
            // Instantiate the MD object
            md = MessageDigest.getInstance(algorithm);
            // Fetch input to MD
            md.update(input.getBytes());
            md.update(salt);

            // Digest it
            byte[] hashBytes = md.digest();
            // Convert to Hex format with Hex API from Apache common
            return String.valueOf(Hex.encodeHex(hashBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to hash a password using BCrypt
    public static String hashPasswordWithBCrypt(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    // Method to verify a password using BCrypt
    public static boolean checkPasswordWithBCrypt(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    // Method to write the hashed password to a file
    public static void writeToFile(String hashedPassword, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(hashedPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read the hashed password from a file
    public static String readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "mySecurePassword";

        // Hash the password using SHA-256 with salt
        byte[] salt = Salt.generate();
        String algorithm = "SHA-256";
        String hashedPasswordSHA256 = hash(password, salt, algorithm);

        System.out.println("Salt (SHA-256): " + String.valueOf(Hex.encodeHex(salt)));
        System.out.println("Hashed Password (SHA-256): " + hashedPasswordSHA256);

        // Hash the password using BCrypt
        String hashedPasswordBCrypt = hashPasswordWithBCrypt(password);
        System.out.println("Hashed Password (BCrypt): " + hashedPasswordBCrypt);

        // Write the hashed password to a file
        String filename = "hashed_password.txt";
        writeToFile(hashedPasswordBCrypt, filename);

        // Read the hashed password from the file
        String storedHashedPassword = readFromFile(filename);

        // Login form to verify the password
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();

        // Verify the password
        if (checkPasswordWithBCrypt(inputPassword, storedHashedPassword)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Invalid password.");
        }

        scanner.close();
    }
}
