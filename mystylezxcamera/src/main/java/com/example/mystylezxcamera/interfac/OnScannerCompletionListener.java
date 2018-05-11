package com.example.mystylezxcamera.interfac;

import android.graphics.Bitmap;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

/**
 * <pre>
 *     author: memoThree
 *     time  : 2018/5/11
 *     desc  :  扫描结果的监听
 * </pre>
 */
public interface OnScannerCompletionListener {

    /**
     * 扫描成功后将调用
     * <pre>
     *       ParsedResultType type = parsedResult.getType();
     *         switch (type) {
     *         case ADDRESSBOOK:
     *             AddressBookParsedResult addressResult = (AddressBookParsedResult) parsedResult;
     *         break;
     *         case URI:
     *              URIParsedResult uriParsedResult = (URIParsedResult) parsedResult;
     *         break;
     *     }
     * </pre>
     * @param rawResult  扫描结果
     * @param parsedResult   抽象类，结果转换成目标类型
     * @param barcode       位图
     */
    void onScannerCompletion(Result rawResult , ParsedResult parsedResult, Bitmap barcode);
}
