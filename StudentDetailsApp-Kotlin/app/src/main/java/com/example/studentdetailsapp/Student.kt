package com.example.studentdetailsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// @Parcelize (from the kotlin-parcelize plugin) generates all the
// boilerplate needed to pass this whole object through an Intent —
// writeToParcel(), CREATOR, describeContents() — from just this
// short data class definition.
@Parcelize
data class Student(
    val name: String,
    val rollNumber: String,
    val marks: Int
) : Parcelable
