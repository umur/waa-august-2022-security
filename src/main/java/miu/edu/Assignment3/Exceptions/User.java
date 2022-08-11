package miu.edu.Assignment3.Exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Address;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@ToString
public class User extends BasicEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private List<Review> userReviews;

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public void createReview(Review review){
        userReviews.add(review);
    }
}
