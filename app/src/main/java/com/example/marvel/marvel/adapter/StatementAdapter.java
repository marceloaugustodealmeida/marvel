package com.example.marvel.marvel.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marvel.marvel.R;
import com.example.marvel.marvel.model.ResultsCharacter;
import com.example.marvel.marvel.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

public class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.MeuViewHolder> {

    private List<ResultsCharacter> ListStatement;

    public StatementAdapter(List<ResultsCharacter> statement) {
        this.ListStatement = statement;
    }

    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_item, parent, false);

        return new MeuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MeuViewHolder holder, int position) {
        ResultsCharacter item = ListStatement.get(position);
        holder.tvMovie.setText(String.valueOf(item.name));

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(Utils.insertString(item.thumbnail.path)+"."+item.thumbnail.extension))
                .setResizeOptions(new ResizeOptions(500, 500))
                .build();

        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setOldController(holder.imageMovie.getController())
                .setImageRequest(request)
                .build();

        holder.imageMovie.setController(controller);


    }

    @Override
    public int getItemCount() {
        return ListStatement.size();
    }


    public class MeuViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView imageMovie;
        public TextView tvMovie;

        public MeuViewHolder(View view) {
            super(view);
            imageMovie = (SimpleDraweeView) view.findViewById(R.id.image_movie);
            tvMovie = (TextView) view.findViewById(R.id.tv_movie);
        }
    }

}



