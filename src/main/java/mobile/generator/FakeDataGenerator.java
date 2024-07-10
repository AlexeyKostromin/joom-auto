package mobile.generator;

import java.util.Random;

public class FakeDataGenerator {
    private static final Random random = new Random();

    public static <E extends Enum<E>> E getRandomOption(Class<E> enumClass) {
        int randomIndex = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[randomIndex];
    }
}
