package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "principal")
class Principal(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        var id: Int? = null,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "college_id")
        var college: College,

        @ManyToOne
        @JoinColumn(name = "instructor_id")
        var instructor: Instructor
)


