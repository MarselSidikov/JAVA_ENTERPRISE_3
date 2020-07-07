package ru.itdrive.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itdrive.web.models.Room;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 26.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
    private Long id;
    private String name;
    private String creatorName;
    private Long messagesCount;

    public static RoomDto from(Room room) {
        return RoomDto.builder()
                .creatorName(room.getCreator().getUsername())
                .name(room.getName())
                .id(room.getId())
                .messagesCount((long) room.getMessages().size())
                .build();
    }

    public static List<RoomDto> from(List<Room> rooms) {
        return rooms.stream()
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }
}
