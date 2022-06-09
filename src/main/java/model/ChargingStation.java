package main.java.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @ToString.Exclude
    private Address addr;
    private Double review;
    @Enumerated
    @ElementCollection(targetClass = Plugs.class)
    private List<Plugs> availablePlugs;
    private Double price;

    public String[] toTableObj() {
        return new String[]{
                this.name,
                this.addr.getState(),
                this.addr.getCity(),
                this.review.toString(),
                this.price.toString(),
                this.id.toString()
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChargingStation that = (ChargingStation) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
