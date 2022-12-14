package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */

    private ChronoUnit frequency;

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */

    // J'arrete l'événement au jour precedent l'exception puis je le recommence au jour suivant l'exception
    public void addException(LocalDate date) {

    }

    public boolean isInDay(LocalDate aDay) throws Exception {
        LocalDateTime start = this.getStart();
        while (aDay.atStartOfDay().isBefore(start)) {
            if (this.getStart().equals(aDay.atStartOfDay())) {
                return true;
            } else if (this.getStart().plus(this.getDuration()).isAfter(aDay.atStartOfDay()) && this.getStart().isBefore(aDay.atStartOfDay())) {
                return true;
            } else {
                start = start.plus(1, frequency);
            }
        }
        return false;
    }

    /**
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

}
