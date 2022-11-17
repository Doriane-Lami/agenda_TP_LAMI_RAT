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
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) throws Exception {
        if (this.getStart().equals(aDay)) {
            return true;
        } else {
            LocalDate d2 = aDay.plus(this.getDuration());
            long j = ChronoUnit.DAYS.between(this.getStart(), d2);
            while(j>0){
                if ((d2.equals(aDay)){
                    return true;
                }
                j=j-1;
                d2 = d2.minus(1, ChronoUnit.DAYS);
            }
            if(jour == false){
                if (this.myStart.before(aDay)) {
                    throw new java.lang.Exception("L'évenement a lieu avant");
                } else {
                    throw new java.lang.Exception("L'évenement a lieu après");
                }
                return false;
            }
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
