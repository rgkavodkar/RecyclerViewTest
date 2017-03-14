package com.example.rakesh.recyclerviewtest;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh on 14-02-2017.
 */

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private List<Icon> icons;

    public IconAdapter() {
        this.icons = new ArrayList<>();
        icons.add(new Icon(R.drawable.icon_amazon, "Amazon"));
        icons.add(new Icon(R.drawable.icon_amazon_kindle, "Amazon Kindle"));
        icons.add(new Icon(R.drawable.icon_downie, "Downie"));
        icons.add(new Icon(R.drawable.icon_fez, "Fez"));
        icons.add(new Icon(R.drawable.icon_filehippo, "FileHippo"));
        icons.add(new Icon(R.drawable.icon_firefox_beta, "FireFox beta"));
        icons.add(new Icon(R.drawable.icon_google_inbox, "Inbox"));
        icons.add(new Icon(R.drawable.icon_ibook, "IBook"));
        icons.add(new Icon(R.drawable.icon_lego, "Lego"));
        icons.add(new Icon(R.drawable.icon_lossless, "Lossless"));
        icons.add(new Icon(R.drawable.icon_microphone, "Microphone"));
        icons.add(new Icon(R.drawable.icon_musicbrainz, "Music Brainz"));
        icons.add(new Icon(R.drawable.icon_nba, "NBA"));
        icons.add(new Icon(R.drawable.icon_panorama, "Panorama"));
        icons.add(new Icon(R.drawable.icon_snake, "Snake"));

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Icon icon = icons.get(position);
        holder.icon.setImageResource(icon.getDrawable());
        holder.title.setText(icon.getTitle());


    }
    @Override
    public int getItemCount() {
        return icons.size();
    }

    public void loadMore() {

        Log.i("LoadMore", "Inside Loadmore");

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                icons.add(new Icon(R.drawable.icon_amazon, "Amazon"));
                icons.add(new Icon(R.drawable.icon_amazon_kindle, "Amazon Kindle"));
                icons.add(new Icon(R.drawable.icon_downie, "Downie"));
                icons.add(new Icon(R.drawable.icon_fez, "Fez"));
                icons.add(new Icon(R.drawable.icon_filehippo, "FileHippo"));
                icons.add(new Icon(R.drawable.icon_firefox_beta, "FireFox beta"));
                icons.add(new Icon(R.drawable.icon_google_inbox, "Inbox"));
                icons.add(new Icon(R.drawable.icon_ibook, "IBook"));
                icons.add(new Icon(R.drawable.icon_lego, "Lego"));
                icons.add(new Icon(R.drawable.icon_lossless, "Lossless"));
                icons.add(new Icon(R.drawable.icon_microphone, "Microphone"));
                icons.add(new Icon(R.drawable.icon_musicbrainz, "Music Brainz"));
                icons.add(new Icon(R.drawable.icon_nba, "NBA"));
                icons.add(new Icon(R.drawable.icon_panorama, "Panorama"));
                icons.add(new Icon(R.drawable.icon_snake, "Snake"));
                Log.i("LoadMore", "Loading more in adapter");
                notifyDataSetChanged();
            }
        };

        handler.postDelayed(runnable,1000);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.card_icon);
            title = (TextView) itemView.findViewById(R.id.card_text);
        }
    }
}
