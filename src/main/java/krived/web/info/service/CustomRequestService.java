package krived.web.info.service;

import krived.web.info.dao.CustomRequestDAO;
import krived.web.info.model.SQLResponseBody;
import krived.web.info.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@RequiredArgsConstructor
public class CustomRequestService {
    private final RequestRepository requestRepository;
    private final CustomRequestDAO customRequestDAO;

    public SQLResponseBody executeQuery(String query) throws SQLException {
        return customRequestDAO.executeQuery(query);
    }

    public SQLResponseBody executeOrCall(Long id, Object... args) throws SQLException {
        String query = requestRepository.getReferenceById(id).getCall();
        if (query.toLowerCase().contains("call"))
            return customRequestDAO.callProcedure(query, args);

        return customRequestDAO.executeFunction(query, args);
    }
}
