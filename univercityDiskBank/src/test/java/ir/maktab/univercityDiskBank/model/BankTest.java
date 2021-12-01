package ir.maktab.univercityDiskBank.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class BankTest {

    @Test
    public void givenListOfStrings_WhenGetBorrowedDisksCalls_ReturnsSetOfStrings(){
        List<String> stringList=List.of("office","office","object","math","object");
        Set<String> result=Bank.getBorrowedDisks(stringList);
        Assertions.assertEquals("[math]",result.toString());
    }

    @Test
    public void givenMapStringAndListOfBorrows_WhenGetFineCalls_ReturnLong(){
        Map<String,List<Borrow>> listMap=new HashMap<>();
        List<Borrow> borrows=new ArrayList<>();
        borrows.add(new Borrow("office",new Date(82,1,1)));
        borrows.add(new Borrow("office",new Date(82,1,9)));
        listMap.put("ali",borrows);
        long result=Bank.getFine(listMap,500,"ali");
        Assertions.assertEquals(result,1000);
    }



}
