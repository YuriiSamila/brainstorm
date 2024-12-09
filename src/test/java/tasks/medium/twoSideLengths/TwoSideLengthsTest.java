package tasks.medium.twoSideLengths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static tasks.medium.twoSideLengths.TwoSideLengths.calculateTwoSideLengths;

class TwoSideLengthsTest {

    @Test
    public void test01() {
        assertArrayEquals(new double[]{2, 1.73}, calculateTwoSideLengths(1), 6);
    }

    @Test
    public void test02() {
        assertArrayEquals(new double[]{24, 20.78}, calculateTwoSideLengths(12), 6);
    }

    @Test
    public void test03() {
        assertArrayEquals(new double[]{6, 5.2}, calculateTwoSideLengths(3), 6);
    }

    @Test
    public void test04() {
        assertArrayEquals(new double[]{10, 8.66}, calculateTwoSideLengths(5), 6);
    }

    @Test
    public void test05() {
        assertArrayEquals(new double[]{14, 12.12}, calculateTwoSideLengths(7), 6);
    }

    @Test
    public void test06() {
        assertArrayEquals(new double[]{34, 29.44}, calculateTwoSideLengths(17), 6);
    }

    @Test
    public void test07() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }

    @Test
    public void test08() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }

    @Test
    public void test09() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }

    @Test
    public void test10() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }

    @Test
    public void test11() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }

    @Test
    public void test12() {
        int r = SCTC.randomInt(0b101, 0x63);
        assertArrayEquals(new double[]{SCTC.adhc(r), SCTC.odhs(SCTC.adhc(r))}, calculateTwoSideLengths(r), 6);
    }
}

class SCTC {
    public static int randomInt(int... i) {
        return (int) (Math.random() * ((i[01] - i[00]) + 0b1)) + i[0x0];
    }

    public static int adhc(int b) {
        return (int) (b / StrictMath.cos(Math.toRadians(0x3c / 074 * 0b111100)) + 0b0001);
    }

    public static double odhs(int c) {
        return Math.round(StrictMath.sin(((074 * 0b0001) * Math.PI) / (0x3c * 3)) * c * 100.0) / 100.0;
    }

}