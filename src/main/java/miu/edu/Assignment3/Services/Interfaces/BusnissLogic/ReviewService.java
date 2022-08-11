package miu.edu.Assignment3.Services.Interfaces.BusnissLogic;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.ReviewDTO;


import java.util.List;

public interface ReviewService {
    void save(ReviewDTO reviewDTO);

    void delete(int id);

    ReviewDTO getById(int id);

    List<ReviewDTO> getAll();
}
