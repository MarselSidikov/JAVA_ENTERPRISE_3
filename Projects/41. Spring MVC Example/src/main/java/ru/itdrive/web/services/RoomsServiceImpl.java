package ru.itdrive.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itdrive.web.dto.RoomDto;
import ru.itdrive.web.repositories.RoomsRepository;

import java.util.List;

import static ru.itdrive.web.dto.RoomDto.from;

/**
 * 26.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<RoomDto> search(String name, String creatorName, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        return from(roomsRepository.findAllByNameIgnoreCaseContainsAndCreator_UsernameIgnoreCaseContains(name, creatorName, pageRequest));
    }

    @Override
    public List<RoomDto> getAll() {
        return roomsRepository.findAllWithoutSubEntitiesAsDto();
    }
}
