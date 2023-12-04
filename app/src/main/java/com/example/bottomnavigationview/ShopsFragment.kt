package com.example.bottomnavigationview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.databinding.FragmentShopsBinding

class ShopsFragment : Fragment() {

    //뷰가 사라질 때 즉 메모리에서 날라갈 때 같이 날리기 위해 따로 뺴두기
    private var fragmentShopsBinding : FragmentShopsBinding? = null



    companion object {
        const val TAG : String = "로그"

        fun newInstance() : ShopsFragment {
            return ShopsFragment()
        }
    }
    // 메모리에 올라갔을떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate() called")
    }

    // 프래그먼트를 안고 있는 액티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach() called")
    }

    // 뷰가 생성 되었을때
    // 프래그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "HomeFragment - onCreateView() called")

//        val view = inflater.inflate(R.layout.fragment_shops, container, false)
//
//        return view

        // 뷰 바인딩 가져오기
        // shops 프레그먼트 -> 프레그먼트 shops 바인딩
        val binding = FragmentShopsBinding.inflate(inflater, container, false)
        fragmentShopsBinding = binding

        return fragmentShopsBinding!!.root
    }

    override fun onDestroyView() {
        fragmentShopsBinding = null
        super.onDestroyView()
    }
}