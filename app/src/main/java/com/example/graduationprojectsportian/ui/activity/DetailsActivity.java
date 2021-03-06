package com.example.graduationprojectsportian.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.Article;
import com.example.graduationprojectsportian.util.Constants;
import com.example.graduationprojectsportian.util.DateConverter;
import com.squareup.picasso.Picasso;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.iv_details)
    ImageView ivDetails;
    @BindView(R.id.tv_details_head_line)
    TextView tvDetailsHeadLine;
    @BindView(R.id.tv_author_name)
    TextView tvAuthorName;
    @BindView(R.id.tv_details_date)
    TextView tvDetailsDate;
    @BindView(R.id.tv_details_description)
    TextView tvDetailsDescription;
    @BindView(R.id.tv_details_content)
    TextView tvDetailsContent;

    Article article;
    @BindView(R.id.tv_url)
    TextView tvUrl;
    private DateConverter dateConverter = new DateConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        // get data using bundle
        Bundle bundle = getIntent().getExtras();
        // check bundle
        if (bundle != null) {
            article = bundle.getParcelable(Constants.DETAILS_DATA);
            setTitle(article.getSource().getName());
            init();
        }
    }

    // initialization method to set data in details views
    private void init() {
        Picasso.get()
                .load(article.getUrlToImage())
                .placeholder(R.drawable.icon_news)
                .error(R.drawable.icon_news)
                .into(ivDetails);
        tvDetailsHeadLine.setText(article.getTitle());
        Date publishedDate = dateConverter.getDateFromDepartureOrArrivalInquiryString(article.getPublishedAt());
        String publishedDateString = dateConverter.getDateFromDate(publishedDate);
        tvDetailsDate.setText(publishedDateString);
        tvDetailsDescription.setText(article.getDescription());
        if (article.getContent() != null)
            tvDetailsContent.setText(Html.fromHtml(article.getContent()));
        tvAuthorName.setText(article.getAuthor());

        tvUrl.setText(article.getUrl());
        tvUrl.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
            startActivity(intent);
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                funShare();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }


    }

    private void funShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "" + article.getUrl());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}