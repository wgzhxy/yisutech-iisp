package com.yisutech.iisp.toolkit.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * httpClient工具包
 *
 * @author guangzhong.wgz
 */
public class HttpUtils {

    private static CloseableHttpClient defaultClient = null;

    private static Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    static {
        SocketConfig sctConf = SocketConfig.custom().setSoKeepAlive(true).setSoTimeout(3000).build();
        RequestConfig reqConf = RequestConfig.custom().setConnectionRequestTimeout(2000).setSocketTimeout(3000).build();

        defaultClient = HttpClientBuilder.create().setMaxConnTotal(500).setMaxConnPerRoute(50)
                .setDefaultSocketConfig(sctConf).setDefaultRequestConfig(reqConf).build();
    }

    /**
     * httpPost请求
     *
     * @param url     请求url
     * @param charset 返回内容编码
     * @return
     */
    public static String postReq(String url, Map<String, Object> params, Charset charset) {
        CloseableHttpResponse response = null;
        try {
            String mineType = "text/plain";
            ContentType contentType = ContentType.create(mineType, charset);

            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            params.forEach((key, value) -> {
                if (value instanceof String) {
                    builder.addTextBody(key, value.toString(), contentType);

                } else if (value instanceof Integer || value instanceof Long) {
                    builder.addTextBody(key, String.valueOf(value), contentType);

                } else if (value instanceof File) {
                    builder.addBinaryBody(key, (File) value);

                } else if (value instanceof InputStream) {
                    builder.addBinaryBody(key, (InputStream) value);

                } else if (value instanceof byte[]) {
                    builder.addBinaryBody(key, (byte[]) value);

                } else {
                    throw new RuntimeException(value.getClass().getName() + " is not support");

                }
            });
            response = defaultClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), charset);

        } catch (Throwable e) {
            LOG.error("postReq_error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable e) {
                }
            }
        }
        return "";
    }

    /**
     * httpGet请求
     *
     * @param url     请求url
     * @param charset 返回内容编码
     * @return
     */
    public static String getReq(String url, Charset charset) {
        CloseableHttpResponse response = null;
        try {
            response = defaultClient.execute(new HttpGet(url));
            return EntityUtils.toString(response.getEntity(), charset);

        } catch (Throwable e) {
            LOG.error("getReq_error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable e) {
                }
            }
        }
        return "";
    }
}
