package com.yy.y_zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yy.zxingcore.manager.AlbumManager;
import com.yy.zxingcore.manager.ScanManager;

/**
 * @author yangyi 2018年08月05日01:46:31
 *
 * wechat: yangyi_451686712
 */
public class MainFragment extends Fragment {

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
