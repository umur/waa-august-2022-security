package edu.miu.entity;

import edu.miu.jwt.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName name;

    @Override
    public String getAuthority() {
        return this.name.name();
    }

    public Role(RoleName name) {
        this.name = name;
    }
}
