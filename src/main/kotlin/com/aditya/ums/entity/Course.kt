package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "course")
class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int = 0,

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
    @JoinColumn(name = "instructor_id")
    var instructor: Instructor? = null,

    //many students can have many courses
    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "course_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    var students: MutableList<Student>? = null
)