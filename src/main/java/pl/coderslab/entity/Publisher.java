package pl.coderslab.entity;

import lombok.Data;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, message = "{size.name.publisher.min}")
    private String name;

    @NIP(message = "{wrong.nip}")
    private String nip;

    @REGON(message = "{wrong.regon}")
    private String regon;
}
