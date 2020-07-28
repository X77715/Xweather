package com.iotat.ml.demo.servecs;

import com.alibaba.fastjson.JSON;
import com.iotat.ml.demo.dao.WeatherRepository;
import com.iotat.ml.demo.entity.weatherNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Service
public class getWeatherValue {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    WeatherRepository wr;

    public void getweatherdata() throws IOException {

        //连接网站接口
        URL serverUrl = new URL("https://devapi.heweather.net/v7/weather/3d?location=101270101&key=1039bb39c7264698b2fb6234f8fc4e74");
        HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
        conn.setInstanceFollowRedirects(false);
        conn.connect();

        //接收json字符串
        String weatherStr;
        //接收返回的json字符页
        StringBuffer buffer = new StringBuffer();
        try (GZIPInputStream inputStream = new GZIPInputStream(conn.getInputStream());
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            //中间变量，读取字符流
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //接收结果
            weatherStr = buffer.toString();
        }

        com.alibaba.fastjson.JSONObject json = JSON.parseObject(weatherStr);
        String daily = json.getString("daily");
        daily = daily.replace("[","");
        daily = daily.replace("]","");
        daily = daily.replace("},","}&");

        List<String> lis = Arrays.asList(daily.split("&"));

        for (String l : lis){
            weatherNow wn = new weatherNow();
            com.alibaba.fastjson.JSONObject data = JSON.parseObject(l);
            wn.setData(data.getString("fxDate"));
            wn.setTemp(data.getString("tempMax"));
            wr.save(wn);
        }
    }
}


