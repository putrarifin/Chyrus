package com.chyrus.chyrus.adapter.vholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chyrus.chyrus.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chyrus on 5/22/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movies_layout)
    LinearLayout moviesLayout;
    @BindView(R.id.title)
    TextView movieTitle;
    @BindView(R.id.subtitle)
    TextView data;
    @BindView(R.id.description)
    TextView movieDescription;
    @BindView(R.id.rating)
    TextView rating;

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public LinearLayout getMoviesLayout() {
        return moviesLayout;
    }

    public void bind(String movieTitle,
                     String subtitle,
                     String movieDescription,
                     String rating) {

        this.movieTitle.setText(movieTitle);
        this.data.setText(subtitle);
        this.movieDescription.setText(movieDescription);
        this.rating.setText(rating);

    }
}
