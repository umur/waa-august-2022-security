package miu.edu.Assignment3.GenericProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class CrudController<TService extends CrudService, TDto> {

    @Autowired
    private TService service;

    @GetMapping
    public List<TDto> getAll(){
        return  service.getAll();
    }

}
