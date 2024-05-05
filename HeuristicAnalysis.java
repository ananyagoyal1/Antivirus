import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class HeuristicAnalysis {
    private static final Pattern suspiciousPatterns = Pattern.compile(
            "\\b(system|exec|runtime|loadlibrary)\\b",
            Pattern.CASE_INSENSITIVE);

    public static boolean isSuspicious(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (suspiciousPatterns.matcher(line).find()) {
                    return true; // Suspicious pattern found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No suspicious patterns found
    }
}