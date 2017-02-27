package com.example.lance.criminalintent1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by lance on 2017/2/25.
 */

public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path,size.x,size.y);
    }

    public static Bitmap getScaledBitmap(String path,int destWidth,int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        if(srcWidth > destWidth || srcHeight > destHeight){
            if(srcWidth > srcHeight){
                inSampleSize = Math.round(srcHeight/destHeight);
            }else {
                inSampleSize = Math.round(srcWidth/destWidth);
            }
        }
       // options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        return BitmapFactory.decodeFile(path,options);
    }
}
