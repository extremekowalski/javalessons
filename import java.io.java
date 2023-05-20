import java.io.File;

public class FolderTree {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        File directory = new File(currentDirectory);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println(directory.getName());
            printFolderTree(directory, 1);
        } else {
            System.out.println("Invalid directory: " + currentDirectory);
        }
    }

    private static void printFolderTree(File directory, int depth) {
        File[] files = directory.listFiles();
        if (files != null) {
            String prefix = getIndentation(depth);

            for (File file : files) {
                System.out.print(prefix);
                System.out.println(file.getName());

                if (file.isDirectory()) {
                    printFolderTree(file, depth + 1);
                }
            }
        }
    }

    private static String getIndentation(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
