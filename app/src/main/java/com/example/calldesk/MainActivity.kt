package com.example.calldesk

import android.content.Intent
import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnBoardingItems()
        setupIndicators()
        setCurrentIndicators(0)
    }

    private fun setOnBoardingItems(){
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnbordingItem(
                onbordingImage = R.drawable.arr,
                title = "Easy Call Interface",
                description = "Easy Call and Message Access facilities."
            ),
            OnbordingItem(
                onbordingImage = R.drawable.brr,
                title = "Manage Your Contact",
                description = "Organise all your contact's easily."
            ),
            OnbordingItem(
                onbordingImage = R.drawable.crr,
                title = "Having Trouble? Contact Us anytime",
                description = "Reach Us Anytime, from Anywhere, Available 24 hours in your service."
            ))
        )
        val onboardingViewPager= findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter


        onboardingViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if(onboardingViewPager.currentItem+1 < onboardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem += 1
            }else{
                navigateToHomeActivity()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener{
            navigateToHomeActivity()
        }
        findViewById<MaterialButton>(R.id.buttonGetStarted).setOnClickListener{
            navigateToHomeActivity()
        }
    }

    private fun navigateToHomeActivity(){
        startActivity(Intent(applicationContext, LoginPage::class.java))
        finish()
    }


    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams= layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicators(position: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}