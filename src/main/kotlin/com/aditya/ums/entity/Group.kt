package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "class_group")
class Group (
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
        @JoinColumn(name = "section_id")
        var section: Section,

    //one group can have multiple students
    @OneToMany
    @JoinTable(
        name = "student_group",
        joinColumns= [JoinColumn(name = "group_id")],
        inverseJoinColumns  = [JoinColumn(name = "student_id")]
    )
    var students: MutableList<Student> = arrayListOf()
)