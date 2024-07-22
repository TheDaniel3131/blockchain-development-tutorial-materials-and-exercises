import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Hex;


public class Main {

    // hash method
    private static String hash(String input, String algorithm) {
        String hashCode = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            // digesting...
            byte[] hashBytes = md.digest();
            // convert the byte[] to String

            // Base64 format
            // hashCode = Base64.getEncoder().encodeToString(hashBytes);

            // Hex format output (Recommended)
            hashCode = Hex.encodeHexString(hashBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashCode;
    }

    // MD5 hashing method
    public static String md5(String input) {
        return hash(input, "MD5");
    }

    // SHA-256 hashing method
    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    // SHA-384 hashing method
    public static String sha384(String input) {
        return hash(input, "SHA-384");
    }

    // SHA-512 hashing method
    public static String sha512(String input) {
        return hash(input, "SHA-512");
    }

    public static void main(String[] args) {
        String str1 = "alice";
        String str2 = "bob";

        // string collection
        List<String> lst = new ArrayList<>();
        lst.add(str1);
        lst.add(str2);
        System.out.println("List = " + lst);
        System.out.println("hashcode = " + lst.hashCode());

        // Test Cases
        System.out.println("MD5 of 'alice': " + md5(str1));
        System.out.println("SHA-256 of 'alice': " + sha256(str1));
        System.out.println("SHA-384 of 'alice': " + sha384(str1));
        System.out.println("SHA-512 of 'alice': " + sha512(str1) + "\n");

        System.out.println("MD5 of 'bob': " + md5(str2));
        System.out.println("SHA-256 of 'bob': " + sha256(str2));
        System.out.println("SHA-384 of 'bob': " + sha384(str2));
        System.out.println("SHA-512 of 'bob': " + sha512(str2));


    }
}
