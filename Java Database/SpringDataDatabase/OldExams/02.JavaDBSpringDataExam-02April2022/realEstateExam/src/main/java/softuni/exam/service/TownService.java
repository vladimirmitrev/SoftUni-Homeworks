package softuni.exam.service;

import softuni.exam.models.entity.Town;

import java.io.IOException;
import java.util.Optional;

// TODO: Implement all methods
public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    Town findByName(String town);

    Town findByTownName(String townName);


}
