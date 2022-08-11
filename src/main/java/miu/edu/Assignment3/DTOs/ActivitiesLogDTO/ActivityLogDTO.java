package miu.edu.Assignment3.DTOs.ActivitiesLogDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class ActivityLogDTO {

    @Temporal(TemporalType.TIME)
    private Date loginDate;
    private String operation;
    private long duration;
}
