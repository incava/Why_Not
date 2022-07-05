package Why_Not.App

import Why_Not.App.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(){

    private var Fragment_main = Fragment_main()
    private var Fragment_intro = Fragment_intro() //임의로
    private var Fragment_Review = Fragment_Review() //임의로

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setFragment()
        binding.bnvMain.setOnItemSelectedListener() { item ->
            when (item.itemId) {
                R.id.first -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    replaceFragment(Fragment_main)
                    //Toast.makeText(this,"개빡치네1",Toast.LENGTH_SHORT).show()
                }
                R.id.second -> {
                    replaceFragment(Fragment_intro)
                    //Toast.makeText(this,"개빡치네2",Toast.LENGTH_SHORT).show()
                }
                R.id.third -> {
                    replaceFragment(Fragment_Review)
                    //Toast.makeText(this,"개빡치네3",Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
    private fun setFragment() {
        val transction = supportFragmentManager.beginTransaction()
            .add(R.id.fragment_counselor, Fragment_main)
        transction.commit()
    }
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_counselor, fragment).commit()
    }

}
