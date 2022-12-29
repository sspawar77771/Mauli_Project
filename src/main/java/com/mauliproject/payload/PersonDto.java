package com.mauliproject.payload;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class PersonDto {

    @NotNull
    private Integer personId;

    @NotNull
    @Size(min = 3,message = "Enter a valid name")
    private String fullName;

    @NotNull
    @Size(min = 3,message = "Fill complete address with pincode")
    private String fullAddress;

    @NotNull
    @Size(min = 10,max = 10,message = "Enter valid Mobile Number")
    private long mobile_no;

    @NotNull
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @Size(min = 8,message = "Enter valid email id")
    private String email;

    @NotNull
    private Integer donationAmount;

    @NotNull
    private LocalDateTime dateTime;

}
