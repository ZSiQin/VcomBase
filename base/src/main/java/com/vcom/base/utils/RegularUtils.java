package com.vcom.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author 张勋
 */
public class RegularUtils {

   /**
    * 手机号正则规则验证
    *
    * @param mobile 手机号
    * @return 校验通过返回true，否则返回false
    */
   public static boolean isMobile(String mobile) {
      String str = mobile;
      String pattern = "^(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57]|19[89]|166)[0-9]{8}";
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(str);
      return m.matches();
   }


}
