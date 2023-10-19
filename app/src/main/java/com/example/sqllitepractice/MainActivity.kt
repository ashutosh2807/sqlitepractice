    package com.example.sqllitepractice

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import com.google.android.material.bottomnavigation.BottomNavigationView

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
            replaceFragment(HomeFragment())

            bottomNavigation.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.item1 -> replaceFragment(HomeFragment())
                    else->{
                    }
                }
                true
            }

        }

        private fun replaceFragment(fragment: Fragment){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Detach the current fragment if it exists
            val currentFragment = fragmentManager.findFragmentById(R.id.frameLayout)
            if (currentFragment != null) {
                fragmentTransaction.detach(currentFragment)
            }

            // Replace the fragment
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()
        }
    }