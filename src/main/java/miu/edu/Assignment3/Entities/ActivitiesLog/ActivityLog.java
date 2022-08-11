package miu.edu.Assignment3.Entities.ActivitiesLog;

import lombok.Data;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
public class ActivityLog extends BasicEntity {

    @Temporal(TemporalType.TIME)
    private Date loginDate;
    private String operation;
    private long duration;
}
