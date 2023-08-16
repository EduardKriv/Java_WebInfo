package krived.web.info.dao;

import krived.web.info.model.SQLResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomRequestDAO {
    private final JdbcTemplate jdbcTemplate;

    public SQLResponseBody executeQuery(String query) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             Statement statement = con.createStatement()) {

            return parseResultSet(statement.executeQuery(query));
        }
    }

    public SQLResponseBody executeFunction(String query, Object... args) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {

            for (int i = 0; i < args.length; ++i) {
                statement.setObject(i + 1, args[i]);
            }

            return parseResultSet(statement.executeQuery());
        }
    }

    public SQLResponseBody callProcedure(String query, Object... args) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             CallableStatement statement = con.prepareCall(query)) {
            con.setAutoCommit(false);

            for (int i = 0; i < args.length; ++i) {
                statement.setObject(i + 1, args[i]);
            }

            statement.registerOutParameter(1, Types.REF_CURSOR);
            statement.execute();

            return parseResultSet((ResultSet) statement.getObject(1));
        }
    }

    private SQLResponseBody parseResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();

        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= columns; ++i) {
            columnNames.add(metaData.getColumnName(i));
        }

        List<List<Object>> tableBody = new ArrayList<>();
        while (rs.next()) {
            List<Object> tmp = new ArrayList<>();
            for (int i = 1; i <= columns; i++) {
                tmp.add(rs.getObject(i));
            }
            tableBody.add(tmp);
        }

        return new SQLResponseBody(columnNames, tableBody);
    }
}
