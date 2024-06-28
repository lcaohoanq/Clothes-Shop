package clothingstore.constant;

public class Regex {

    public static final String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    public static final String HASHED_PASSWORD = "\\$31\\$(\\d\\d?)\\$(.{43})"; // format for pbkdf2

}
