package lk.ijse.dep10.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO implements Serializable {
    private int id;
    @NotBlank(message = "name can't be empty")
    private String name;
    @NotBlank(message = "address can't be empty")
    private String address;

    public StudentDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
