
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MiddlewareServer {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]); // максимальное количество запросов, которое может быть закэшировано
            int m = Integer.parseInt(line[1]); // количество запросов

            Deque<Integer> cache = new ArrayDeque<>();
            Set<Integer> cachedData = new HashSet<>();

            for (int i = 0; i < m; i++) {
                int request = Integer.parseInt(reader.readLine());

                if (cachedData.contains(request)) {
                    cache.removeFirstOccurrence(request);
                    cache.addLast(request);
                } else {
                    if (cache.size() == n) {
                        int removedRequest = cache.removeFirst();
                        cachedData.remove(removedRequest);
                    }
                    cache.addLast(request);
                    cachedData.add(request);
                }
            }

            for (int request : cache) {
                System.out.println(request);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

