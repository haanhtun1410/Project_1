/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilsHuy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huyki
 */
public class Xdate {
    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

//     lấy thời gian hiện tại
    public static Date now() {
        return new Date();
    }

//    convert String => Date
//    date là String cần chuyển
//    pattern là định dạng thời gian
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return Xdate.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

//    chuyển đổi từ date sang String
//    date là String cần chuyển
//    pattern là định dạng thời gian
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = Xdate.now();
        }
        return DATE_FORMATER.format(date);
    }

//     bổ sung số ngày vào thời gian
//    date là thời gian hiện có
//    days là số ngày cần bổ sung vào date
    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

//    bổ sung ngày vào thời gian hiện hành
//    days là số ngày cần bổ sung vào thời gian hiện hành
    public static Date add(int days) {
        Date now = Xdate.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }
}
