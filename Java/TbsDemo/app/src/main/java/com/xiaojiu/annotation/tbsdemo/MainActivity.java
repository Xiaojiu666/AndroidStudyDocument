package com.xiaojiu.annotation.tbsdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.tv_word)
    TextView tvWord;
    @BindView(R.id.tv_pdf)
    TextView tvPdf;
    @BindView(R.id.tv_avi)
    TextView tvAvi;
    private String fileName="TBS测试.docx";
    //    private String fileUrl="http://123.207.239.170/test.docx";//远程文档地址，如下载失败请验证此链接是否还可用（那个时候可能我养不住服务器了）
    private String fileUrl="https://raw.githubusercontent.com/yangxch/Resources/master/test.docx";//远程文档地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        tvWord.setOnClickListener(this);
        tvPdf.setOnClickListener(this);
        tvAvi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_word:
                //动态权限申请
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                } else {
                    TbsActivity.actionStart(MainActivity.this,fileUrl,fileName);
                }

                break;
            case R.id.tv_pdf:
                //动态权限申请
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                } else {
                    TbsActivity.actionStart(MainActivity.this,fileUrl,fileName);
                }

                break;
            case R.id.tv_avi:
                //动态权限申请
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                } else {
                    TbsActivity.actionStart(MainActivity.this,fileUrl,fileName);
                }

                break;
                default:
                    break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    TbsActivity.actionStart(MainActivity.this,fileUrl,fileName);
                } else {
                    Toast.makeText(this, "你拒绝了权限申请，可能无法下载文件到本地哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

}
