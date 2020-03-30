package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "course")
class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "code")
    var code: String,

    @Column(name = "duration")
    var duration: Int,

    //course should be associated with college
    @ManyToOne(
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )
    @JoinColumn(name = "college_id")
    var college: College? = null,
//
    // One course can have multiple batches
    @OneToMany(
            mappedBy = "course",
            cascade = [CascadeType.ALL]
    )//        fetch = FetchType.EAGER,
    var batches: MutableList<Batch> = arrayListOf()
)
