package com.aditya.ums.entity

import javax.persistence.*

class Instructor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

/*
    @MapsId tells Hibernate to use the id column of address as both primary key and foreign key.
    Also, notice that the @Id column of the Address entity no longer uses the @GeneratedValue annotation.
*/
    @OneToOne
    @MapsId
    var user: User,

    @Column(name = "employee_id")
    var employeeID : Int,

/*
    refers to instructor property in the course class @ JoinColumn
     to help find the associated courses for the instructor
     the delete cascade is not defined because
     when we want to delete the course we dont want to delete the instructor and vice versa
 */
    @OneToMany(
        mappedBy = "instructor",
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )//        fetch = FetchType.EAGER,
    var courses: List<Course>

)