package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "batch")
class Batch (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    //batch should be associated with courses
    @ManyToOne(
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )
    @JoinColumn(name = "course_id")
    var course: Course? = null,

    //one batch can have multiple semesters
    @OneToMany(
            mappedBy = "batch",
            cascade = [
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            ]
    )//        fetch = FetchType.EAGER,
    var semesters: MutableList<Semester> = arrayListOf()
)
