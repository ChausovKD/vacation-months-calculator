package ru.netology.services;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MonthlyVacationsServiceTest {

    @Test
    void testCounterFirstDefaultValues() {
        int income = 10000;
        int expenses = 3000;
        int threshold = 20000;
        int expectedVacations = 3;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    void testCounterSecondDefaultValues() {
        int income = 100000;
        int expenses = 60000;
        int threshold = 150000;
        int expectedVacations = 2;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }


    @Test
    void testCounterWithIncomeLessThanExpenses() {
        int income = 1000;
        int expenses = 1500;
        int threshold = 2000;
        int expectedVacations = 0;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    void testCounterWithIncomeGreaterThanExpensesButBelowThreshold() {
        int income = 2000;
        int expenses = 2100;
        int threshold = 2500;
        int expectedVacations = 0;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    void testOneVacation() {
        int income = 1500;
        int expenses = 1000;
        int threshold = 3000;
        int expectedVacations = 1;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    void testMultipleVacations() {
        int income = 5000;
        int expenses = 2000;
        int threshold = 6000;
        int expectedVacations = 4;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    public void testCounterWithZeroIncomeAndExpenses() {
        int income = 0;
        int expenses = 0;
        int threshold = 2000;
        int expectedVacations = 0;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        int actualVacations = counter.monthlyVacationsCounter(income, expenses, threshold);

        assertEquals(expectedVacations, actualVacations);
    }

    @Test
    void testNegativeIncome() {
        int income = -1;
        int expenses = 3000;
        int threshold = 10000;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            counter.monthlyVacationsCounter(income, expenses, threshold);
        });

        assertEquals("Income cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeExpenses() {
        int income = 5000;
        int expenses = -1;
        int threshold = 10000;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            counter.monthlyVacationsCounter(income, expenses, threshold);
        });

        assertEquals("Expenses cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeThreshold() {
        int income = 5000;
        int expenses = 3000;
        int threshold = -1;

        MonthlyVacationsService counter = new MonthlyVacationsService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            counter.monthlyVacationsCounter(income, expenses, threshold);
        });

        assertEquals("Threshold cannot be negative", exception.getMessage());
    }
}
