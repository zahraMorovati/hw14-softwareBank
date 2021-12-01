package ir.maktab.univercityDiskBank.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class borrowTest {
    Borrow borrow=new Borrow("office",new Date(82,1,1));
    Date date=new Date(82,1,9);

    @Test
    public void givenDate_whenIsLateCalls_ReturnsBoolean(){
        boolean result=borrow.isLate(date);
        Assertions.assertEquals(true,result);
    }
}
