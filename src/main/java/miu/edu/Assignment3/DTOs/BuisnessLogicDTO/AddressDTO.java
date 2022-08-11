package miu.edu.Assignment3.DTOs.BuisnessLogicDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class AddressDTO  {

    private String street;
    private String zip;
    private String City;

}
