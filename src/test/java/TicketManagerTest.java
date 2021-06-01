import domain.Ticket;
import manager.TicketManager;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    TicketManager manager=new TicketManager(new TicketRepository());

    @Test
    public void IfArrayNothing() {
        Ticket[] tickets= manager.findAll("LED", "DME");
        Ticket[] expected=new Ticket[0];
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithOneTicketCorrectFromTo(){
        Ticket ticket=new Ticket(1,100500,"LED","DME",95);
        manager.add(ticket);
        Ticket [] tickets=manager.findAll("LED", "DME");
        Ticket[] expected=new Ticket[]{ticket};
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithOneTicketIncorrectFromTo(){
        Ticket ticket=new Ticket(1,100500,"DME","LED",95);
        manager.add(ticket);
        Ticket [] tickets=manager.findAll("LED", "DME");
        Ticket[] expected=new Ticket[0];
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithMixedTicketsCorrectFromTo(){
        Ticket ticket1=new Ticket(1,100500,"LED","DME",95);
        manager.add(ticket1);
        Ticket ticket2=new Ticket(2,100500,"DME","LED",95);
        manager.add(ticket2);
        Ticket ticket3=new Ticket(3,99999,"DME","LED",95);
        manager.add(ticket3);
        Ticket [] tickets=manager.findAll("DME","LED");
        Ticket[] expected=new Ticket[]{ticket3, ticket2};
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithMixedTicketsNothingFromTo(){
        Ticket ticket1=new Ticket(1,100500,"LED","DME",95);
        manager.add(ticket1);
        Ticket ticket2=new Ticket(2,100500,"DME","LED",95);
        manager.add(ticket2);
        Ticket ticket3=new Ticket(3,99999,"DME","LED",95);
        manager.add(ticket3);
        Ticket [] tickets=manager.findAll("VKO", "BAX");
        Ticket[] expected=new Ticket[0];
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithMixedTicketsCorrectFromIncorrectTo(){
        Ticket ticket1=new Ticket(1,100500,"LED","DME",95);
        manager.add(ticket1);
        Ticket ticket2=new Ticket(2,100500,"DME","LED",95);
        manager.add(ticket2);
        Ticket ticket3=new Ticket(3,99999,"DME","LED",95);
        manager.add(ticket3);
        Ticket [] tickets=manager.findAll("DME", "BAX");
        Ticket[] expected=new Ticket[0];
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void IfArrayWithMixedTicketsInCorrectFromCorrectTo(){
        Ticket ticket1=new Ticket(1,100500,"LED","DME",95);
        manager.add(ticket1);
        Ticket ticket2=new Ticket(2,100500,"DME","LED",95);
        manager.add(ticket2);
        Ticket ticket3=new Ticket(3,99999,"DME","LED",95);
        manager.add(ticket3);
        Ticket [] tickets=manager.findAll("BAX", "DME");
        Ticket[] expected=new Ticket[0];
        assertArrayEquals(expected,tickets);
    }
    @Test
    public void ShouldSortByCost(){
        Ticket ticket1=new Ticket(1,100500,"DME","LED",95);
        manager.add(ticket1);
        Ticket ticket2=new Ticket(2,100500,"LED","DME",95);
        manager.add(ticket2);
        Ticket ticket3=new Ticket(3,99999,"DME","LED",95);
        manager.add(ticket3);
        Ticket [] tickets=manager.findAll("DME","LED");
        Ticket[] expected=new Ticket[]{ticket3,ticket1};
        for(Ticket ticket:tickets){
        System.out.println(ticket);}
        assertArrayEquals(expected,tickets);
    }
}
