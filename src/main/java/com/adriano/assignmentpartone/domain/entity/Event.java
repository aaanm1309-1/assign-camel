package com.adriano.assignmentpartone.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class Event {

        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        private UUID eventId;

        @Column
        private String transId;

        @Column
        private LocalDateTime transTms;

        @Column
        private String transTmsTimeZone;

        @Column
        private String rcNum;

        @ManyToOne
        @Valid
        private Client client;

        @Column
        private Long eventCnt;

        @Column
        private String locationCd;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "eventLocation",
            joinColumns = @JoinColumn(name="eventId"),
            inverseJoinColumns = @JoinColumn(name="locationId"))
        private List<Location> locations = new ArrayList<>();

        @Column
        private String addrNbr;

}
