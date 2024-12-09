package tasks.medium.qudraticSolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tasks.medium.qudraticSolutions.QuadraticSolutions.countSolutions;

class QuadraticSolutionsTest {

    @Test
    public void test1() {
        assertEquals(2, countSolutions(1, 0, -1));
    }

    @Test
    public void test2() {
        assertEquals(1, countSolutions(1, 0, 0));
    }

    @Test
    public void test3() {
        assertEquals(0, countSolutions(1, 0, 1));
    }

    @Test
    public void test4() {
        assertEquals(0, countSolutions(200, 420, 800));
    }

    @Test
    public void test5() {
        assertEquals(2, countSolutions(200, 420, -800));
    }

    @Test
    public void test6() {
        assertEquals(2, countSolutions(1000, 1000, 0));
    }

    @Test
    public void test7() {
        assertEquals(1, countSolutions(10000, 400, 4));
    }

}