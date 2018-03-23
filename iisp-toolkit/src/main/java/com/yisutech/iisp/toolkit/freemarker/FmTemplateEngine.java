package com.yisutech.iisp.toolkit.freemarker;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.freemarker.FmTemplateEngine
 * 描述：
 * <p>
 * freemarker 模块引擎
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午6:12
 **/
public class FmTemplateEngine {

    /**
     * 模板生成
     *
     * @param name    名称，可进行缓存
     * @param content 模板内容
     * @param values  模板变量集合
     * @return
     */
    public static String process(String name, String content, Map<String, Object> values) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Configuration cfg = new Configuration(Configuration.getVersion());
            Template template = new Template(name, content, cfg);

            template.process(values, new OutputStreamWriter(out));
            return out.toString(Charsets.UTF_8.name());

        } catch (Throwable e) {
            throw new RuntimeException(e.getCause());
        }

    }

    public static void main(String args[]) throws IOException, TemplateException {

        Map root = Maps.newHashMap();
        root.put("user", "guangzhong.wgz");

        System.out.println(FmTemplateEngine.process("test_001", "thhis good one, ${user}", root));
    }
}
