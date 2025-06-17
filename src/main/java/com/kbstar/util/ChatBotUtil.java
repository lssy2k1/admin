package com.kbstar.util;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class ChatBotUtil {
    private static String secretKey = "V3FZRWpSVWR0RVdkUUJ5UGFncFNGUVRRcUFUVUxhR1g=";
    private static String apiUrl = "https://djs5uhrnzp.apigw.ntruss.com/custom/v1/" +
            "10482/9393e4cd80ca56d7f520ce8b00f3ac6ae99f4c19da88625de8bfb4c4fd32a113";


    public static String chat(String txt) {
        String chatMessage = "";
        String message = getReqMessage(txt);
        String encodeBase64String = makeSignature(message, secretKey);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

        HttpEntity<String> entity = new HttpEntity<>(message, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String jsonString = response.getBody();
            JSONParser jsonparser = new JSONParser();
            try {
                JSONObject json = (JSONObject) jsonparser.parse(jsonString);
                JSONArray bubblesArray = (JSONArray) json.get("bubbles");
                JSONObject bubbles = (JSONObject) bubblesArray.get(0);
                JSONObject data = (JSONObject) bubbles.get("data");
                chatMessage = (String) data.get("description");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            chatMessage = response.getBody();
        }
        return chatMessage;
    }

    public static String getReqMessage(String voiceMessage) {
        String requestBody = "";
        try {
            JSONObject obj = new JSONObject();
            long timestamp = new Date().getTime();
            System.out.println("##"+timestamp);
            obj.put("version", "v2");
            obj.put("userId", "xxxx");
            obj.put("timestamp", timestamp);
            JSONObject bubbles_obj = new JSONObject();
            bubbles_obj.put("type", "text");
            JSONObject data_obj = new JSONObject();
            data_obj.put("description", voiceMessage);
            bubbles_obj.put("type", "text");
            bubbles_obj.put("data", data_obj);
            JSONArray bubbles_array = new JSONArray();
            bubbles_array.add(bubbles_obj);
            obj.put("bubbles", bubbles_array);
            obj.put("event", "send");
            requestBody = obj.toString();
        } catch (Exception e){
            System.out.println("## Exception : " + e);
        }
        return requestBody;
    }
    public static String makeSignature(String message, String secretKey) {
        String encodeBase64String = "";
        try {
            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");
            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
            return encodeBase64String;
        } catch (Exception e){
            System.out.println(e);
        }
        return encodeBase64String;
    }
}