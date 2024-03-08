package com.projects.clairvoyance

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import com.projects.clairvoyance.databinding.ActivtyMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivtyMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item: MenuItem ->
            onNavigationItemSelected(item)
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(ToDoFragment())

        //binding.fab.setOnClickListener()

        onBackPressedDispatcher.addCallback(this /* lifecycle owner */) {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                finish()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bottom_todo -> openFragment(ToDoFragment())
            R.id.bottom_calendar -> openFragment(CalendarFragment())
            R.id.nav_home -> openFragment(ToDoFragment())
            R.id.nav_account -> openFragment(AccountFragment())
            R.id.nav_archive -> openFragment(ArchiveFragment())
            R.id.nav_help -> openFragment(HelpFragment())
            R.id.nav_settings-> openFragment(SettingsFragment())

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}