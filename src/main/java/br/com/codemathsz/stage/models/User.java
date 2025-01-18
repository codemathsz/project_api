package br.com.codemathsz.stage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Email(message = "O campo [email] deve conter um email válido")
    private String email;
    private String password;
    private LocalDate birthDate;
    @Column(unique = true)
    private String document;


    @OneToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Roles role;
    @Column(name = "role_id", nullable = false)
    private UUID role_id;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
