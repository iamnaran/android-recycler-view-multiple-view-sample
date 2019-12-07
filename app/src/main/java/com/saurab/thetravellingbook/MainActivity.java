package com.saurab.thetravellingbook;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saurab.thetravellingbook.databinding.ActivityMainBinding;
import com.saurab.thetravellingbook.helpers.TravllingBookActivity;
import com.saurab.thetravellingbook.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TravllingBookActivity {

    private ActivityMainBinding activityMainBinding;
    private List<Post> postList = new ArrayList<>();
    private PostRecyclerViewAdapter postRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setName("Saurav Bajrachrya From List");
            post.setPhotoId(R.drawable.photo);
            postList.add(post);
        }

        prepareRecycerView(postList);


    }

    @Override
    protected void initaliseView() {

    }

    @Override
    protected void initaliseListener() {

    }

    private void prepareRecycerView(List<Post> postList){

        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        postRecyclerViewAdapter = new PostRecyclerViewAdapter(postList);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        activityMainBinding.recyclerView.setAdapter(postRecyclerViewAdapter);

    }

//    main class
    // ineer acting as rv

    private class PostRecyclerViewAdapter extends RecyclerView.Adapter{

        private final int TYPE_0 = 0;
        private final int TYPE_1 = 1;

        private List<Post> postLists = new ArrayList<>();

        public PostRecyclerViewAdapter(List<Post> postList) {

            this.postLists = postList;


        }


        // find the layout create the batta

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            if (viewType == TYPE_0){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_0, parent, false);
                return new VHPost(view);
            }else if (viewType == TYPE_1){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_1, parent, false);
                return new VHAd(view);
            }

            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }

        // find elelemnt and printing data for the batta

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            if (holder instanceof VHPost){

                VHPost vhPost = (VHPost) holder;

                Post post = postLists.get(position);
                vhPost.textView.setText(post.getName());

            }else if (holder instanceof VHAd){
                VHAd vhAd = (VHAd) holder;
            }
        }

        @Override
        public int getItemViewType(int position) {

            if (position == 0 || position ==5 || position ==6){
                return TYPE_0;
            }
            return TYPE_1;

        }

        @Override
        public int getItemCount() {
            return postLists.size();
        }

        private class VHPost extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private TextView textView;

            public VHPost(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                textView = itemView.findViewById(R.id.titlee);

            }
        }

        private class VHAd extends RecyclerView.ViewHolder {
            public VHAd(View view) {
                super(view);

            }
        }
    }
}
