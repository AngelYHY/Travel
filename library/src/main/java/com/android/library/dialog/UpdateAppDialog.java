package com.android.library.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.library.R;

/**
 * Author:  ljo_h
 * Date:    2016/6/6
 * Description:
 */
public class UpdateAppDialog extends DialogFragment {

    private String content;
    private DialogInterface.OnClickListener positiveListener;
    private DialogInterface.OnClickListener negativeListener;

    public UpdateAppDialog(String content, DialogInterface.OnClickListener positiveListener){
        this.content = content;
        this.positiveListener = positiveListener;
    }

    public UpdateAppDialog(String content, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener){
        this.content = content;
        this.positiveListener = positiveListener;
        this.negativeListener = negativeListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.umeng_update_dialog, null);
        //dialog.getActivity().addContentView(layout, null);
        builder.setView(layout);

        TextView contentView = (TextView) layout.findViewById(R.id.umeng_update_content);
        Button PositiveButton = (Button) layout.findViewById(R.id.umeng_update_id_ok);
        Button NegativeButton = (Button) layout.findViewById(R.id.umeng_update_id_cancel);

        contentView.setText(content);
        PositiveButton.setOnClickListener(clickListener);
        NegativeButton.setOnClickListener(clickListener);

        return builder.create();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.umeng_update_id_ok) {
                if (positiveListener != null) {
                    positiveListener.onClick(UpdateAppDialog.this.getDialog(), DialogInterface.BUTTON_POSITIVE);
                }
                dismiss();
            } else if (view.getId() == R.id.umeng_update_id_cancel) {
                if (negativeListener != null) {
                    negativeListener.onClick(UpdateAppDialog.this.getDialog(), DialogInterface.BUTTON_NEGATIVE);
                }
                dismiss();
            }
        }
    };
}
