package ir.maktab.univercityDiskBank.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DateTest {

    Date date1=new Date(82,1,1);
    Date date2=new Date(82,1,9);
    Date date3=new Date(82,2,9);


    @Test
    public void givenMonthNumber_WhenGetLastDayOfMonthCalls_ReturnsAnInteger(){
        int result=Date.getMonthLastDay(1);
        Assertions.assertEquals(result,31);
    }

    @Test
    public void givenADate_WhenCompareCalls_ReturnANInteger(){
        int result=date1.compare(date2);
        Assertions.assertEquals(result,-1);
    }

    @Test
    public void whenGetDaysOfMonthsCalls_ReturnLong(){
        long result=date3.getDaysOfMonths();
        Assertions.assertEquals(31,result);
    }

    @Test
    public void givenDate_whenGetDatesDistanceCalls_ReturnLong(){
        long result=date2.getDatesDistance(date1);
        Assertions.assertEquals(9,result);
    }

    @Test
    public void givenDateInfo_whenIsValidDateCalls_ReturnBoolean(){
        boolean result=Date.isValidDate(date1.getYear(),date1.getMonth(),date1.getDay());
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenInteger_WhenGetMonthNameCalls_ReturnString(){
        String result=Date.getMonthName(1).name();
        Assertions.assertEquals(result,"FARVARDIN");
    }

    @Test
    public void nextDayTest(){
        date3.nextDay();
        Assertions.assertEquals(date3.getDay(),10);
    }


}
