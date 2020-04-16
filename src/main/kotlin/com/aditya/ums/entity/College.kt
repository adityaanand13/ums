package com.aditya.ums.entity

import javax.persistence.*


@Entity
@Table(name = "college")
class College (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "code")
    var code: String,

    //one college can have multiple courses
    @OneToMany(
            mappedBy = "college",
            cascade = [CascadeType.ALL],
            fetch = FetchType.LAZY
    )
    var courses: MutableList<Course> = arrayListOf(),

    @OneToOne(
            mappedBy = "college",
            cascade = [
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            ],
            fetch = FetchType.LAZY
    )
    var principal: Principal?=null
)
