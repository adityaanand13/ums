package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name="principal")
class Principal(
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

    //principal role needs to have a college
    @OneToOne(
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )
    @JoinColumn(name = "college_id")
    var college: College
)
