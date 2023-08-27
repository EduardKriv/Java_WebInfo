package krived.web.info.service;

import krived.web.info.dao.CustomRequestDAO;
import krived.web.info.model.ModelCustomTable;
import krived.web.info.repository.CustomRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@RequiredArgsConstructor
public class CustomRequestService {
    private final CustomRequestRepository customRequestRepository;
    private final CustomRequestDAO customRequestDAO;

    public ModelCustomTable executeQuery(String query) throws SQLException {
        return customRequestDAO.executeQuery(query);
    }

    public ModelCustomTable executeOrCall(Long id, Object... args) throws SQLException {
        String query = customRequestRepository.getReferenceById(id).getCall();
        if (query.toLowerCase().contains("call"))
            return customRequestDAO.callProcedure(query, args);

        return customRequestDAO.executeFunction(query, args);
    }
}
