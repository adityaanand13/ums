package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "attendance")
class Attendance (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "total_classes")
    var totalClasses: Int,

    @Column(name = "present_classes")
    var present: Int,

    @ManyToOne
    @JoinColumn(name = "subject_id")
    var subject: Subject,

    @ManyToOne
    @JoinColumn(name = "student_id")
    var student: Student

)