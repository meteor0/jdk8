package com.example.jdk.demo07datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Test01 {
    public static void main(String[] args) {
        /**
         * 1. 设计不合理
         */
        Date now = new Date(1985, 9, 23);
        System.out.println(now);

        /**
         * 线程不完全
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    Date date = sdf.parse("2020-09-09");
                    System.out.println("date=" + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        testLocalDate();
    }

    public static void testLocalDate() {
        //当前时间
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //指定时间
        LocalDate date = LocalDate.of(2018, 12, 12);
        System.out.println(date);
        //获取指定时间
        System.out.println("year= " + now.getYear());
        System.out.println("month= " + now.getMonthValue());
        System.out.println("date= " + now.getDayOfMonth());

    }

    public static void testLocalTime() {
        //LocalTime 表示时间,有时分秒
        //当前时间
        LocalTime nowTime =LocalTime.now();
        System.out.println(nowTime);

        //指定时间
        LocalTime localTime =LocalTime.of(13,22,34);
        System.out.println(localTime);

        //获取时间
        System.out.println(nowTime.getHour());
        System.out.println(nowTime.getMinute());
        System.out.println(nowTime.getSecond());
        System.out.println(nowTime.getNano());
    }

    public static void testLocalDateTime() {
        //LocalDateTime LocalDate+LocalTime,有年月日 时分秒
        //当前时间
        LocalDateTime nowDateTime =LocalDateTime.now();
        System.out.println(nowDateTime);

        //指定时间
        LocalDateTime localTime =LocalDateTime.of(2018,7,23,13,22,34);
        System.out.println(localTime);

        //获取时间
        System.out.println("year= " + nowDateTime.getYear());
        System.out.println("year= " + nowDateTime.getMonthValue());
        System.out.println("date= " + nowDateTime.getDayOfMonth());
        System.out.println(nowDateTime.getHour());
        System.out.println(nowDateTime.getMinute());
        System.out.println(nowDateTime.getSecond());
        System.out.println(nowDateTime.getNano());
    }

    /**
     * 修改时间
     */
    @Test
    public void editLocalDateTime(){
        LocalDateTime nowDateTime =LocalDateTime.now();
        //修改后返回新的时间
        LocalDateTime localDateTime = nowDateTime.withYear(9102);
        System.out.println("nowDateTime= " + nowDateTime);
        System.out.println("localDateTime= " + localDateTime);

        //增年份: plus
        LocalDateTime plusYears = nowDateTime.plusYears(2);
        System.out.println("years+2 ="+plusYears);
        //减年份: minus
        LocalDateTime minusYears = nowDateTime.minusYears(2);
        System.out.println("years-2 ="+minusYears);

    }

    /**
     * 比较时间
     */
    @Test
    public void compareLocalDateTime(){
        LocalDateTime nowDateTime =LocalDateTime.now();
        LocalDateTime localTime =LocalDateTime.of(2018,7,23,13,22,34);

        System.out.println(nowDateTime.isAfter(localTime));
        System.out.println(nowDateTime.isBefore(localTime));
        System.out.println(nowDateTime.isEqual(localTime));
    }

    /**
     * 日期格式化
     */
    @Test
    public void formatLocalDateTime(){
        LocalDateTime nowDateTime =LocalDateTime.now();
       //格式化,指定时间的格式,jdk 自带的格式
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        String format = nowDateTime.format(isoDateTime);
        System.out.println(format);
        //指定格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter);

        //解析
        LocalDateTime parse = LocalDateTime.parse("2017-09-09 15:13:23",dateTimeFormatter);
        System.out.println(parse);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                LocalDateTime parse2 = LocalDateTime.parse("2017-09-09 15:13:23",dateTimeFormatter);
                System.out.println("parse2 ="+parse2);
            }).start();
        }
    }

    /**
     * 获取秒/纳秒
     */
    @Test
    public void testInstant(){
        //instant 内部保存了秒和纳秒,一般不是给用户使用的,而是方便我们程序做一些统计
        Instant now = Instant.now();
        System.out.println(now);
        //增加秒
        Instant plus = now.plusSeconds(20);
        //减少秒
        Instant minus = now.minusSeconds(120);
        //获取秒/纳秒
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
    }

    @Test
    public void testDuration(){
        //Duration 计算时间的间隔
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localTime =LocalDateTime.of(2018,7,23,13,22,34);
        Duration duration = Duration.between(now, localTime);
        System.out.println("相差的天数:" + duration.toDays());
        System.out.println("相差的小时数:" + duration.toHours());
        System.out.println("相差的分钟数:" + duration.toMinutes());
        System.out.println("相差的秒数:" + duration.toMillis());

        //pperiod日期日期的间隔
        LocalDate now1 = LocalDate.now();
        LocalDate localDate = LocalDate.of(2018, 12, 12);
        //between 让后面的时间减去前面的时间
        Period period = Period.between(localDate, now1);
        System.out.println("相差的年数:" + period.getYears());
        System.out.println("相差的月份:" + period.getMonths());
        System.out.println("相差的天数:" + period.getDays());
    }

    @Test
    public void testTemporalAdjuster(){
        //将日期调整到下一个月的第一天
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);
    }

    @Test
    public void testZonedDate(){
        // 获取所有的时区id
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        //不带时区
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: "+now);
        
        //带时区 标准世界时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("zonedDateTime: "+zonedDateTime);

        //now(): 使用计算机的默认时区
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
        System.out.println("zonedDateTime2: "+zonedDateTime2);

        //指定的时区创建时间
        ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("America/Vancouver"));
        System.out.println("zonedDateTime3: "+zonedDateTime3);

        //修改时区,时间
        ZonedDateTime withZoneSameInstant = zonedDateTime2.withZoneSameInstant(ZoneId.of("Asia/ShangHai"));
        System.out.println("withZoneSameInstant: "+withZoneSameInstant);

        //只改时区 不改时间
        ZonedDateTime withZoneSameLocal = zonedDateTime2.withZoneSameLocal(ZoneId.of("Asia/ShangHai"));
        System.out.println("withZoneSameLocal: "+withZoneSameLocal);

    }
}
