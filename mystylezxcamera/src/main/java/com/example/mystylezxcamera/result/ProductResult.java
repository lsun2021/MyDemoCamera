package com.example.mystylezxcamera.result;

import com.google.zxing.client.result.ProductParsedResult;

/**
 * <pre>
 *     author: memoThree
 *     time  : 2018/5/11
 *     desc  :  产品的扫码结果
 * </pre>
 */
public class ProductResult  extends  Result {

    private final String productID;
    private final String normalizedProductID;

    public ProductResult(ProductParsedResult productParsedResult) {
        this.productID = productParsedResult.getProductID();
        this.normalizedProductID = productParsedResult.getNormalizedProductID();
    }

    public String getProductID() {
        return productID;
    }

    public String getNormalizedProductID() {
        return normalizedProductID;
    }

}
