package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;

    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The duration of the event
     */
    private Duration myDuration;

    /**
     * boolean
     */
    private boolean jour;

    /**
     * Constructs an event
     *
     * @param title    the title of this event
     * @param start    the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    public String toString(){
        return myTitle;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */

    public boolean isInDay(LocalDate aDay) throws Exception {

        if (this.getStart().getDayOfYear() == (aDay.atStartOfDay()).getDayOfYear()) {
            return true;
        }else if(this.getStart().plus(this.getDuration()).isAfter(aDay.atStartOfDay()) && this.getStart().isBefore(aDay.atStartOfDay())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the myTitle
     */

    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }


}
