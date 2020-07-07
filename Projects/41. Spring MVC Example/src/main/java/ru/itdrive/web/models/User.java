package ru.itdrive.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "simple_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String confirmCode;


    private String username;

    @ManyToMany(mappedBy = "users")
    private Set<Room> rooms;

    @OneToMany(mappedBy = "author")
    private Set<Message> messages;

    @OneToMany(mappedBy = "creator")
    private Set<Room> createdRooms;
}
