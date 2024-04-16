import android.os.Parcel
import android.os.Parcelable

data class PlayerStatsModel(
    val playerName: String,
    val teamName: String,
    val matchesPlayed: Int,
    val totalRuns: Int,
    val centuries: Int,
    val halfCenturies: Int,
    val battingAverage: Double,
    val bowlingAverage: Double,
    val strikeRate: Float,
    val economyRate: Float,
    val wicketsTaken: Int,
    val catchesTaken: Int
) : Parcelable {
    val totalCenturiesHalfCenturies: String
        get() = "$centuries Centuries, $halfCenturies Half-Centuries"

    val battingAverageFormatted: String
        get() = String.format("%.2f", battingAverage)

    val bowlingAverageFormatted: String
        get() = String.format("%.2f", bowlingAverage)

    val strikeRateFormatted: String
        get() = String.format("%.2f", strikeRate)

    val economyRateFormatted: String
        get() = String.format("%.2f", economyRate)

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(playerName)
        parcel.writeString(teamName)
        parcel.writeInt(matchesPlayed)
        parcel.writeInt(totalRuns)
        parcel.writeInt(centuries)
        parcel.writeInt(halfCenturies)
        parcel.writeDouble(battingAverage)
        parcel.writeDouble(bowlingAverage)
        parcel.writeFloat(strikeRate)
        parcel.writeFloat(economyRate)
        parcel.writeInt(wicketsTaken)
        parcel.writeInt(catchesTaken)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerStatsModel> {
        override fun createFromParcel(parcel: Parcel): PlayerStatsModel {
            return PlayerStatsModel(parcel)
        }

        override fun newArray(size: Int): Array<PlayerStatsModel?> {
            return arrayOfNulls(size)
        }
    }
}
