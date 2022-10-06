package kblab.domain;

import kblab.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="labs", path="labs")
public interface LabRepository extends PagingAndSortingRepository<Lab, Long>{

}
