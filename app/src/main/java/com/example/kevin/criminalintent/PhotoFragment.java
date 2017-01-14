package com.example.kevin.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Lara on 2017/1/14.
 */

public class PhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView mPhotoView;

    public static PhotoFragment newInstance(File file){
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, file);

        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(args);
        return photoFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File file = (File) getArguments().getSerializable(ARG_PHOTO);
        Bitmap bitmap = PictureUtils.getScaledBitmap(file.getPath(), getActivity());

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);
        mPhotoView = (ImageView) v.findViewById(R.id.dialog_photo_image_view);
        mPhotoView.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
