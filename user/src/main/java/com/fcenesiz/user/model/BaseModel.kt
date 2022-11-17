package com.fcenesiz.user.model;

import java.time.LocalDateTime;

data class BaseModel (
    val createdDate: LocalDateTime? = null,
    val updatedDate: LocalDateTime? = null
)
