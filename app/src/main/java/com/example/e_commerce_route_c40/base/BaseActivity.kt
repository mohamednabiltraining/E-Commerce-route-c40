package com.example.e_commerce_route_c40.base

import android.app.AlertDialog
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this,getLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun getLayoutId(): Int

    fun showDialog(
        message: String,
        posText: String? = null,
        posAction: OnDialogClick? = null,
        negText: String? = null,
        negAction: OnDialogClick? = null,
        isCancelable: Boolean = true,
    ) {
        val builder =
            AlertDialog
                .Builder(this)
                .setMessage(message)
        posText?.let {
            builder.setPositiveButton(
                posText,
            ) { dialog, i ->
                dialog.dismiss()
                posAction?.onClick()
            }
        }
        negText?.let {
            builder.setPositiveButton(
                negText,
            ) { dialog, i ->
                dialog.dismiss()
                negAction?.onClick()
            }
        }

        builder.setCancelable(isCancelable)

        builder.show()
    }

    fun showDialog(
        @StringRes message: Int,
        @StringRes posText: Int? = null,
        posAction: OnDialogClick? = null,
        @StringRes negText: Int? = null,
        negAction: OnDialogClick? = null,
        isCancelable: Boolean = true,
    ) {
        val builder =
            AlertDialog
                .Builder(this)
                .setMessage(message)
        posText?.let {
            builder.setPositiveButton(
                posText,
            ) { dialog, i ->
                dialog.dismiss()
                posAction?.onClick()
            }
        }
        negText?.let {
            builder.setPositiveButton(
                negText,
            ) { dialog, i ->
                dialog.dismiss()
                negAction?.onClick()
            }
        }

        builder.setCancelable(isCancelable)

        builder.show()
    }


}
