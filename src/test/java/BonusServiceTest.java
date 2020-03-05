import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    //long bonus = amount*percent/100/100;

    @org.junit.jupiter.api.Test
    void shouldCalculatedForRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);


    }

    @Test
    void shouldCalculatedForRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculatedForNotRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);


    }
    @Test
    void shouldCalculatedForNotRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 100_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);


    }

}