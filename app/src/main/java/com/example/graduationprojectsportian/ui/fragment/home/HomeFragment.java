package com.example.graduationprojectsportian.ui.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.api.APIInterface;
import com.example.graduationprojectsportian.api.ApiClient;
import com.example.graduationprojectsportian.model.Article;
import com.example.graduationprojectsportian.model.ResponseHeadLines;
import com.example.graduationprojectsportian.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private HomeViewModel homeViewModel;

    RecyclerView recNews;
    ProgressBar progressNews;
    SwipeRefreshLayout swipeLayout;
    AdapterNews newsAdapter;
    private RecyclerView.LayoutManager newsLayoutManager;
    List<Article> articleList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recNews = root.findViewById(R.id.recNews);
        swipeLayout=root.findViewById(R.id.swipeLayout);
        progressNews=root.findViewById(R.id.progressNews);
        swipeLayout.setOnRefreshListener(this);
        init();
        return root;
    }

    private void init() {
        initRecycle();
        getNews();
    }


    private void initRecycle() {
        newsAdapter = new AdapterNews(getContext());
        recNews.setLayoutManager(getLayoutManager());
        recNews.setAdapter(newsAdapter);
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        if (newsLayoutManager == null) {
            newsLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        }
        return newsLayoutManager;
    }

    private void getNews() {
        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
        Call<ResponseHeadLines> call = apiService.getNews("eg", "sport", Constants.KEY);
        callEnqueue(call);
    }

    private void callEnqueue(Call<ResponseHeadLines> call) {
        call.enqueue(new Callback<ResponseHeadLines>() {
            @Override
            public void onResponse(Call<ResponseHeadLines> call, Response<ResponseHeadLines> response) {

                if (response.body().getStatus().equals("ok")) {
                    articleList = response.body().getArticles();
                    if (articleList.size() > 0) {
                        newsAdapter.setList(articleList);
                        swipeLayout.setRefreshing(false);
                        progressNews.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHeadLines> call, Throwable t) {
                Log.e("Abora", t.toString());
                progressNews.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onRefresh() {
        getNews();
    }
}