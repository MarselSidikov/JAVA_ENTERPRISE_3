package ru.itdrive.web.models;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.Root;
import java.util.Set;

/**
 * 19.06.2020
 * 42. Hibernate Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"creator", "users"})
@EqualsAndHashCode(exclude = {"creator", "users"})
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private String name;

    @ManyToMany
    @JoinTable(name = "account_room",
            joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private Set<User> users;

    @OneToMany(mappedBy = "room")
    private Set<Message> messages;
}
