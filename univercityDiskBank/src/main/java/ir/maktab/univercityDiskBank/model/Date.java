package ir.maktab.univercityDiskBank.model;

import java.util.Objects;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date() {}

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //region @getter&setter
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //endregion
    public static final class DateBuilder {
        private final Date date;

        private DateBuilder() {
            date = new Date();
        }

        public static DateBuilder aDate() {
            return new DateBuilder();
        }

        public DateBuilder setYear(int year) {
            date.setYear(year);
            return this;
        }

        public DateBuilder setMonth(int month) {
            date.setMonth(month);
            return this;
        }

        public DateBuilder setDay(int day) {
            date.setDay(day);
            return this;
        }

        public DateBuilder but() {
            return aDate().setYear(date.getYear()).setMonth(date.getMonth()).setDay(date.getDay());
        }

        public Date build() {
            return date;
        }
    }

    public static boolean isValidDate(int year, int month, int day) {

        if (year < 9999 && year >= 1) {
            if (month <= 12 && month >= 1) {
                return day <= getMonthLastDay(month) && day >= 1;
            }
        }
        return false;
    }
    public static int getMonthLastDay(int month) {
        for (MonthName name : MonthName.values()) {
            if (name.monthNumber == month) {
                return name.monthLastDay;
            }
        }
        return -1;
    }
    public static MonthName getMonthName(int month) {
        for (MonthName name : MonthName.values()) {
            if (name.monthNumber == month) {
                return name;
            }
        }
        return null;
    }
    public void nextDay() {
        if (day == getMonthLastDay(month)) {
            if (month == 12) {
                setMonth(1);
                setDay(1);
                setYear(year + 1);
            } else {
                setMonth(month + 1);
                setDay(1);
            }
        } else {
            setDay(day + 1);
        }
    }

    public String toString() {
        return (year + "/" + month + "/" + day);
    }

    public enum MonthName {
        FARVARDIN(31, 1),
        ORDIBEHESHT(31, 2),
        KHORDAD(31, 3),
        TIR(31, 4),
        MORDAD(31, 5),
        SHAHRIVAR(31, 6),
        MEHR(30, 7),
        ABAN(30, 8),
        AZAR(30, 9),
        DEY(30, 10),
        BAHMAN(30, 11),
        ESFAND(29, 12);

        int monthLastDay;
        int monthNumber;

        MonthName(int monthLastDay, int monthNumber) {
            this.monthLastDay = monthLastDay;
            this.monthNumber = monthNumber;
        }
    }

    public int compare(Date date2) {
        Date date1 = new Date(this.year, this.month, this.day);
        if (date1.getYear() > date2.getYear()) {
            return 1;
        } else if (date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() > date2.getMonth()) {
                return 1;
            } else if (date1.getMonth() < date2.getMonth()) {
                return -1;
            } else if (date1.getMonth() == date2.getMonth()) {
                if (date1.getDay() > date2.getDay()) {
                    return 1;
                } else if (date1.getDay() < date2.getDay()) {
                    return -1;
                } else if (date1.getDay() == date2.getDay()) {
                    return 0;
                }
            }
        }
        throw new RuntimeException("cannot compare dates!");
    }
    public long getDaysOfMonths() {
        long days = 0;
        for (int i = 1; i < this.month; i++) {
            days += getMonthLastDay(i);
        }
        return days;
    }
    public long getDatesDistance(Date date) {
        int compareResult = this.compare(date);
        if (compareResult == 0) {
            return 0;
        } else {
            long daysOfCurrentDate = this.getDaysOfMonths() + this.day;
            long daysOfInputDate = date.getDaysOfMonths() + date.getDay();
            if (this.year > date.getYear()) {
                daysOfCurrentDate += (this.year - date.getYear()) * 365L;
            }else if (this.year < date.getYear()){
                daysOfInputDate += (date.getYear() - this.year) * 365L;
            }
            return (daysOfCurrentDate - daysOfInputDate)+1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
