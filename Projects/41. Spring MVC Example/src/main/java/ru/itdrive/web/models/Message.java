package ru.itdrive.web.models;

import lombok.*;

import javax.persistence.*;

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
@ToString(exclude = {"author", "room"})
@EqualsAndHashCode(exclude = {"author", "room"})
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  3000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
