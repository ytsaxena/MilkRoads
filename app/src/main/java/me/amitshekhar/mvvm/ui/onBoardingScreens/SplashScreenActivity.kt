package me.amitshekhar.mvvm.ui.onBoardingScreens

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import me.amitshekhar.mvvm.MVVMApplication
import me.amitshekhar.mvvm.databinding.ActivitySplashScreenBinding
import me.amitshekhar.mvvm.di.component.DaggerActivityComponent
import me.amitshekhar.mvvm.di.module.ActivityModule
import me.amitshekhar.mvvm.ui.topheadline.TopHeadlineActivity
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        //     setContentView(R.layout.activity_splash_screen)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

    }

    private fun setupUI() {

        android.os.Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val i = Intent(this@SplashScreenActivity, TopHeadlineActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)

    }


    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this@SplashScreenActivity)
    }

}