package com.glober.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
}