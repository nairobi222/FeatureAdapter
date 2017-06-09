package com.groupon.android.featureadapter.sample.features.multioptions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.android.featureadapter.sample.features.multioptions.state.OptionClickedEvent;
import com.groupon.android.featureadapter.sample.model.Option;
import com.groupon.android.featureadapter.sample.rx.R;
import com.groupon.featureadapter.AdapterViewTypeDelegate;

public class OptionAdapterViewTypeDelegate
    extends AdapterViewTypeDelegate<OptionAdapterViewTypeDelegate.OptionViewHolder, Option> {

  private static final int LAYOUT = R.layout.dd_option;

  @Override
  public OptionViewHolder createViewHolder(ViewGroup parent) {
    View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, parent, false);
    return new OptionViewHolder(view);
  }

  @Override
  public void bindViewHolder(OptionViewHolder holder, Option model) {
    holder.valueText.setText(model.getTitle());
    holder.valueText.setOnClickListener(view -> fireEvent(new OptionClickedEvent(model)));
  }

  @Override
  public void unbindViewHolder(OptionViewHolder holder) {
    // no op
  }

  public class OptionViewHolder extends RecyclerView.ViewHolder {

    final TextView valueText;

    private OptionViewHolder(View itemView) {
      super(itemView);
      valueText = (TextView) itemView.findViewById(R.id.option_title_text);
    }
  }
}
