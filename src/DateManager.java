import java.time.LocalDateTime;
import java.util.ArrayList;

public class DateManager {

    public static ArrayList<Integer> GetDate() {
        ArrayList<Integer> list = new ArrayList<>();
        String date = LocalDateTime.now().toString();
        String[] format = date.split("-");
        String[] findday = format[2].split("T");
        list.add(Integer.parseInt(findday[0])); //day
        list.add(Integer.parseInt(format[1])); //month
        list.add(Integer.parseInt(format[0])); //year
        return list;
    }

    public static String GetDateTime() {
        ArrayList<Integer> list = new ArrayList<>();
        String date = LocalDateTime.now().toString();
        String[] format = date.split("-");
        String[] findday = format[2].split("T");
        return findday[1];
    }

    public static String GetDateString() {
        ArrayList<String> list = new ArrayList<>();
        String date = LocalDateTime.now().toString();
        String[] format = date.split("-");
        String[] findday = format[2].split("T");
        String datetime = getMonth(Integer.parseInt(format[1])) + " " + findday[0] + ". " + format[0];
        return datetime;
    }

    public static String getMonth(int month) {
        String returnString = "";
        if (month == 1) {
            returnString = "January";
        } else
        if (month == 2) {
            returnString = "February";
        } else
        if (month == 3) {
            returnString = "March";
        } else
        if (month == 4) {
            returnString = "April";
        } else
        if (month == 5) {
            returnString = "May";
        } else
        if (month == 6) {
            returnString = "June";
        } else
        if (month == 7) {
            returnString = "July";
        } else
        if (month == 8) {
            returnString = "August";
        } else
        if (month == 9) {
            returnString = "September";
        } else
        if (month == 10) {
            returnString = "October";
        } else
        if (month == 11) {
            returnString = "November";
        } else
        if (month == 12) {
            returnString = "December";
        }
        return returnString;
    }
}
