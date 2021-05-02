package easy.base.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import easy.base.R
import easy.base.fragment.BaseFragment

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        // The window will not be resized when virtual keyboard is shown (bottom navigation bar will be
        // hidden under virtual keyboard)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment is BaseFragment) {
            if (!currentFragment.handleOnBackPressed()) {
                supportFragmentManager.apply {
                    if (backStackEntryCount == 0) {
                        finish()
                    } else {
                        popBackStack()
                    }
                }
            }
        } else {
            super.onBackPressed()
        }
    }
}
