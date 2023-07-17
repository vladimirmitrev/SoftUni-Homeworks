package hiberspring.service;

import hiberspring.domain.entities.EmployeeCard;

import java.io.IOException;

public interface EmployeeCardService {

    Boolean employeeCardsAreImported();

    String readEmployeeCardsJsonFile() throws IOException;

    String importEmployeeCards(String employeeCardsFileContent) throws IOException;

    EmployeeCard findEmployeeCardByNumber(String card);
}
