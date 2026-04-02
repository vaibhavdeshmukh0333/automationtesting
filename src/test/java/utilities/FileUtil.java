package utilities;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileUtil class to read external files like .properties, .xlsx, etc.
 * Provides methods to read file content and return as FileInputStream or String.
 */
public class FileUtil {

    private static FileInputStream fileInputStream;

    /**
     * Reads a file from the given file path and returns FileInputStream.
     * @param filePath The path to the file to read.
     * @return FileInputStream of the file.
     */
    public static FileInputStream readFile(String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileInputStream;
    }

    /**
     * Reads a properties file and returns the content as String.
     * Note: This is a basic implementation; for properties, use ReadConfig class.
     * @param filePath The path to the file.
     * @return File content as String.
     */
    public static String readFileAsString(String filePath) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                content.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
