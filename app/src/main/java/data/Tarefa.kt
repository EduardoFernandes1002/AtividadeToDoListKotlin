package data

import android.os.Parcel
import android.os.Parcelable

data class Tarefa() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tarefa> {
        override fun createFromParcel(parcel: Parcel): Tarefa {
            return Tarefa(parcel)
        }

        override fun newArray(size: Int): Array<Tarefa?> {
            return arrayOfNulls(size)
        }
    }
}
