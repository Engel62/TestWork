import java.io.*;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String[] parameters = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(parameters[0]);
            int m = Integer.parseInt(parameters[1]);

            Deque<Integer> cache = new ArrayDeque<>();
            Set<Integer> cacheSet = new HashSet<>();

            for (int i = 0; i < m; i++) {
                int id = Integer.parseInt(reader.readLine().trim());
                if (cacheSet.contains(id)) {
                    cache.remove(id);
                } else {
                    if (cache.size() == n) {
                        int removedId = cache.pollLast();
                        cacheSet.remove(removedId);
                    }
                }
                cache.offerFirst(id);
                cacheSet.add(id);
            }

            for (int id : cache) {
                System.out.println(id);
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
