package com.example.board.model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class commentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentIdx;

    @Column(nullable = false)
    private String commentContent;

    @Column
    private LocalDateTime commentCreateDt;

    @Column
    private LocalDateTime commentUpdateDt;

    @Column(nullable = false)
    private Boolean commentIsDelete;

    @Column(nullable = false)
    private Integer commentPw;

    @Column(nullable = false)
    private Integer memberIdx;

}
