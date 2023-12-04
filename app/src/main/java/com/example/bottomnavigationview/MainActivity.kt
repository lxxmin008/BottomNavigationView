package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.bottomnavigationview.databinding.ActivityMainBinding as ActivityMainBinding
import com.example.bottomnavigationview.databinding.FragmentShopsBinding


class MainActivity : AppCompatActivity() {

    private lateinit var shopsFragment: ShopsFragment
    private lateinit var mapsFragment: MapsFragment
    private lateinit var communityFragment: CommunityFragment
    private lateinit var storeFragment: StoreFragment
    private lateinit var optionFragment: OptionFragment

    companion object {
        const val TAG:String = "로그"
    }

    private var activityMainBinding : ActivityMainBinding? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 메인 액티비티 -> 액티비티 메인 바인딩
        // 자동으로 완성된 메인 액티비티 인스턴스를 가져옴
        val binding = ActivityMainBinding.inflate(layoutInflater)

        activityMainBinding = binding

        //바인딩과 연결
        setContentView(activityMainBinding!!.root)
//        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

//        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        activityMainBinding?.bottomNav?.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        shopsFragment = ShopsFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, shopsFragment).commit()

    }

    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.menu_shops -> {
                Log.d(TAG, "MainActivity - 가게 버튼 클릭")
                shopsFragment = ShopsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame,shopsFragment).commit()
            }
            R.id.menu_map -> {
                Log.d(TAG, "MainActivity - 지도 버튼 클릭")
                mapsFragment = MapsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame,mapsFragment).commit()
            }
            R.id.menu_community -> {
                Log.d(TAG, "MainActivity - 커뮤니티 버튼 클릭")
                communityFragment = CommunityFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame,communityFragment).commit()
            }
            R.id.menu_store -> {
                Log.d(TAG, "MainActivity - 매장관리 버튼 클릭")
                storeFragment = StoreFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame,storeFragment).commit()
            }
            R.id.menu_option -> {
                Log.d(TAG, "MainActivity - 옵션 버튼 클릭")
                optionFragment = OptionFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame,optionFragment).commit()
            }
        }
        true
    }

}