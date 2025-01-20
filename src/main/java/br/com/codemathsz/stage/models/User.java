package br.com.codemathsz.stage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Email(message = "O campo [email] deve conter um email válido")
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private LocalDate birthDate;
    @Column(unique = true)
    private String document;


    @OneToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;
    @Column(name = "role_id", nullable = false)
    private UUID role_id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;
}
