package easy.base.fragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import easy.base.viewmodel.BaseViewModel
import easy.base.viewmodel.ViewError
import dagger.hilt.android.AndroidEntryPoint
import easy.base.extension.hideKeyBoard
import easy.base.progress.ProgressDialogFragment
import easy.base.R
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
abstract class BaseFragment() : Fragment() {

    private var isFromBackStack = false

    protected fun isFromBackStack() = isFromBackStack

    protected abstract val viewModel: BaseViewModel

    protected fun viewOwnerLifecycleScope() = viewLifecycleOwner.lifecycleScope

    protected fun viewOwnerLifecycle() = viewLifecycleOwner.lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isFromBackStack = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideKeyBoard()
        view.findViewById<Toolbar>(R.id.toolbar)?.apply {
            setNavigationOnClickListener {
                handleOnBackPressed()
            }
            contentInsetStartWithNavigation = 0
        }
        viewModel.errorsFlow
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { viewError ->
                val errorMessage = when (viewError) {
                    is ViewError.ResourceError -> getString(viewError.resId)
                    is ViewError.StringError -> viewError.error
                }
                showError(errorMessage)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
        viewModel.progressFlow
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { showProgress(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               this@BaseFragment.handleOnBackPressed()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        requireActivity().window.decorView.apply {
            setBackgroundColor(Color.WHITE)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isFromBackStack = true
    }

    private fun showProgress(visible: Boolean) {
        val fragment = childFragmentManager.findFragmentByTag(ProgressDialogFragment.PROGRESS_TAG)
        if (fragment != null && !visible) {
            (fragment as ProgressDialogFragment).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && visible) {
            ProgressDialogFragment.newInstance()
                .show(childFragmentManager, ProgressDialogFragment.PROGRESS_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }

    protected fun handleOnBackPressed() {
        if (!findNavController().popBackStack()) {
            requireActivity().finish()
        }
    }

    private fun showError(errorMessage: String) {

    }

    var currentNativeAd: NativeAd? = null

    /**
     * Populates a [UnifiedNativeAdView] object with data from a given
     * [UnifiedNativeAd].
     *
     * @param nativeAd the object containing the ad's assets
     * @param adView the view to be populated
     */
    private fun populateUnifiedNativeAdView(nativeAd: NativeAd, adView: NativeAdView) {
        // Set the media view.
        adView.mediaView = adView.findViewById(R.id.ad_media)

        // Set other ad assets.
        adView.headlineView = adView.findViewById(R.id.ad_headline)
        adView.bodyView = adView.findViewById(R.id.ad_body)
        adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
        adView.iconView = adView.findViewById(R.id.ad_app_icon)
        adView.priceView = adView.findViewById(R.id.ad_price)
        adView.starRatingView = adView.findViewById(R.id.ad_stars)
        adView.storeView = adView.findViewById(R.id.ad_store)
        adView.advertiserView = adView.findViewById(R.id.ad_advertiser)

        // The headline and media content are guaranteed to be in every UnifiedNativeAd.
        (adView.headlineView as TextView).text = nativeAd.headline
        adView.mediaView.setMediaContent(nativeAd.mediaContent)

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.body == null) {
            adView.bodyView.visibility = View.INVISIBLE
        } else {
            adView.bodyView.visibility = View.VISIBLE
            (adView.bodyView as TextView).text = nativeAd.body
        }

        if (nativeAd.callToAction == null) {
            adView.callToActionView.visibility = View.INVISIBLE
        } else {
            adView.callToActionView.visibility = View.VISIBLE
            (adView.callToActionView as Button).text = nativeAd.callToAction
        }

        if (nativeAd.icon == null) {
            adView.iconView.visibility = View.GONE
        } else {
            (adView.iconView as ImageView).setImageDrawable(
                nativeAd.icon.drawable
            )
            adView.iconView.visibility = View.VISIBLE
        }

        if (nativeAd.price == null) {
            adView.priceView.visibility = View.INVISIBLE
        } else {
            adView.priceView.visibility = View.VISIBLE
            (adView.priceView as TextView).text = nativeAd.price
        }

        if (nativeAd.store == null) {
            adView.storeView.visibility = View.INVISIBLE
        } else {
            adView.storeView.visibility = View.VISIBLE
            (adView.storeView as TextView).text = nativeAd.store
        }

        if (nativeAd.starRating == null) {
            adView.starRatingView.visibility = View.INVISIBLE
        } else {
            (adView.starRatingView as RatingBar).rating = nativeAd.starRating!!.toFloat()
            adView.starRatingView.visibility = View.VISIBLE
        }

        if (nativeAd.advertiser == null) {
            adView.advertiserView.visibility = View.INVISIBLE
        } else {
            (adView.advertiserView as TextView).text = nativeAd.advertiser
            adView.advertiserView.visibility = View.VISIBLE
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd)

    }

    /**
     * Creates a request for a new native ad based on the boolean parameters and calls the
     * corresponding "populate" method when one is successfully returned.
     *
     */
    protected fun refreshAd(id: String, ad_frame: FrameLayout) {
        val builder = AdLoader.Builder(requireContext(), id)

        builder.forNativeAd { unifiedNativeAd ->
            // OnUnifiedNativeAdLoadedListener implementation.
            // If this callback occurs after the activity is destroyed, you must call
            // destroy and return or you may get a memory leak.
            var activityDestroyed = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                activityDestroyed = requireActivity().isDestroyed
            }
            if (activityDestroyed || requireActivity().isFinishing || requireActivity().isChangingConfigurations) {
                unifiedNativeAd.destroy()
                return@forNativeAd
            }
            // You must call destroy on old ads when you are done with them,
            // otherwise you will have a memory leak.
            currentNativeAd?.destroy()
            currentNativeAd = unifiedNativeAd
            val adView = layoutInflater
                .inflate(R.layout.ad_unified, null) as NativeAdView
            populateUnifiedNativeAdView(unifiedNativeAd, adView)
            ad_frame.removeAllViews()
            ad_frame.addView(adView)
            val buttonClose = adView.findViewById<Button>(R.id.button_close_ad)
            buttonClose.setOnClickListener { ad_frame.isVisible = false }
        }

        val videoOptions = VideoOptions.Builder()
            .setStartMuted(false)
            .build()

        val adOptions = com.google.android.gms.ads.formats.NativeAdOptions.Builder()
            .setVideoOptions(videoOptions)
            .build()

        builder.withNativeAdOptions(adOptions)

        val adLoader = builder.withAdListener(object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                val error =
                    """
           domain: ${loadAdError.domain}, code: ${loadAdError.code}, message: ${loadAdError.message}""""
                Toast.makeText(
                    requireContext(), "Failed to load native ad with error $error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }).build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}