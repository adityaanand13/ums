package com.aditya.ums.entity

import javax.persistence.*


@Entity
@Table(name = "college")
class College(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @Column(name = "name")
        var name: String,

        @Column(name = "address")
        var address: String,

        @Column(name = "phone")
        var phone: String,

        @Column(name = "email")
        var email: String,

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
                cascade = [CascadeType.ALL],
                fetch = FetchType.LAZY
        )
        @JoinTable(
                name = "principal",
                joinColumns = [JoinColumn(name = "college_id", referencedColumnName = "id", unique = true)],
                inverseJoinColumns = [JoinColumn(name = "instructor_Id", referencedColumnName = "id")]
        )
        var principal: Instructor? = null
)
