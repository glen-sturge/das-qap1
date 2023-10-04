import java.io.File;

public class FileExistenceChecker {
    public static boolean checkPath(String filePath) {
        boolean exists = false;
        File file = new File(filePath);

        if (file.exists()) {
            exists = true;
        }
        return exists;
    }
}
