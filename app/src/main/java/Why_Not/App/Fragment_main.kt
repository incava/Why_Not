package Why_Not.App

import Why_Not.App.databinding.FragmentMainBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Fragment_main : Fragment() {
    // TODO: Rename and change types of parameters
    val fragment_intro = Fragment_intro()
    val fragment_review = Fragment_Review()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
         val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        var fragmentMainBinding = binding
        return fragmentMainBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChildFragment(fragment_intro)
        view.findViewById<Button>(R.id.btn_intro).setOnClickListener{
            replaceChildFragment(fragment_intro)
        }
        view.findViewById<Button>(R.id.btn_review).setOnClickListener{
            replaceChildFragment(fragment_review)
        }
    }

    private fun setChildFragment(fragment:Fragment) {
        val transction = childFragmentManager.beginTransaction()
            .add(R.id.fragment_IntroOrReview, fragment)
        transction.commit()
    }

    private fun replaceChildFragment(fragment:Fragment) {
        val transction = childFragmentManager.beginTransaction()
            .replace(R.id.fragment_IntroOrReview, fragment)
        transction.commit()
    }

}