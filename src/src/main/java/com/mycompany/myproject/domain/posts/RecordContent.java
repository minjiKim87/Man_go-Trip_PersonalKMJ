package com.mycompany.myproject.domain.posts;

import com.mycompany.myproject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class RecordContent extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer date;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private Records record;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String hashtag;

    @OneToMany(mappedBy = "record", cascade = CascadeType.ALL)
    private List<RecordContent> recordContents = new ArrayList<>();
    //record_content 테이블과의 관계 나타내줘야한다

    @Builder
    public RecordContent(Integer date, Records record, String content, String hashtag) {
        this.date = date;
        this.record = record;
        this.content = content;
        this.hashtag = hashtag;
    }
}
