package com.example.rakesh.recyclerviewtest;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    IconAdapter iconAdapter;
    LinearLayoutManager linearLayoutManager;
    int iconsRequestedMorePosition = 10;
    int incrementCounter = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Billboard rests here
         */
        final RecyclerView billboardsRecyclerView = (RecyclerView) findViewById(R.id.billboard_recyclerview);
        billboardsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        billboardsRecyclerView.setHasFixedSize(true);
        final BillboardAdapter billboardAdapter = new BillboardAdapter();
        billboardsRecyclerView.setAdapter(billboardAdapter);

//        final int speedScroll = 1500;
//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            int count = 0;
//            @Override
//            public void run() {
//                if(count < billboardAdapter.getItemCount()){
//                    billboardsRecyclerView.smoothScrollToPosition(++count);
//                    handler.postDelayed(this,speedScroll);
//                }
//
//
//            }
//        };
//
//        handler.postDelayed(runnable,speedScroll);

        /**
         * This is the 1st Icon recycler view
         */
        final RecyclerView iconsRecyclerView = (RecyclerView) findViewById(R.id.icon_pack_recyclerview_1);
        iconsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        iconsRecyclerView.setHasFixedSize(true);
        iconsRecyclerView.addItemDecoration(new PaddingItemDecoration(50));
        linearLayoutManager = (LinearLayoutManager) iconsRecyclerView.getLayoutManager();

        iconAdapter = new IconAdapter();
        iconsRecyclerView.setAdapter(iconAdapter);

        iconsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int state) {
                super.onScrollStateChanged(recyclerView, state);


                if (state == RecyclerView.SCROLL_STATE_IDLE ) {
                    int lastCompletelyVisiblePosition = ((LinearLayoutManager)(recyclerView.getLayoutManager())).findLastCompletelyVisibleItemPosition();
                    Log.i("LoadMore", "position " + lastCompletelyVisiblePosition);
                    if (lastCompletelyVisiblePosition > iconsRequestedMorePosition) {
                        // get more
                        Log.i("LoadMore", "Here");
                        iconAdapter.loadMore();
                        iconsRequestedMorePosition += incrementCounter;
                    }
                }
            }
        });
    }

    public class PaddingItemDecoration extends RecyclerView.ItemDecoration {
        private final int size;

        public PaddingItemDecoration(int size) {
            this.size = size;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            final int itemPosition = parent.getChildAdapterPosition(view);
            if (itemPosition == RecyclerView.NO_POSITION) {
                return;
            }

            final int itemCount = state.getItemCount();

            /** first position */
            if (itemPosition == 0) {
                outRect.left += size;
            }
            /** last position */
            else if (itemCount > 0 && itemPosition == itemCount - 1) {
                outRect.right += size;
            }
        }
    }
}
