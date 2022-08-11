package miu.edu.Assignment3.GenericProcess;

import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CrudService<TDto> {

    List<TDto> getAll();
}
