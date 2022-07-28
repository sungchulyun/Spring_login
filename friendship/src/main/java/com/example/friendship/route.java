package com.example.friendship;

import okhttp3.*;

import java.io.IOException;

public class route {


     public boolean myMethod(){
         try {
             OkHttpClient client = new OkHttpClient();

             MediaType mediaType = MediaType.parse("application/json");
             RequestBody body = RequestBody.create(mediaType, "{\"reqCoordType\":\"WGS84GEO\",\"resCoordType\":\"WGS84GEO\"," +
                     "\"startName\":\"%EC%B6%9C%EB%B0%9C\",\"startX\":\"126.966484\",\"startY\":\"37.565453\",\"startTime\":\"201709121938\",\"" +
                     "endName\":\"%EB%8F%84%EC%B0%A9\",\"endX\":\"127.008112\",\"endY\":\"37.565657\",\"searchOption\":\"0\",\"carType\":\"4\",\"" +
                     "coordinateFlag\":\"0\",\"truckType\":\"1\",\"truckWidth\":\"250\",\"truckHeight\":\"340\",\"truckWeight\":\"35500\",\"truckTotalWeight" +
                     "\":\"26000\",\"truckLength\":\"880\"}");
             Request request = new Request.Builder()
                     .url("https://apis.openapi.sk.com/tmap/routes/routeOptimization10?version=1")
                     .post(body)
                     .addHeader("Accept", "application/json")
                     .addHeader("Content-Type", "application/json")
                     .addHeader("appKey", "l7xx1317e6cad24d4f0d8048aa7336e5623b")
                     .build();

                Response response = client.newCall(request).execute();
                System.out.println(response);
                if(response.isSuccessful()){
                    ResponseBody body1 = response.body();
                    if(body1 != null){
                        System.out.println("Response:" + body1.string());
                    }
             }
             else {
                 System.err.println("error occured");
             }
             return true;
         }
         catch (IOException ex) {
             throw new RuntimeException(ex);
         }
     }




}
