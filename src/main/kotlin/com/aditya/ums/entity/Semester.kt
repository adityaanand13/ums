package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "semester")
class Semester(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @ManyToOne(
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )
    @JoinColumn(name = "Batch_id")
    var batch: Batch? = null,

    //one semester can have multiple sections
    @OneToMany(
            mappedBy = "semester",
            cascade = [
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            ]
    )//        fetch = FetchType.EAGER,
    var sections: MutableList<Section> = arrayListOf(),

        //one semester can have multiple subjects
    @OneToMany(
            mappedBy = "semester",
            cascade = [
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            ]
    )//        fetch = FetchType.EAGER,
    var subject: MutableList<Subject> = arrayListOf()
)
