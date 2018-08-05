package com.yy.zxingcore.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.yy.zxingcore.activity.CaptureActivity;
import com.yy.zxingcore.util.RequestConstant;

/**
 * @author yangyi 2018年08月05日03:16:57
 * <p>
 * wechat: yangyi_451686712
 */
public class ScanManager {

    private static ScanManager scanManager;

    public synchronized static ScanManager getInstance() {
        if (scanManager == null) {
            scanManager = new ScanManager();
        }
        return scanManager;
    }

    public void openScan(Fragment fragment) {
        Intent intent = new Intent(fragment.getContext(), CaptureActivity.class);
        fragment.startActivityForResult(intent, RequestConstant.REQUEST_CODE_SCAN);
    }

    public void openScan(Activity activity) {
        Intent intent = new Intent(activity, CaptureActivity.class);
        activity.startActivityForResult(intent, RequestConstant.REQUEST_CODE_SCAN);
    }

    public void onActivityResult(Context context, int requestCode, int resultCode, final Intent data) {
        if (requestCode == RequestConstant.REQUEST_CODE_SCAN) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                String result = data.getStringExtra(RequestConstant.REQUEST_CODE_SCAN_RESULT);
                Toast.makeText(context, "扫描结果为:" + result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
