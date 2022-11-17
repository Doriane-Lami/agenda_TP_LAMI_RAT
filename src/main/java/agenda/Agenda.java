package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    private final TreeSet<Event> myEvents = new TreeSet<>();

    // A mettre dans Event ?


    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day to test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        List<Event> eventsofday = new ArrayList<>();
        for(Event e : myEvents){
            if(e.equals(day)){
                eventsofday.add(e);
            }
        }
        return eventsofday;
    }
}
