package com.vcom.base.utils;

public class EnglishUtil {
   /**
    * 数字转英文，0~59
    *
    * @param number 数字
    * @return 数字英文
    */
   public static String convertArabicToEnglish(int number) {
      String[] arabicNumbers = {
              "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
              "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
              "Sixteen", "Seventeen", "Eighteen", "Nineteen",
              "Twenty", "TwentyOne", "TwentyTwo", "TwentyThree", "TwentyFour",
              "TwentyFive", "TwentySix", "TwentySeven", "TwentyEight", "TwentyNine",
              "Thirty", "ThirtyOne", "ThirtyTwo", "ThirtyThree", "ThirtyFour",
              "ThirtyFive", "ThirtySix", "ThirtySeven", "ThirtyEight", "ThirtyNine",
              "Forty", "FortyOne", "FortyTwo", "FortyThree", "FortyFour",
              "FortyFive", "FortySix", "FortySeven", "FortyEight", "FortyNine",
              "Fifty", "FiftyOne", "FiftyTwo", "FiftyThree", "FiftyFour",
              "FiftyFive", "FiftySix", "FiftySeven", "FiftyEight", "FiftyNine"};
      return arabicNumbers[number];
   }

}
