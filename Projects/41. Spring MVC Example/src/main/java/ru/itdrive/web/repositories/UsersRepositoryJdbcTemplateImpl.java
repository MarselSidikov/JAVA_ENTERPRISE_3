package ru.itdrive.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itdrive.web.models.User;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

/**
 * 09.06.2020
 * 40. AjaxSearchExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component(value = "usersRepositoryJdbcTemplateImpl")
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from simple_user";

    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from simple_user where id = ?";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into simple_user(email, password, confirmcode) " +
            "values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE_USER = "update simple_user set email = ?, password = ?, confirmcode = ? " +
            "where id = ?";

    //language=SQL
    private static final String SQL_SEARCH_BY_EMAIL = "select * from simple_user where email ilike ?";

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, rowNumber) ->
            User.builder()
                    .id(row.getLong("id"))
                    .email(row.getString("email"))
                    .confirmCode(row.getString("confirmcode"))
                    .password(row.getString("password"))
                    .build();

    @Autowired
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> searchByEmail(String emailPattern) {
        return jdbcTemplate.query(SQL_SEARCH_BY_EMAIL, userRowMapper, "%" + emailPattern + "%");
    }

    @Override
    public Optional<User> find(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public void save(User entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, new String[]{"id"});
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getConfirmCode());
            return statement;
        }, keyHolder);

        entity.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(SQL_UPDATE_USER, entity.getEmail(),
                entity.getPassword(),
                entity.getConfirmCode(),
                entity.getId());
    }
}
