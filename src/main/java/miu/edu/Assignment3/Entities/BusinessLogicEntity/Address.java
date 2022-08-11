package miu.edu.Assignment3.Entities.BusinessLogicEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address extends BasicEntity {

    private String street;
    private String zip;
    private String City;


    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        City = city;
    }
}
