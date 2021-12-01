package ir.maktab.univercityDiskBank.model;

import ir.maktab.univercityDiskBank.utilities.GetValidData;
import ir.maktab.univercityDiskBank.model.Date.DateBuilder;

import java.util.*;

import static ir.maktab.univercityDiskBank.utilities.ConsoleColors.*;

public class Bank {

    public Bank() {
    }

    public static void main(String[] args) {

        Map<String,List<Borrow>> personList=new HashMap<>();
        List<String> diskNames = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int t = GetValidData.getValidInt("t: ");    // جریمه دیرکرد
        int n = GetValidData.getValidInt("n: ");    //تعداد خط ورودی

        for (int i = 0; i < n; i++) {
            try {
                setLineInfo(personList, diskNames, scanner, i);
            } catch (RuntimeException e) {
                System.out.println(RED + "invalid input!" + RESET);
            }
        }
        System.out.println("\n*****output *****\nFines: ");
        printFines(personList,t);
        System.out.println("Borrowed Disks: ");
        for (String borrowedDisk : getBorrowedDisks(diskNames)) {
            System.out.println(borrowedDisk);
        }
    }

    private static void setLineInfo(Map<String, List<Borrow>> personList, List<String> diskNames, Scanner scanner, int i) {
        System.out.print("line " + (i + 1) + " : ");
        Date date = DateBuilder.aDate()
                .setDay(scanner.nextInt())
                .setMonth(scanner.nextInt())
                .setYear(scanner.nextInt()).build();
        String personName= scanner.next();
        String diskName= scanner.next();
        diskNames.add(diskName);

        if(personList.containsKey(personName)){
            personList.get(personName).add(new Borrow(diskName,date));
        }else {
            List<Borrow> borrowList=new ArrayList<>();
            borrowList.add(new Borrow(diskName,date));
            personList.put(personName,borrowList);
        }
    }

    public static Set<String> getBorrowedDisks(List<String> diskNames) {
        Set<String> borrowedDisks = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < diskNames.size(); i++) {
            for (String disk : diskNames) {
                if (diskNames.get(i).equals(disk)) {
                    counter++;
                }
            }
            if (counter % 2 != 0) {
                borrowedDisks.add(diskNames.get(i));
            }
            counter = 0;
        }
        return borrowedDisks;
    }

    public static void printFines(Map<String,List<Borrow>> personList,int t){

        for (String personName : personList.keySet()) {
            long fine = getFine(personList, t, personName);
            System.out.println(personName+" : "+fine);
        }
    }

    public static long getFine(Map<String, List<Borrow>> personList, int t, String personName) {
        long fine=0;
        for (int i = 0; i < personList.get(personName).size()-1; i++) {
            Borrow borrow1= personList.get(personName).get(i);

            for (int j = i+1; j < personList.get(personName).size(); j++) {
                //if disk names were equals
                Borrow borrow2= personList.get(personName).get(j);
                if(borrow1.getDiskName().equals(borrow2.getDiskName())){
                    fine+= t * Person.getLateDays(borrow1.getDate(),borrow2.getDate());
                }
            }
        }
        return fine;
    }
}
