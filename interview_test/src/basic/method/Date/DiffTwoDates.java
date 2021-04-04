package basic.method.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Chenglin Ding
 * @Date: 31.03.2021 16:41
 * @Description:
 */
public class DiffTwoDates {
    public static void main(String[] args) {
        String dateStr1 = "2008-1-1 1:20:20";
        String dateStr2 = "2010-1-2 1:21:28";

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try {
            Date date1 = format1.parse(dateStr1);
            Date date2 = format2.parse(dateStr2);

            System.out.println("difference between date1 and date2 "+differenDays(date1,date2));
            System.out.println("using seconds to calculate"+differenDaysByMilliSecond(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static int  differenDays(Date date1, Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);

        if(year1 != year2){
            int timeDistance = 0;
            for(int i = year1; i < year2; i++){
                if(i%4 == 0 && i%100 != 0 || i%400 == 0){
                    timeDistance += 366;
                }
                else{
                    timeDistance += 365;
                }
            }
            return timeDistance+(day2 -day1);
        }else{
            return day2 -day1;
        }

    }

    public static int differenDaysByMilliSecond(Date date1, Date date2){
        int days = (int) ((date2.getTime() - date1.getTime())/(24*3600*1000));
        return days;
    }
}
