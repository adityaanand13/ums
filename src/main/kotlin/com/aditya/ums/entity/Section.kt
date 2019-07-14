package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "section")
class Section(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        var id: Int? = null,

        @Column(name = "name")
        var name: String,

        @Column(name = "description")
        var description: String,

        //all sections should associate with a semester
        @ManyToOne(
            cascade = [
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            ]
        )
        @JoinColumn(name = "semester_id")
        var semester: Semester,

        //one section can have multiple groups
        @OneToMany(
                mappedBy = "section",
                cascade = [
                        CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH
                ]
        )//        fetch = FetchType.EAGER,
        var groups: MutableList<Group> = arrayListOf()
)
