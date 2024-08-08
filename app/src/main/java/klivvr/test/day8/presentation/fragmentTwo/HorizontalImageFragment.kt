package klivvr.test.day8.presentation.fragmentTwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import klivvr.test.day8.R


class HorizontalImageFragment : Fragment() {

    private val args: HorizontalImageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_horizontal_image, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)

        val imageUrls = args.imageUrls.toList()
        val adapter = ImagePagerAdapter(imageUrls)
        viewPager.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}