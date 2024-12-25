package com.vcom.base.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vcom.base.R;

import timber.log.Timber;


/**
 * @author vcom
 * @date 2019-2-22
 */

public class LoadingDialog {
   private final static String TAG = "LoadingDialog";
   private Dialog loadingDialog;
   private TextView tipTextView;
   private Handler mHandler;
   private Runnable runnable;
   private int outTime = 20 * 1000;
   private Activity activity;

   public LoadingDialog(Activity activity, String msg, int outTime) {
      mHandler = new Handler(Looper.getMainLooper());
      LayoutInflater inflater = LayoutInflater.from(activity);
      View v = inflater.inflate(R.layout.dialog_loading, null);
      LinearLayout layout = v.findViewById(R.id.dialog_loading_view);
      tipTextView = v.findViewById(R.id.tipTextView);
      if (msg != null && !msg.isEmpty()) {
         tipTextView.setText(msg);
      }
      loadingDialog = new Dialog(activity, R.style.MyDialogStyle);
      loadingDialog.setCancelable(false);
      loadingDialog.setCanceledOnTouchOutside(false);
      loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT,
              LinearLayout.LayoutParams.MATCH_PARENT));
      Window window = loadingDialog.getWindow();
      WindowManager.LayoutParams lp = window.getAttributes();
      lp.width = WindowManager.LayoutParams.MATCH_PARENT;
      lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
      window.setGravity(Gravity.CENTER);
      window.setAttributes(lp);
      window.setWindowAnimations(R.style.PopWindowAnimStyle);
      if (outTime > 0) {
         this.outTime = outTime;
      }
      this.activity = activity;
      runnable = this::hideLoading;
   }


   /**
    * 设置加载信息
    *
    * @param msg
    */
   public void setTipText(String msg) {
      tipTextView.setText(msg);
   }

   /**
    * 显示等待框
    */
   public void showLoading() {
      if (loadingDialog != null && !activity.isFinishing()) {
         try {
            loadingDialog.show();
         } catch (Exception e) {
            Timber.tag(TAG).e(e);
         }
          if(mHandler == null){
              mHandler = new Handler(Looper.getMainLooper());
          }
         mHandler.removeCallbacks(runnable);
         mHandler.postDelayed(runnable, outTime);
      }
   }

   /**
    * 隐藏等待框
    */
   public void hideLoading() {
      if (loadingDialog != null && !activity.isFinishing()) {
         loadingDialog.dismiss();
         if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
         }
         mHandler.removeCallbacks(runnable);
      }
   }

   /**
    * 关闭等待框
    */
   public void dismissLoading() {
      if (loadingDialog != null && !activity.isFinishing()) {
         loadingDialog.dismiss();
         if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
         }
         mHandler.removeCallbacks(runnable);
      }
      mHandler = null;
   }

}
