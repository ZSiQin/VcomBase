package com.vcom.widget.view;

import static com.vcom.base.utils.VcomLog.TAG;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.vcom.base.R;

/**
 * @author vcom
 */
public class MyNumKeyBoard extends LinearLayout {
   private OnClickListener numberListener;
   private OnInputListener inputListener;
   private String inputText = "";
   private int maxLength;

   public MyNumKeyBoard(Context context, AttributeSet attrs) {
      this(context, attrs, 0);
   }

   public MyNumKeyBoard(Context context) {
      this(context, (AttributeSet) null);
   }
   public MyNumKeyBoard(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
      final TypedArray ta = context.obtainStyledAttributes(attrs,
              R.styleable.MyNumKeyBoard, R.attr.MyNumKeyBoardStyle, 0);
      ta.recycle();
      initView(context);
   }

   public void setInputListener(Context context, int maxLength, OnInputListener inputListener) {
      this.inputListener = inputListener;
      this.maxLength = maxLength;
   }

   public void clear() {
      inputText = "";
   }

   private void initView(Context context) {
      View view = LayoutInflater.from(context).inflate(R.layout.layout_num_keyboard, this, true);
      numberListener = v -> {
         int id = v.getId();
         if (id == R.id.btn_1) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "1";
            }
            inputListener.onInput("1");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_2) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "2";
            }
            inputListener.onInput("2");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_3) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "3";
            }
            inputListener.onInput("3");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_4) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "4";
            }
            inputListener.onInput("4");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_5) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "5";
            }
            inputListener.onInput("5");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_6) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "6";
            }
            inputListener.onInput("6");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_7) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "7";
            }
            inputListener.onInput("7");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_8) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "8";
            }
            inputListener.onInput("8");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_9) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "9";
            }
            inputListener.onInput("9");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_0) {
            if (maxLength == 0 || maxLength > inputText.length()) {
               inputText += "0";
            }
            inputListener.onInput("0");
            inputListener.getText(inputText);
         } else if (id == R.id.btn_backspace) {
            if (!inputText.isEmpty()) {
               inputText = inputText.substring(0, inputText.length() - 1);
            }
            inputListener.onInput("backspace");
            inputListener.getText(inputText);
         } else if (id == R.id.iv_close) {
            view.setVisibility(View.GONE);
         }
      };
      findViewById(R.id.btn_1).setOnClickListener(numberListener);
      findViewById(R.id.btn_2).setOnClickListener(numberListener);
      findViewById(R.id.btn_3).setOnClickListener(numberListener);
      findViewById(R.id.btn_4).setOnClickListener(numberListener);
      findViewById(R.id.btn_5).setOnClickListener(numberListener);
      findViewById(R.id.btn_6).setOnClickListener(numberListener);
      findViewById(R.id.btn_7).setOnClickListener(numberListener);
      findViewById(R.id.btn_8).setOnClickListener(numberListener);
      findViewById(R.id.btn_9).setOnClickListener(numberListener);
      findViewById(R.id.btn_0).setOnClickListener(numberListener);
      findViewById(R.id.btn_backspace).setOnClickListener(numberListener);
      findViewById(R.id.iv_close).setOnClickListener(numberListener);
   }

   public interface OnInputListener {

      /**
       * 获取键盘点击的内容
       *
       * @param key 点击的按键
       */
      void onInput(String key);

      /**
       * 获取键盘的输入内容
       *
       * @param text 全部的点击输入内容
       */
      void getText(String text);
   }
}
