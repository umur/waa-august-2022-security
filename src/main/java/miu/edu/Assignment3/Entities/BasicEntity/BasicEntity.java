package miu.edu.Assignment3.Entities.BasicEntity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
//    @Column(name = "created_at", nullable = false, updatable = false)
    @Column(name = "created_at")
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedDate;

    @Version
    private Integer version;
}
