package com.youdu.imooc_business.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.youdu.imooc_business.R;

import java.io.File;
import java.io.InputStream;
import java.nio.Buffer;

public class ImageLoaderActivity extends AppCompatActivity {

    private static final String TAG = "ImageLoaderActivity";

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);

        imageview = (ImageView)findViewById(R.id.image_test);
       // test();

        //testPath();

        testGetDir();
    }

    private void test(){
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(configuration);
        imageLoader.displayImage("https://raw.githubusercontent.com/rick2016/test/master/pic/0.jpg",imageview);
    }

    private void testPath(){
        String apkPath = this.getPackageCodePath();

        Log.i(TAG, "testPath: "+this.getApplicationContext().getFilesDir().getAbsolutePath());
        Log.i(TAG, "testPath: "+this.getApplicationContext().getCacheDir().getAbsolutePath());
        Log.i(TAG, "testPath: "+this.getPackageResourcePath());

        Log.i(TAG, "testPath: "+ Environment.getExternalStorageDirectory().getAbsolutePath());

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+"ueventd.rc");

        Log.i(TAG, "testPath: "+file.getName());
        Log.i(TAG, "testPath: "+Environment.getRootDirectory());

        File file1 = new File(getCacheDir().getAbsolutePath());
        File[] cacheFiles = file1.listFiles();
        for(File cacheFile :cacheFiles){

            String hint;
            if(cacheFile.isDirectory()){
                hint = "文件夹:";
            }else{
                hint = "文件:";
            }
            Log.i(TAG, "cache file: "+hint+cacheFile.getName());
        }

    }

    private void testGetDir(){
        String config = "config";
        File file = getDir(config,MODE_PRIVATE);
        Log.i(TAG, "testGetDir: "+file.getAbsolutePath());

        Log.i(TAG, "testGetDir: "+file.isFile()+","+file.getName());

        AssetManager assetManager = getAssets();
        try {
            String[] paths = assetManager.list("docs");
            if(paths!=null){
                for(String path:paths){
                    Log.i(TAG, "testGetDir: lpath "+path);
                }

            }

            InputStream in = assetManager.open("docs/docstest");
            int len;
            byte[] buffer = new byte[1024];
            StringBuilder builder = new StringBuilder();
            while((len = in.read(buffer))!=-1){
                builder.append(new String(buffer,0,len));
            }
            Log.i(TAG, "testGetDir: res"+builder.toString());
        }catch (Exception e){

        }
    }
}
