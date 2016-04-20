package com.igordotsenko.dotsenkorssreader;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.igordotsenko.dotsenkorssreader.entities.Item;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ItemContentActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mThumbnail;
    private TextView mSubtitle;
    private TextView mPubdate;
    private TextView mContent;
    private ImageButton mBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_content);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //imageLoader initialization for thumbnail setting
        ImageLoader imageLoader = ImageLoader.getInstance();
        Intent intent = getIntent();

        //Views initialization
        mTitle = (TextView) findViewById(R.id.item_content_title);
        mThumbnail = (ImageView) findViewById(R.id.item_content_image);
        mSubtitle = (TextView) findViewById(R.id.item_content_subtitle);
        mPubdate = (TextView) findViewById(R.id.item_content_pubdate);
        mContent = (TextView) findViewById(R.id.item_content_content);
        mBackButton = (ImageButton) findViewById(R.id.item_content_back_button);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Setting views' mContent
        mTitle.setText(intent.getStringExtra(Item.TITLE));
        mSubtitle.setText(intent.getStringExtra(Item.SUBTITLE));
        mPubdate.setText(intent.getStringExtra(Item.PUBDATE));
        mContent.setText(intent.getStringExtra(Item.DESCRIPTION));

        //Setting mThumbnail
        String thumbnailUrl = intent.getStringExtra(Item.THUMBNAIL);
        if ( thumbnailUrl != null) {
            imageLoader.displayImage(thumbnailUrl, mThumbnail);
        }
    }
}
