import java.io.IOException;

public class ShutDown {
    public static void main(String[] args) throws IOException {
        shutdown();
    }public static void shutdown() throws RuntimeException, IOException {
        String shutdownCommand;
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.startsWith("Linux") || operatingSystem.startsWith("Mac")) {
            shutdownCommand = "shutdown -h now";
        }
        else if (operatingSystem.startsWith("Windows")) {
            shutdownCommand = "shutdown.exe -s -t 0";
        }
        else if (operatingSystem.startsWith("Chrome"))
        {
            shutdownCommand = "taskkill /F /IM chrome.exe /T";
        }
        else {
            throw new RuntimeException("Unsupported operating system.");
        }

        Runtime.getRuntime().exec(shutdownCommand);
        System.exit(0);
    }
}
