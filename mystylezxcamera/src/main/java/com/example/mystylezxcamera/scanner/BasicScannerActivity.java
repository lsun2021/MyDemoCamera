package com.example.mystylezxcamera.scanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.mystylezxcamera.interfac.OnScannerCompletionListener;
import com.example.mystylezxcamera.result.AddressBookResult;
import com.google.zxing.Result;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ProductParsedResult;

/**
 * <pre>
 *     author: memoThree
 *     time  : 2018/5/11
 *     desc  :  基础的扫描类
 * </pre>
 */
public abstract class BasicScannerActivity extends AppCompatActivity implements OnScannerCompletionListener {

    public  static  final int  REQUEST_CODE_SCANNER = 188;
    public  static  final  String  EXTRA_RETURN_SCANNER_RESULT = "return_scanner_result";
    private static final String TAG = "BasicScannerActivity";

    private  boolean  mReturnScanResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras  = getIntent().getExtras();
        if(extras!=null){
            mReturnScanResult = extras.getBoolean(EXTRA_RETURN_SCANNER_RESULT);
        }
    }

    @Override
    public void onScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode) {
        if (rawResult == null) {
            Toast.makeText(this, "未发现二维码", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        if(mReturnScanResult){
              onReturnScanResult(rawResult);
            return;
        }
        final Bundle  bundle = new Bundle();
        final ParsedResultType type = parsedResult.getType();
        Log.e("tag","ParsedResultType="+type);
        switch (type){
            case ADDRESSBOOK:
                AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) parsedResult;
                bundle.putSerializable(Scanner.Scan.RESULT,new AddressBookResult(addressBookParsedResult));
                break;
            case PRODUCT:
                ProductParsedResult productParsedResult = (ProductParsedResult) parsedResult;
                Log.e(TAG, "productID: " + productParsedResult.getProductID());
                bundle.putSerializable(Scanner.Scan.RESULT,new ProductParsedResult(productParsedResult));
                break;

            case URI:
                break;
            case TEXT:
                break;
            case GEO:
                break;
            case TEL:
                break;
            case SMS:
                break;
            case CALENDAR:
                break;
            case WIFI:
                break;
            case ISBN:
                break;
            case VIN:
                break;
        }

    }


    private  void  onReturnScanResult (Result  rawResult){
        Intent   intent = getIntent();
        intent.putExtra(Scanner.Scan.RESULT,rawResult.getText());
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
