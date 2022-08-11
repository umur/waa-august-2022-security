package miu.edu.Assignment3.UtilityClasses;

import miu.edu.Assignment3.DTOs.ActivitiesLogDTO.ActivityLogDTO;
import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.ProductDTO;
import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.UserDTO;
import miu.edu.Assignment3.Entities.ActivitiesLog.ActivityLog;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;
import miu.edu.Assignment3.Exceptions.User;

public final class Mapper {

    public static User ConvertDTOToUser(UserDTO userDTO){
        User userEntity = new User();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setUserReviews(userDTO.getUserReviews());

        return userEntity;
    }
    public static UserDTO ConvertUserToDTO(User userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setAddress(userEntity.getAddress());
        userDTO.setUserReviews(userEntity.getUserReviews());
        return userDTO;
    }

    public static Product ConvertDTOToProduct(ProductDTO productDTO){
        Product productEntity = new Product();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setRating(productDTO.getRating());
        return productEntity;
    }
    public static ProductDTO ConvertProductToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setRating(product.getRating());
        return productDTO;
    }

    public static ActivityLog ConvertDTOToActivityLog(ActivityLogDTO activityLogDTO){
        ActivityLog activityLogEntity = new ActivityLog();
        activityLogEntity.setOperation(activityLogDTO.getOperation());
        activityLogEntity.setDuration(activityLogDTO.getDuration());
        activityLogEntity.setLoginDate(activityLogDTO.getLoginDate());
        return activityLogEntity;
    }

    public static ActivityLogDTO ConvertActivityLogToDTO(ActivityLog activityLog){
        ActivityLogDTO activityLogDTO = new ActivityLogDTO();
        activityLogDTO.setOperation(activityLog.getOperation());
        activityLogDTO.setDuration(activityLog.getDuration());
        activityLogDTO.setLoginDate(activityLog.getLoginDate());
        return activityLogDTO;
    }
}
