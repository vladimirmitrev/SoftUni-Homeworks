package hiberspring.service;

import hiberspring.domain.entities.Branch;

import java.io.IOException;

public interface BranchService {

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent) throws IOException;

    Branch findBranchByName(String branchName);
}
