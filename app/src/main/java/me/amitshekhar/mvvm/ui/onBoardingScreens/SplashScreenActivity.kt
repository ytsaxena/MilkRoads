package me.amitshekhar.mvvm.ui.onBoardingScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import me.amitshekhar.mvvm.MVVMApplication
import me.amitshekhar.mvvm.R
import me.amitshekhar.mvvm.databinding.ActivitySplashScreenBinding
import me.amitshekhar.mvvm.di.component.DaggerActivityComponent
import me.amitshekhar.mvvm.di.module.ActivityModule
import me.amitshekhar.mvvm.ui.topheadline.TopHeadlineViewModel
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var topHeadlineViewModel: SplashViewModel

    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
   //     setContentView(R.layout.activity_splash_screen)

        binding =ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

    }

    private fun setupUI() {

    }


    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this@SplashScreenActivity)
    }

}