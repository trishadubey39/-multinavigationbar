package com.example.pcdealsexample.Fragments;

import android.app.Dialog;
import android.content.Context;

import com.example.pcdealsexample.R;




public class CustomLoader extends Dialog {

   public CustomLoader(Context context) {
       super(context);

   }

   public CustomLoader(Context context, int theme) {
       super(context, theme);

       setContentView(R.layout.custom_dialog_loder);
   }

   public CustomLoader(Context context, boolean cancelable,
                       OnCancelListener cancelListener) {
       super(context, cancelable, cancelListener);

   }

}
