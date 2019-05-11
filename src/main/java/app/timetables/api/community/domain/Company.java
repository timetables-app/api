package app.timetables.api.community.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate founded;

    @Column(nullable = false)
    private LocalDateTime registered;

    @Column(nullable = false)
    private Boolean approved;
}
