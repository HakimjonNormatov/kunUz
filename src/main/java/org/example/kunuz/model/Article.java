package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String sharedCount;
    @Column(nullable = false)
    private Long imageId;
    @ManyToOne
    private Region regionId;
    @ManyToMany
    private List<Category> categoryId;
    @Column(nullable = false)
    private Long moderatorId;
    @Column(nullable = false)
    private Long publisherId;
    @Column(nullable = false)
    private String status;
    @CreatedDate
    private Date createdDate;
    @CreatedDate
    private Date publishedDate;
    @Column(nullable = false)
    private String visible;
    @Column(nullable = false)
    private Long viewCount;

}
