package com.example.rakesh.recyclerviewtest;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Billboard rests here
         */
        final RecyclerView billboardsRecyclerView = (RecyclerView) findViewById(R.id.billboard_recyclerview);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
//            @Override
//            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
//                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(getApplicationContext()) {
//
//                    private static final float SPEED = 50f;// Change this value (default=25f)
//
//                    @Override
//                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
//                        return SPEED / displayMetrics.densityDpi;
//                    }
//                };
//                smoothScroller.setTargetPosition(position);
//                startSmoothScroll(smoothScroller);
//            }
//
//        };
//        billboardsRecyclerView.setLayoutManager(layoutManager);
        billboardsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        billboardsRecyclerView.setHasFixedSize(true);
        final BillboardAdapter billboardAdapter = new BillboardAdapter();
        billboardsRecyclerView.setAdapter(billboardAdapter);

        final int speedScroll = 1500;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count < billboardAdapter.getItemCount()){
                    billboardsRecyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }


            }
        };

        handler.postDelayed(runnable,speedScroll);

        /**
         * This is the 1st Icon recycler view
         */
        RecyclerView iconsRecyclerView = (RecyclerView) findViewById(R.id.icon_pack_recyclerview_1);
        iconsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        iconsRecyclerView.setHasFixedSize(true);
        iconsRecyclerView.addItemDecoration(new PaddingItemDecoration(30));

        IconAdapter iconAdapter = new IconAdapter();
        iconsRecyclerView.setAdapter(iconAdapter);

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
