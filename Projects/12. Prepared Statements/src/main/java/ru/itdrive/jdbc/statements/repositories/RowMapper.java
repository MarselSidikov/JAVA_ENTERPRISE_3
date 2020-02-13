package ru.itdrive.jdbc.statements.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapRow(ResultSet row) throws SQLException;
}
