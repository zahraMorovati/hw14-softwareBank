package ir.maktab.univercityDiskBank.model;

import java.util.Objects;

public class Borrow {
    private String disk;
    private Date date;

    public Borrow(String disk, Date date) {
        this.disk = disk;
        this.date = date;
    }

    public String getDiskName() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isLate(Date deliveryDate){
        return (deliveryDate.getDatesDistance(this.date)) >= 7;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "disk='" + disk + '\'' +
                ", date=" + date.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(disk, borrow.disk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disk);
    }
}
