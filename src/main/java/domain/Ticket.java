package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int minutes;


    @Override
    public int compareTo(Ticket o) {
        return this.cost-o.cost;
    }

}
