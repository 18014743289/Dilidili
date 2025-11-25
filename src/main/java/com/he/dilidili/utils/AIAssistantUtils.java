package com.he.dilidili.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class AIAssistant {

    static class Message {
        String role;
        String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }

    static class RequestBody {
        String model;
        Message[] messages;

        public RequestBody(String model, Message[] messages) {
            this.model = model;
            this.messages = messages;
        }
    }

    public static String createName() {
        try {
            // 创建请求体
            RequestBody requestBody = new RequestBody(
                    "qwen-plus",
                    new Message[] {
                            new Message("system", "You are a helpful assistant."),
                            new Message("user", "取一个用户名，加上随机数字，仅回复名字")
                    }
            );

            String apiKey = "sk-d0de4f307b604dcbaba162070b01b1d0";
            String result = sendRequest(requestBody, apiKey);
            return result.substring(result.indexOf("content") + 10, result.indexOf("finish_reason") - 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AAA";
    }

    private static String sendRequest(RequestBody requestBody, String apiKey) throws Exception {
        // 将请求体转换为 JSON
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(requestBody);

        // 创建 URL 对象
        URL url = new URL("https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        // 设置请求方法为 POST
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");

        String auth = "Bearer " + apiKey;
        httpURLConnection.setRequestProperty("Authorization", auth);

        // 启用输入输出流
        httpURLConnection.setDoOutput(true);

        // 写入请求体
        try (OutputStream os = httpURLConnection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // 获取响应码
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // 读取响应体
        try (BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response Body: " + response);
            String result = response.toString();
            return result;
        }
    }


}