package domain;


import java.util.Comparator;

public class TicketByMinutesAscComparator implements Comparator<Ticket> {

    public int compare(Ticket o1, Ticket o2) {
        return o1.getMinutes() - o2.getMinutes();
    }
}