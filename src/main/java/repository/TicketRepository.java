package repository;

import domain.Ticket;
import exception.NotFoundException;

import java.util.Arrays;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);

        int lastTicket = tmp.length - 1;
        tmp[lastTicket] = ticket;
        tickets = tmp;

    }

    public Ticket[] findAll(String from, String to) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                count++;
            }
        }
        Ticket[] tmp = new Ticket[count];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                tmp[index] = ticket;
                index++;
            }
        }
        Arrays.sort(tmp);
        tickets = tmp;
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if ((ticket.getId() == id))
                return ticket;
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("product with id=" + id + " not found");
        }

        if (tickets.length == 0) {
            return;
        }

        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if ((ticket.getId() != id)) {
                tmp[index] = ticket;
            }
        }
        tickets = tmp;

    }
}