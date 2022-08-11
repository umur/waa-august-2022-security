package miu.edu.Assignment3.Entities.BusinessLogicEntity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Review extends BasicEntity {
    private String comment;

    public Review(String comment) {
        this.comment = comment;
    }
}
