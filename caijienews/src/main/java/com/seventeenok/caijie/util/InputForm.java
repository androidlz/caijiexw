package com.seventeenok.caijie.util;

import android.support.design.widget.TextInputEditText;
import android.text.InputType;
import android.util.Patterns;

/**
 * Created by ShiQing on 2018/3/7 0007 10:09
 * Desc:
 */

public class InputForm {
    public static boolean checkForm(TextInputEditText inputEditText) {
        String phone = inputEditText.getText().toString();
        boolean isPass = true;
        if (inputEditText.getInputType()== InputType.TYPE_CLASS_PHONE) {
            if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
                inputEditText.setError("错误的手机格式");
                isPass = false;
            } else {
                inputEditText.setError(null);
            } 
        }else{
            if (phone.isEmpty()) {
                inputEditText.setError("输入的昵称不能为空");
                isPass = false;
            } else {
                inputEditText.setError(null);
            }
        }
       
        return isPass;
    }
    
    public static boolean checkForm(TextInputEditText mPhone, TextInputEditText mPassword) {
        String phone = mPhone.getText().toString();
        String password = mPassword.getText().toString();
        boolean isPass = true;
        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            mPhone.setError("错误的手机格式");
            isPass = false;
        } else {
            mPhone.setError(null);
        }
        if (password.isEmpty()) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }
    
   
    
    public static boolean checkForm(TextInputEditText tname, TextInputEditText tphone
            , TextInputEditText tsms, TextInputEditText tpwd, TextInputEditText trePwd) {
        String name = tname.getText().toString();
        String phone = tphone.getText().toString();
        String sms = tsms.getText().toString();
        String pwd = tpwd.getText().toString();
        String rpwd = trePwd.getText().toString();
        boolean isPass = true;
        if (name.isEmpty()) {
            tname.setError("请输入名字");
            isPass = false;
        } else {
            tname.setError(null);
        }
        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            tphone.setError("错误的手机格式");
            isPass = false;
        } else {
            tphone.setError(null);
        }
        if (sms.isEmpty() || !Patterns.PHONE.matcher(sms).matches()) {
            tsms.setError("错误的验证码格式");
            isPass = false;
        } else {
            tsms.setError(null);
        }
        if (pwd.isEmpty()) {
            tpwd.setError("密码不能为空");
            isPass = false;
        } else {
            tpwd.setError(null);
        }
        if (rpwd.isEmpty()) {
            trePwd.setError("密码不能为空");
            isPass = false;
        } else {
            trePwd.setError(null);
        }
        return isPass;
    }

        //忘记密码
    public static boolean checkForm(TextInputEditText tphone
            , TextInputEditText tsms, TextInputEditText tpwd, TextInputEditText trePwd) {
        String phone = tphone.getText().toString();
        String sms = tsms.getText().toString();
        String pwd = tpwd.getText().toString();
        String rpwd = trePwd.getText().toString();
        boolean isPass = true;

        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            tphone.setError("错误的手机格式");
            isPass = false;
        } else {
            tphone.setError(null);
        }
        if (sms.isEmpty() || !Patterns.PHONE.matcher(sms).matches()) {
            tsms.setError("错误的验证码格式");
            isPass = false;
        } else {
            tsms.setError(null);
        }
        if (pwd.isEmpty()) {
            tpwd.setError("密码不能为空");
            isPass = false;
        } else {
            tpwd.setError(null);
        }
        if (rpwd.isEmpty()) {
            trePwd.setError("密码不能为空");
            isPass = false;
        } else {
            trePwd.setError(null);
        }
        return isPass;
    }
}
