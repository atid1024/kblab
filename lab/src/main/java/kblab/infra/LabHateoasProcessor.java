package kblab.infra;
import kblab.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class LabHateoasProcessor implements RepresentationModelProcessor<EntityModel<Lab>>  {

    @Override
    public EntityModel<Lab> process(EntityModel<Lab> model) {

        
        return model;
    }
    
}
