package shop.mtcoding.blog.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class DateTest {

    @Test
    public void timestampFormat_test(){
        // given
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());

        // when
        String createdAt = MyDateUtil.timestampFormat(currentTimeStamp);

        // then
        System.out.println("timestampFormat_test : " + createdAt);
    }

    @Test
    public void format_test(){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Date currentDate = new Date(currentTimestamp.getTime());

        String formattedDate = DateFormatUtils.format(currentDate, "yyyy-MM-dd HH:mm");

        System.out.println("foramt_test : " + formattedDate);

    }
}
