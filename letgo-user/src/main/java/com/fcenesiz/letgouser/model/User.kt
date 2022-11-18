package com.fcenesiz.user.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mail: String,
    val firstName: String,
    val lastName: String,
    val middleName: String
) {
    constructor(Mail: String, FirstName: String, LastName: String, MiddleName: String) : this(
        null,
        Mail,
        FirstName,
        LastName,
        MiddleName
    )

    constructor() : this(
        null, "mail?", "firstName?", "lastName?", "middleName?"
    )
}