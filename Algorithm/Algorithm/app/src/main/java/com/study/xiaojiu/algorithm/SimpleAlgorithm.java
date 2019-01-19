package com.study.xiaojiu.algorithm;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SimpleAlgorithm extends BaseAlgorithm {
    public static final String TAG = "SimpleAlgorithm";

    /**
     * 快乐数(lintcode--488)
     * 快乐数（happy number）有以下的特性：
     * 在给定的进位制下，该数字所有数位(digits)的平方和，得到的新数再次求所有数位的平方和，如此重复进行，最终结果必为1。
     * 不唯一的就是非快乐数
     * 2 8 → 2²+8²=68 → 6²+8²=100 → 1²+0²+0²=1
     *
     * @param number
     * @return
     */
    public static boolean isHappyNumber(int number) {
        if (number == 1) {
            return true;
        }
        int sum = number;
        HashSet<Integer> resultSet = new HashSet<>();
        while (sum != 1) {
            //如果该元素已经包含在集合里 说明已经重复循环了
            if (resultSet.contains(sum)) {
                return false;
            }
            resultSet.add(sum);
            int temp = 0;
            //循环计算每一位的平方 总和
            while (sum != 0) {
                temp += (sum % 10) * (sum % 10);
                sum /= 10;
            }
            //将每一次的总和从新赋值，并且开始新的一轮循环计算
            sum = temp;
        }
        return true;
    }


    /**
     * 根据传入的数字 获取每一位的 数值
     *
     * @param number
     */
    static void getEveryBitNumber(int number) {
        int s = 0;
        while (number != 0) {

            //1. 通过取模 获取个位数值  129的 个位数就是 9
            //4. 此时number = 12 个位数就是 2 ，
            s = number % 10;

            //2. 因为已经取到个位数的数值 ，通过除以十 让整个number 右移一位  129 /10 = 12
            //5. 此时number = 12 已经取到个位数的2了 此时让number继续右移， 12/ 10 =1 ，重复操作 直至number = 0 说明 s 已经是最后一位了
            number /= 10;
            //3. 此时number已经右移完毕，并且从新赋值
        }
    }

    public static String flipWord(String sentence) {
        List list = Arrays.asList(sentence.split(" "));//一个空格
        Collections.reverse(list);
//        for (int i = 0; i < split.length; i++) {
//            split[i] = split[split.length - i - 1];
//        }
       for (int i = 0 ;i<list.size();i++){
            System.out.println(list.get(i));
       }



        return list.toString();
    }

}
