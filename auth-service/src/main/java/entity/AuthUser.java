package entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USER", schema = "kino-demo")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String email;

    @Column(name = "passwordHashed")
    private String password_hashed;

    private EnumType role;

    @Column(name = "createdAt")
    public LocalDate created_at;

    @Column(name = "updatedAt")
    public LocalDate updated_at;

}
