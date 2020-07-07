package ru.itdrive.web.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itdrive.web.dto.RoomDto;
import ru.itdrive.web.models.Room;

import java.util.List;

/**
 * 24.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface RoomsRepository extends JpaRepository<Room, Long> {

    @Query("select new ru.itdrive.web.dto.RoomDto(room.id, room.name, room.creator.username, count(messages)) from Room room " +
            "left join room.messages as messages " +
            "group by room.id, room.creator.username")
    List<RoomDto> findAllWithoutSubEntitiesAsDto();

    List<Room> findAllByNameAndCreator_Email(String name, String creatorEmail);

    List<Room> findAllByNameIgnoreCaseContainsAndCreator_UsernameIgnoreCaseContains(String roomName, String userName, Pageable pageable);
}
