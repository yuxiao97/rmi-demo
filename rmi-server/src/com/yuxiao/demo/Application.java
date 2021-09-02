package com.yuxiao.demo;

import java.io.IOException;

/**
 * @author yuxiao
 * @date 2021-04-12 17:02
 */
public class Application {

    public static void main(String[] args) throws IOException {
        ServiceExporter.exporter();
        System.out.println("服务已启动");
    }

}
