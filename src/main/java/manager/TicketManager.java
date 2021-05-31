package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to, Comparator <Ticket> comparator) {
        return repository.findAll(from, to, comparator);
    }
}
