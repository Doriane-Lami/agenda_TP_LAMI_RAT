package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    private LocalDate end ;
    private long nbIteration;

    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
         end = terminationInclusive;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        nbIteration = numberOfOccurrences;
    }

    /**
     *
     * @return the termination date of this repetitive event
     */

    public LocalDate getTerminationDate(){
        if(end != null){
            return end;
        }else {
            return (this.getStart().plus(getNumberOfOccurrences()-1, getFrequency())).toLocalDate();
        }
    }


    /**
     *
     * @return the number of occurences of this repetitive event
     */

    public long getNumberOfOccurrences() {
        if(nbIteration == 0){
            return nbIteration;
        }else{
            return getDuration().dividedBy(getFrequency().getDuration());
        }

    }


    public boolean isInDay(LocalDate aDay) throws Exception {
        LocalDateTime start = this.getStart();
        int occurence = 0;
        while (aDay.atStartOfDay().isBefore(start)) {
            if (occurence < this.getNumberOfOccurrences()) {
                if (this.getStart().equals(aDay.atStartOfDay())) {
                    return true;
                } else if (this.getStart().plus(this.getDuration()).isAfter(aDay.atStartOfDay()) && this.getStart().isBefore(aDay.atStartOfDay())) {
                    return true;
                } else {
                    start = start.plus(1, getFrequency());
                }
            } else {
                return false;
            }
        }
        return false;
    }
        
}
