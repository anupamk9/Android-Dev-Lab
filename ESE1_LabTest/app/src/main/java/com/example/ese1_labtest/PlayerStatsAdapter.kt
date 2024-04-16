import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ese1_labtest.R

class PlayerStatsAdapter(private val playerStatsList: List<PlayerStatsModel>) :
    RecyclerView.Adapter<PlayerStatsAdapter.PlayerStatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerStatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player_stats, parent, false)
        return PlayerStatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerStatsViewHolder, position: Int) {
        val playerStats = playerStatsList[position]
        holder.bind(playerStats)
    }

    override fun getItemCount(): Int {
        return playerStatsList.size
    }

    inner class PlayerStatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerNameTextView: TextView = itemView.findViewById(R.id.playerNameTextView)
        private val teamNameTextView: TextView = itemView.findViewById(R.id.teamNameTextView)
        private val matchesPlayedTextView: TextView = itemView.findViewById(R.id.matchesPlayedTextView)
        private val totalRunsTextView: TextView = itemView.findViewById(R.id.totalRunsTextView)
        private val centuriesTextView: TextView = itemView.findViewById(R.id.centuriesTextView)
        private val halfCenturiesTextView: TextView = itemView.findViewById(R.id.halfCenturiesTextView)
        private val battingAverageTextView: TextView = itemView.findViewById(R.id.battingAverageTextView)
        private val bowlingAverageTextView: TextView = itemView.findViewById(R.id.bowlingAverageTextView)
        private val strikeRateTextView: TextView = itemView.findViewById(R.id.strikeRateTextView)
        private val economyRateTextView: TextView = itemView.findViewById(R.id.economyRateTextView)
        private val wicketsTakenTextView: TextView = itemView.findViewById(R.id.wicketsTakenTextView)
        private val catchesTakenTextView: TextView = itemView.findViewById(R.id.catchesTakenTextView)

        fun bind(playerStats: PlayerStatsModel) {
            playerNameTextView.text = playerStats.playerName
            teamNameTextView.text = playerStats.teamName
            matchesPlayedTextView.text = "Matches Played: ${playerStats.matchesPlayed}"
            totalRunsTextView.text = "Total Runs: ${playerStats.totalRuns}"
            centuriesTextView.text = "Centuries: ${playerStats.centuries}"
            halfCenturiesTextView.text = "Half-Centuries: ${playerStats.halfCenturies}"
            battingAverageTextView.text = "Batting Average: ${playerStats.battingAverageFormatted}"
            bowlingAverageTextView.text = "Bowling Average: ${playerStats.bowlingAverageFormatted}"
            strikeRateTextView.text = "Strike Rate: ${playerStats.strikeRateFormatted}"
            economyRateTextView.text = "Economy Rate: ${playerStats.economyRateFormatted}"
            wicketsTakenTextView.text = "Wickets Taken: ${playerStats.wicketsTaken}"
            catchesTakenTextView.text = "Catches Taken: ${playerStats.catchesTaken}"
        }
    }
}
