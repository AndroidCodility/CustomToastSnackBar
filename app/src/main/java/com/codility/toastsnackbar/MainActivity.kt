package com.codility.toastsnackbar

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
/**
 * Created by Govind on 2/1/2018.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToast.setOnClickListener(View.OnClickListener {
            showToast()
        })

        btSnackBar.setOnClickListener(View.OnClickListener {
            showSnackBar()
        })
    }

    private fun showToast() {
        val toastLayout = layoutInflater.inflate(R.layout.toast_view, null)
        val toast = Toast(applicationContext)
        toast.view = toastLayout
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }

    private fun showSnackBar() {
        val mSnackBar = Snackbar.make(relativeLayout, "This is SnackBar..!!", Snackbar.LENGTH_LONG)
                .setAction("Undo", View.OnClickListener() {
                    showToast()
                })
        mSnackBar.setActionTextColor(Color.YELLOW);

        val view = mSnackBar.view
        val mainTextView = view.findViewById(android.support.design.R.id.snackbar_text) as TextView
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.BOTTOM
        view.setLayoutParams(params)
        view.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        mainTextView.setTextColor(Color.WHITE)
        mSnackBar.show()
    }
}