
import java.util.*;

public class Main {

    private static int N; // Количество запросов, которые можно кэшировать
    private static Map<Integer, Integer> cache; // Кэш для хранения уже загруженных данных

    public static void main(String[] args) {
        // Задаем количество запросов для кэширования
        N = 100;

        // Инициализируем кэш
        cache = new LinkedHashMap<>();

        // Последовательность запросов данных
        List<Integer> requests = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Перебираем все запросы
        for (Integer request : requests) {
            // Проверяем, есть ли данные в кэше
            if (cache.containsKey(request)) {
                // Если данные уже есть в кэше, выводим их и удаляем из кэша
                System.out.println("Данные для запроса " + request + ": " + cache.get(request));
                cache.remove(request);
            } else {
                // Если данных нет в кэше, загружаем их из распределенной системы
                int data = loadDataFromDistributedSystem(request);
                System.out.println("Данные для запроса " + request + ": " + data);
            }

            // Добавляем текущий запрос в кэш
            cache.put(request, request);

            // Если кэш превышает максимальное количество запросов, удаляем самый старый запрос
            if (cache.size() > N) {
                Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
                Integer oldestRequest = iterator.next().getKey();
                iterator.remove();
                System.out.println("Удален самый старый запрос: " + oldestRequest);
            }
        }
    }

    // Метод для загрузки данных из распределенной системы
    private static int loadDataFromDistributedSystem(int request) {
        // Здесь должна быть реализация загрузки данных из распределенной системы
        // В данном примере загружаемомые данные равны номеру запроса
        return request;
    }
}


   /*// В данном решении используется простой подход, основанный на кэшировании данных из распределенной системы. Вначале задается количество запросов, которые можно кэшировать (переменная N). Затем создается кэш в виде LinkedHashMap, который будет использоваться для хранения уже загруженных данных.

        Далее задается последовательность запросов данных (переменная requests). В цикле перебираются все запросы, и для каждого запроса проверяется, есть ли он уже в кэше. Если запрос присутствует в кэше, его данные выводятся на экран и удаляются из кэша. Если запрос отсутствует в кэше, данные загружаются из распределенной системы путем вызова метода loadDataFromDistributedSystem(), который возвращает данные для указанного запроса. Загруженные данные выводятся на экран.

        После этого текущий запрос добавляется в кэш. Если количество запросов в кэше превышает максимально допустимое значение N, то удаляется самый старый запрос из кэша.

        Метод loadDataFromDistributedSystem() служит здесь заглушкой и возвращает просто номер запроса в качестве данных. В реальной реализации этот метод должен быть заменен на код, который загружает данные из распределенной системы.*/