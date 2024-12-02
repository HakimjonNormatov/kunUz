package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long orderNumber;
    @Column(nullable = false)
    private String name_uz;
    @Column(nullable = false)
    private String name_ru;
    @Column(nullable = false)
    private String name_eng;
    @Column(nullable = false)
    private String visible;
    @CreatedDate
    private Date createdDate;
}
