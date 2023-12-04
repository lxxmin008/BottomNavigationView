package com.example.bottomnavigationview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.databinding.FragmentCommunityBinding
import com.example.bottomnavigationview.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    //뷰가 사라질 때 즉 메모리에서 날라갈 때 같이 날리기 위해 따로 뺴두기
    private var fragmentStoreBinding : FragmentStoreBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : StoreFragment {
            return StoreFragment()
        }
    }
    // 메모리에 올라갔을떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "StoreFragment - onCreate() called")
    }

    // 프래그먼트를 안고 있는 액티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "StoreFragment - onAttach() called")
    }

    // 뷰가 생성 되었을때
    // 프래그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "StoreFragment - onCreateView() called")

        // 뷰 바인딩 가져오기
        // shops 프레그먼트 -> 프레그먼트 shops 바인딩
        val binding = FragmentStoreBinding.inflate(inflater, container, false)
        fragmentStoreBinding = binding

        return fragmentStoreBinding!!.root
    }

    override fun onDestroyView() {
        fragmentStoreBinding = null
        super.onDestroyView()
    }
}