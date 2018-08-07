package com.yanziting.basiclearning.learningenum;

import org.springframework.stereotype.Component;

/**
 * 枚举Demo
 *
 * @author : Ziting.Yan
 * @since : 2018-08-07-15-11
 **/
@Component
public class MyEnumDemo {

    public void getWeek() {
        Week week = Week.SATURDAY;
        Week week1 = Week.valueOf("FRIDAY");

        System.out.println(week.getValue());
        System.out.println(week1.getValue());
    }

    public void printDistinctWeek(Week week) {
        switch (week) {
            case MONDAY:
                System.out.println(Week.MONDAY.getValue());
                break;
            case TUESDAY:
                System.out.println(Week.TUESDAY.getValue());
                break;
            case WEDNESDAY:
                System.out.println(Week.WEDNESDAY.getValue());
                break;
            case THURSDAY:
                System.out.println(Week.THURSDAY.getValue());
                break;
            case FRIDAY:
                System.out.println(Week.FRIDAY.getValue());
                break;
            case SATURDAY:
                System.out.println(Week.SATURDAY.getValue());
                break;
            case SUNDAY:
                System.out.println(Week.SUNDAY.getValue());
                break;
            default:
                break;
        }
    }

    public enum Week {
        /**
         * 周一
         */
        MONDAY("Monday"),
        /**
         * 周二
         */
        TUESDAY("Tuesday"),
        /**
         * 周三
         */
        WEDNESDAY("Wednesday"),
        /**
         * 周四
         */
        THURSDAY("Thursday"),
        /**
         * 周五
         */
        FRIDAY("Friday"),
        /**
         * 周六
         */
        SATURDAY("Saturday"),
        /**
         * 周日
         */
        SUNDAY("Sunday");

        private String value;

        Week(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
