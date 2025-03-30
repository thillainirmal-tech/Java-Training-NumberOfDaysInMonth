public class NumberOfDaysInMonth {

    public static int getDaysInMonth(int month, int year) {
        if (year < 1 || year > 9_999) {
            return -1;
        }

        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;           // Months with 31 days
            case 2 -> isLeapYear(year) ? 29 : 28;        // February with leap year check
            case 4, 6, 9, 11 -> 30;                      // Months with 30 days
            default -> -1;                               // Invalid month
        };
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9_999) {
            return false;
        }

        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;                            // Leap year if divisible by 4 but not 100
            } else {
                return year % 400 == 0;                 // Leap year if divisible by 400
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test cases:");
        System.out.println("February 2020 (Leap Year): " + getDaysInMonth(2, 2020));  // 29 days
        System.out.println("February 2019: " + getDaysInMonth(2, 2019));              // 28 days
        System.out.println("April 2021: " + getDaysInMonth(4, 2021));                 // 30 days
        System.out.println("December 2025: " + getDaysInMonth(12, 2025));             // 31 days
        System.out.println("Invalid month: " + getDaysInMonth(13, 2025));             // -1 (invalid month)
        System.out.println("Invalid year: " + getDaysInMonth(5, 10000));              // -1 (invalid year)
    }
}
