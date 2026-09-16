package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USER_BIO", schema = "kino-demo")
public class AuthUserBio {
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String surname;

    private String email;

    @Column(name = "birthDate")
    private LocalDate birth_date;

    @Column(name = "createdAt")
    public LocalDate created_at;

    @Column(name = "updatedAt")
    public LocalDate updated_at;
}
