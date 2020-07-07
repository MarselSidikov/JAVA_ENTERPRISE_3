package ru.itdrive.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itdrive.web.dto.RoomDto;
import ru.itdrive.web.models.Room;
import ru.itdrive.web.services.RoomsService;

import java.util.List;

/**
 * 26.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class RoomsRestController {

    @Autowired
    private RoomsService roomsService;
    // GET /rooms/search?name=Room&creatorName=Marsel&page=1&size=5
    @RequestMapping("/rooms/search")
    public List<RoomDto> search(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "creatorName", required = false) String creatorName,
                                @RequestParam(value = "page") Integer page,
                                @RequestParam(value = "size") Integer size) {
        return roomsService.search(name, creatorName, page, size);
    }

    @RequestMapping("/rooms")
    public List<RoomDto> getAll() {
        return roomsService.getAll();
    }
}
