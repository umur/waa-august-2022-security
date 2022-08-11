package miu.edu.Assignment3.DTOs.BuisnessLogicDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Address;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Review;

import java.util.List;


@Data
@ToString
@NoArgsConstructor
public class UserDTO extends BasicEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    private Address address;
    private List<Review> userReviews;

    public void createReview(Review review){
        userReviews.add(review);
    }
}
