package ir.maktab.univercityDiskBank.model;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getLateDays(Date borrow,Date deliver){
        long days=deliver.getDatesDistance(borrow);
        if(days>7){
            return days-7;
        }else return 0;
    }

    public Borrow borrow(Disk disk,Date date){
        return new Borrow(disk.getName(),date);
    }

    public Borrow deliver(Disk disk,Date date){
        return new Borrow(disk.getName(),date);
    }
}
