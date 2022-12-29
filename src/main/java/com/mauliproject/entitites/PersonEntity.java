package com.mauliproject.entitites;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;

    @Column(name = "Person_Full_Name")
    private String fullName;

    @Column(name = "Address")
    private String fullAddress;

    @Column(name = "Mobile_NO")
    private long mobile_no;

    @Column(name = "Email")
    private String email;

    @Column(name = "Donation_Amount")
    private Integer donationAmount;

    @Column(name = "Date_of_Donation")
    private LocalDateTime dateTime;

}
