package ir.maktab.univercityDiskBank.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PersonTest {

    Person person=new Person("ali");
    Date date1=new Date(82,1,1);
    Date date2=new Date(82,1,9);
    Disk disk=new Disk("office");

    @Test
    public void given2Dates_whenGetLateDaysCalls_ThenReturnLong(){
        long result=Person.getLateDays(date1,date2);
        Assertions.assertEquals(2,result);
    }


    @Test
    public void givenAStringAndADate_WhenBorrowCalls_ThenReturnBorrow(){
        Borrow result=person.borrow(disk,date1) ;
        Borrow expected=new Borrow(disk.getName(),date1);
        Assert.assertSame(result.getDiskName(),expected.getDiskName());
    }

    @Test
    public void givenAStringAndADate_WhenDeliverCalls_ThenReturnBorrow(){
        Borrow result=person.deliver(disk,date2) ;
        Borrow expected=new Borrow(disk.getName(),date2);
        Assert.assertSame(result.getDiskName(),expected.getDiskName());
    }

}
