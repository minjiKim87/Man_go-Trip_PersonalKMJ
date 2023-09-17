package com.mycompany.myproject.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
//@Table(name = "RECORD_CONTENT")
public class RecordContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_content_id")
    private Long recordContentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private Records records;

    @Column(columnDefinition = "content")
    private String content;

    private String hashtag;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Builder
    public RecordContent(Records records, String content, String hashtag, Date date) {
        this.records = records;
        this.content = content;
        this.hashtag = hashtag;
        this.date = date;
    }

    public void update(Records records, String content, String hashtag, Date date) {
        this.records = records;
        this.content = content;
        this.hashtag = hashtag;
        this.date = date;

    }

    public void update(String content, String hashtag) {
        this.content = content;
        this.hashtag = hashtag;
    }

}
