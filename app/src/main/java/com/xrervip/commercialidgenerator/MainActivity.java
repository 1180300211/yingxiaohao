package com.xrervip.commercialidgenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String string=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button =(android.widget.Button)findViewById(R.id.button_generator);
        final EditText editText=(EditText)findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String buffer = editText.getText().toString().trim();
                if(buffer.length()==0){
                    Toast.makeText(MainActivity.this,"输入不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
               string=input2Text(buffer);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("营销号文案生成器")
                        .setMessage(string)
                        .setPositiveButton("复制到剪切板", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final ClipboardManager clipboard = (ClipboardManager) MainActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
                                final ClipData clipData = ClipData.newPlainText(null, string);
                                clipboard.setPrimaryClip(clipData); // 把数据集设置（复制）到剪贴板
                            }

                        })
                        .setNegativeButton("取消", null)
                        .show();

            }
        });
    }
    String input2Text(String str){
        StringBuilder ans=new StringBuilder();
        ans.append(str);
        ans.append("是怎么回事呢？相信大家都很熟悉,但是");
        ans.append(str);
        ans.append("是怎么回事呢，下面就让小编带大家一起了解吧.");
        ans.append(str);
        ans.append("其实就是");
        ans.append("大家可能会很惊讶");
        ans.append(str);
        ans.append("怎么会");
        ans.append(str);
        ans.append("呢？");
        ans.append("但事实就是这样，小编也感到非常惊讶。");
        ans.append("这就是关于");
        ans.append(str);
        ans.append("的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！");



        return ans.toString();
    }


}
