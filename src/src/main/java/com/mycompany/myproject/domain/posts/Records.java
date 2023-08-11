package com.mycompany.myproject.domain.posts;

import com.mycompany.myproject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Records extends BaseTimeEntity {

    //private final long cost_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;

    /*@Column(length = 500, nullable = true)
    private int cost;
    //private Cost cost; - 다른 Cost클래스(테이블) 있을때*/

    @Column(length = 255, nullable = false)
    private String recordTitle;

    @Column(nullable=false)
    private String location;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    /*@Column(columnDefinition = "TEXT", nullable = false)
    private String content;*/


    @Builder
    public Records(long recordId,String recordTitle, String location, Date startDate, Date endDate) {
       // this.cost_id = cost_id;
        this.recordId = recordId;
        this.recordTitle = recordTitle;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void update(String recordTitle, String location, Date startDate, Date  endDate) {
       // this.cost_id = cost_id;
        this.recordId = recordId;
        this.recordTitle = recordTitle;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
