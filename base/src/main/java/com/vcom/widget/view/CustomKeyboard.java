package com.vcom.widget.view;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import com.vcom.base.R;

public class CustomKeyboard extends KeyboardView {
   private Keyboard keyboard;

   public CustomKeyboard(Context context, AttributeSet attrs) {
      super(context, attrs);
      // 初始化键盘
      initKeyboard(context);
   }

   private void initKeyboard(Context context) {
      // 加载资源文件中的键盘布局
      keyboard = new Keyboard(context, R.xml.keyboard_number2);
      // 设置键盘
      setKeyboard(keyboard);
      setOnKeyboardActionListener(new BasicOnKeyboardActionListener());
   }

   private class BasicOnKeyboardActionListener implements OnKeyboardActionListener {
      @Override
      public void onKey(int primaryCode, int[] keyCodes) {
         // 处理按键事件
         // primaryCode 是按键的 Unicode 值
      }

      @Override
      public void onPress(int primaryCode) {
         // 按键被按下
      }

      @Override
      public void onRelease(int primaryCode) {
         // 按键被释放
      }

      @Override
      public void onText(CharSequence text) {
         // 输入文本
      }

      @Override
      public void swipeDown() {
         // 滑动事件
      }

      @Override
      public void swipeLeft() {
         // 滑动事件
      }

      @Override
      public void swipeRight() {
         // 滑动事件
      }

      @Override
      public void swipeUp() {
         // 滑动事件
      }
   }
}
