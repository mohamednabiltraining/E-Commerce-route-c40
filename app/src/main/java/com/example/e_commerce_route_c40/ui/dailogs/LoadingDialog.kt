import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.e_commerce_route_c40.R
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class LoadingDialog @Inject constructor(
    @ActivityContext private val context: Context
) {
    private var dialog: AlertDialog? = null

    fun show() {
        if (dialog == null) {
            val builder = AlertDialog.Builder(context)
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.loading_dialog_layout, null)
            builder.setView(view)
            builder.setCancelable(false)
            dialog = builder.create()
        }
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}
