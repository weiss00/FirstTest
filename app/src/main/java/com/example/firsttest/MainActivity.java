package com.example.firsttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.OptionalDataException;

public class MainActivity extends AppCompatActivity {
    private   int[] rotateBg = new int[]{R.drawable.accord_a, R.drawable.accord_b, R.drawable.accord_c,
            R.drawable.accord_d, R.drawable.accord_e, R.drawable.accord_f};
    private ImageView imageView;
    private  int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final int[] i = {0};//int【】 i；表示的是定义了一个整型数组，数组名是i 。其实放在这里也不是全局变量，全局变量不定义在方法里，还有 前面有final标识 说明这是哥常量，值不能更改。
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // int[] rotateBg = new int[]{R.drawable.accord_a, R.drawable.accord_b, R.drawable.accord_c,
       // R.drawable.accord_d, R.drawable.accord_e, R.drawable.accord_f};
        imageView = (ImageView) findViewById(R.id.image_View);
        imageView.setBackgroundResource(rotateBg[i]);//点开应用的时候我们要显示第一长图片，所以 在这里设置。

        Button left_button = (Button) findViewById(R.id.left_button);
        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              i -= 1;
                i= SetScene(i);
                imageView.setBackgroundResource(rotateBg[i]);
            }
        });
        Button right_button = (Button) findViewById(R.id.right_button);
        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              i += 1;
                i = SetScene(i);
                imageView.setBackgroundResource(rotateBg[i]);
            }
        });
    }
    private int SetScene(int value) {
        if (value > rotateBg.length - 1) {
            value = 0;
        } else if (value < 0) {
            value =rotateBg.length - 1;
        }
        return value;
    }
}