package com.zhixing101.wechat.api.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.baidu.lbsyun.common.BaiduLbsConstants;
import com.baidu.lbsyun.request.CreatePoiReq;
import com.baidu.lbsyun.response.CreatePoiRes;
import com.zhixing101.wechat.api.common.Constant;
import com.zhixing101.wechat.api.entity.BookStoragePlace;

/**
 * 百度LBS云 工具类
 */
@SuppressWarnings("deprecation")
public class BaiduLbsCloudUtils {

    private static final Logger logger = LoggerFactory.getLogger(BaiduLbsCloudUtils.class);

    @Value("#{propertyConfigurer['baidu.ak']}")
    private static String ak;

    @Value("#{propertyConfigurer['baidu.bookStoragePlaceGeotableId']}")
    private static String bookStoragePlaceGeotableId;

    // public static void main(String[] args) {
    //
    // BookStoragePlace bookStoragePlace = new BookStoragePlace();
    // bookStoragePlace.setName("图书馆A");
    // bookStoragePlace.setDescription("介绍");
    // bookStoragePlace.setAddress("南京");
    // bookStoragePlace.setLatitude("31.915055485888");
    // bookStoragePlace.setLongtitude("118.90784528855");
    //
    // BaiduLbsCloudUtils.createBookStoragePlace(bookStoragePlace);
    // }

    public static String createBookStoragePlace(BookStoragePlace bookStoragePlace) {

        logger.debug("BaiduLbsCloudUtils#createBookStoragePlace begin");
        logger.debug("BaiduLbsCloudUtils#createBookStoragePlace bookStoragePlaceGeotableId = " + bookStoragePlaceGeotableId);
        logger.debug("BaiduLbsCloudUtils#createBookStoragePlace ak = " + ak);

        CreatePoiReq createPoiReq = new CreatePoiReq(null, BaiduLbsConstants.COORD_TYPE_BD09,
                bookStoragePlaceGeotableId, ak, bookStoragePlace);

        String poiId = createPoi(createPoiReq);

        if (StringUtils.isEmpty(poiId)) {
            // 失败
            logger.debug("BaiduLbsCloudUtils#createBookStoragePlace end : poiId is null");
            return null;
        } else {
            // 成功
            logger.debug("BaiduLbsCloudUtils#createBookStoragePlace end : poiId = " + poiId);
            return poiId;
        }
    }

    @SuppressWarnings("resource")
    public static String createPoi(CreatePoiReq createPoiReq) {

        try {
            // HTTP客户端
            HttpClient httpClient = new DefaultHttpClient();

            // POST请求
            HttpPost httpPost = new HttpPost(BaiduLbsConstants.CREATE_POI_URL);

            // 构造参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // 基本
            params.add(new BasicNameValuePair("title", createPoiReq.getTitle()));
            params.add(new BasicNameValuePair("address", createPoiReq.getAddress()));
            // params.add(new BasicNameValuePair("tags",
            // createPoiReq.getTags()));
            params.add(new BasicNameValuePair("latitude", String.valueOf(createPoiReq.getLatitude())));
            params.add(new BasicNameValuePair("longitude", String.valueOf(createPoiReq.getLongitude())));
            params.add(new BasicNameValuePair("coord_type", String.valueOf(createPoiReq.getCoord_type())));
            params.add(new BasicNameValuePair("geotable_id", createPoiReq.getGeotable_id()));
            params.add(new BasicNameValuePair("ak", createPoiReq.getAk()));
            // params.add(new BasicNameValuePair("sn", createPoiReq.getSn()));
            // 开发者自定义
            params.add(new BasicNameValuePair("description", createPoiReq.getDescription()));
            // params.add(new BasicNameValuePair("delete_flag",
            // String.valueOf(createPoiReq.getDelete_flag())));
            // params.add(new BasicNameValuePair("traffic",
            // createPoiReq.getTraffic()));
            // params.add(new BasicNameValuePair("open_time",
            // createPoiReq.getOpen_time()));
            // params.add(new BasicNameValuePair("owner_user_id",
            // createPoiReq.getOwner_user_id()));
            // params.add(new BasicNameValuePair("mobile_phone",
            // createPoiReq.getMobile_phone()));
            // params.add(new BasicNameValuePair("phone",
            // createPoiReq.getPhone()));
            params.add(new BasicNameValuePair("name", createPoiReq.getName()));

            // 设置参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, Constant.UTF8));

            // 发送请求
            HttpResponse httpResponse = httpClient.execute(httpPost);

            HttpEntity httpResponseEntity = httpResponse.getEntity();

            String httpResponseBody = EntityUtils.toString(httpResponseEntity);

            CreatePoiRes res = JSON.parseObject(httpResponseBody, CreatePoiRes.class);

            if (res.getStatus() == 0) {
                // 成功
                return res.getId();
            } else {
                // 失败
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
