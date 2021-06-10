package Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainTestTest {
    MainTest mainTest;

    @BeforeEach
    public void init() {
        mainTest = new MainTest();
    }


    @ParameterizedTest
    @MethodSource("dataForArrayResult")
    void checkFourAndReturnArray(int[] arr, int[] result) {
        Assertions.assertArrayEquals(result, mainTest.checkFourAndReturnArray(arr));

    }

    public static Stream<Arguments> dataForArrayResult() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[]{5, 6, 7, 8}));
        out.add(Arguments.arguments(new int[]{2, 4, 1, 3, 6, 8, 7, 9, 0}, new int[]{1, 3, 6, 8, 7, 9, 0}));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 4, 1, 1}, new int[]{1, 1}));
        out.add(Arguments.arguments(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 4}, new int[]{}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForArrayCheck")
    void checkOneOrFour(int[] arr, boolean result) {
        Assertions.assertEquals(result, mainTest.checkOneOrFour(arr));
    }

    public static Stream<Arguments> dataForArrayCheck() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1}, true));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1}, true));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4}, false));
        return out.stream();
    }

}
