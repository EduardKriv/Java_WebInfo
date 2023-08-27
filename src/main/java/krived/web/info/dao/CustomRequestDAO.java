package krived.web.info.dao;

import krived.web.info.model.ModelCustomTable;
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
    private enum Position { NONE, FUNCTION, PROCEDURE }
    private final JdbcTemplate jdbcTemplate;

    public ModelCustomTable executeQuery(String query) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             Statement statement = con.createStatement()) {
            return parseResultSet(statement.executeQuery(query));
        }
    }

    public ModelCustomTable executeFunction(String query, Object... args) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            setParams(statement, Position.FUNCTION.ordinal(), args);
            return parseResultSet(statement.executeQuery());
        }
    }

    public ModelCustomTable callProcedure(String query, Object... args) throws SQLException {
        try (Connection con = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             CallableStatement statement = con.prepareCall(query)) {
            con.setAutoCommit(false);
            statement.registerOutParameter(1, Types.REF_CURSOR);
            setParams(statement, Position.PROCEDURE.ordinal(), args);
            statement.execute();
            return parseResultSet((ResultSet) statement.getObject(1));
        }
    }

    private ModelCustomTable parseResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();

        String[] columnNames = new String[columns];
        for (int i = 1; i <= columns; ++i) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        List<String[]> tableBody = new ArrayList<>();
        while (rs.next()) {
            String[] tmp = new String[columns];
            for (int i = 1; i <= columns; i++) {
                tmp[i - 1] = rs.getObject(i).toString();
            }
            tableBody.add(tmp);
        }
        return new ModelCustomTable(columnNames, tableBody);
    }

    private void setParams(PreparedStatement statement, int position, Object... params) throws SQLException {
        if (params != null) {
            for (Object param : params) {
                statement.setObject(position, param);
                position++;
            }
        }
    }
}
