package com.yy.zxingcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.yy.zxingcore.R;

/**
 * @author yangyi  2018年08月05日13:03:15
 * <p>
 * wechat: yangyi_451686712
 */
public class QRCodeTopBar extends RelativeLayout {

    public interface QRCodeTopBarClickListener {
        /**
         * 点左
         */
        void startClick();

        /**
         * 点右
         */
        void endClick();
    }

    private QRCodeTopBarClickListener qrCodeTopBarClickListener;

    public void setQrCodeTopBarClickListener(QRCodeTopBarClickListener qrCodeTopBarClickListener) {
        this.qrCodeTopBarClickListener = qrCodeTopBarClickListener;
    }

    public QRCodeTopBar(Context context) {
        super(context);
        initView();
    }

    public QRCodeTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public QRCodeTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.view_top_bar, this, true);
        view.findViewById(R.id.topBack).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qrCodeTopBarClickListener != null) {
                    qrCodeTopBarClickListener.startClick();
                }
            }
        });
        view.findViewById(R.id.topAlbum).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qrCodeTopBarClickListener != null) {
                    qrCodeTopBarClickListener.endClick();
                }
            }
        });
    }
}
