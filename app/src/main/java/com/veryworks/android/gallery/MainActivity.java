package com.veryworks.android.gallery;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    ImageView imageView;

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void onCamera(View view){

    }

    private static final int REQ_CAMERA = 222;
    private static final int REQ_GALLERY = 333;

    public void onGallery(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQ_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQ_GALLERY:
                    if(data != null) {
                        Uri imageUri = data.getData();
                        imageView.setImageURI(imageUri);
                    }
                    break;
                case REQ_CAMERA:
                    break;
            }
        }
    }
}
