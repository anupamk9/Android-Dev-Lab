package com.example.ese1_labtest

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, findViewById(R.id.toolbar), R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_team_insights -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TeamInsightsFragment())
                        .commit()
                    true
                }
                R.id.nav_schedule -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ScheduleFragment())
                        .commit()
                    true
                }
                R.id.nav_news -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, NewsFragment())
                        .commit()
                    true
                }
                R.id.nav_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
