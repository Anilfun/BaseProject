package com.example.baseproject.db.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Parcelize
@Entity
data class Staff(
    @PrimaryKey
    var staffId: String,
    var name: String? = null
) : Parcelable {
    override fun toString(): String {
        return super.toString()
    }
}