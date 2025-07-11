package org.sammo.java_collections_framework.map;

import java.util.EnumMap;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapPractice {

    public static void main(String[] args) {

        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        schedule.put(Day.SUNDAY, null);
        schedule.put(Day.MONDAY, "Push");
        schedule.put(Day.THURSDAY, "Push");
        schedule.put(Day.TUESDAY, "Pull");
        schedule.put(Day.FRIDAY, "Pull");
        schedule.put(Day.SATURDAY, "Legs / REST");
        schedule.put(Day.WEDNESDAY, "Legs");

        /* An EnumMap always maintains the order in which enum constants are declared.
        This is because EnumMap internally uses an array where the index corresponds to the ordinal()
        of each enum constant. */

        for (Day day : schedule.keySet()) {
            System.out.println(day + " (" + day.ordinal() + ") → " + schedule.get(day));
        }
    }
}
