package co.usa.reto3.reto3.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user",indexes = @Index(name = "index_email",columnList = "user_email",unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email",nullable = false)
    private String email;
    @NonNull
    @Column(name = "user_password",nullable = false)
    private String password;
    @NonNull
    @Column(name = "user_name",nullable = false)
    private String name;


}
