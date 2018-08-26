package com.yy.y_zxing;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yy.zxingcore.manager.AlbumManager;
import com.yy.zxingcore.manager.ScanManager;
import com.yy.zxingcore.util.QRCodeUtil;

/**
 * @author yangyi 2018年08月05日01:46:31
 * <p>
 * wechat: yangyi_451686712
 */
public class MainFragment extends Fragment {

    /**
     * 生成的二维码
     */
    private Bitmap createdBitmap;

    /**
     * 输入的二维码内容
     */
    private String qrcodeContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_main, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.gotoCapture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanManager.getInstance().openScan(MainFragment.this);
            }
        });

        view.findViewById(R.id.gotoPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlbumManager.getInstance().openAlbum(MainFragment.this);
            }
        });

        final EditText editText = view.findViewById(R.id.qrcodeEdit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                qrcodeContent = s.toString();
            }
        });

        final LinearLayout qrcodeResult = view.findViewById(R.id.qrcodeResult);
        final ImageView qrcodeImg = view.findViewById(R.id.qrcodeImg);
        view.findViewById(R.id.createQRCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createdBitmap = QRCodeUtil.createQRCodeBitmap(qrcodeContent, 300, 300);
                if (createdBitmap == null) {
                    return;
                }
                qrcodeImg.setImageBitmap(createdBitmap);
                qrcodeResult.setVisibility(View.VISIBLE);
            }
        });

        qrcodeImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("识别图中二维码");
                alertDialogBuilder.setMessage("确认识别？");
                alertDialogBuilder.setPositiveButton("识别", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        AlbumManager.getInstance().showScanningBitmapResult(getActivity(), createdBitmap);
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialogBuilder.setCancelable(true);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;
            }
        });

        view.findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                qrcodeResult.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        ScanManager.getInstance().onActivityResult(getContext(),
                requestCode,
                resultCode,
                data);
        AlbumManager.getInstance().onActivityResult(getContext(),
                requestCode,
                data);
    }
}