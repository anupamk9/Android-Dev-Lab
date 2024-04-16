import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ese1_labtest.R


class PlayerStatsFragment : Fragment() {

    private var playerNameTextView: TextView? = null
    private var teamNameTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_stats, container, false)
        playerNameTextView = view.findViewById(R.id.playerNameTextView)
        teamNameTextView = view.findViewById(R.id.teamNameTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example usage of PlayerStatsModel
        val playerStats = arguments?.getParcelable<PlayerStatsModel>("playerStats")

        // Display player stats in UI
        playerStats?.let {
            playerNameTextView?.text = it.playerName
            teamNameTextView?.text = it.teamName
            // Display other stats as needed
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up references to avoid memory leaks
        playerNameTextView = null
        teamNameTextView = null
    }
}
