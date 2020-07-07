package ru.itdrive.web.services;

import ru.itdrive.web.dto.RoomDto;

import java.util.List;

/**
 * 26.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface RoomsService {
    List<RoomDto> search(String name, String creatorName, Integer page, Integer size);

    List<RoomDto> getAll();
}
