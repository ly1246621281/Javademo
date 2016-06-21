package HttpClient;

import java.io.IOException;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

	    public static void main(String args[]) {
	        //����HttpClientBuilder
	        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	        //HttpClient
	        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

	        HttpGet httpGet = new HttpGet("http://www.baidu.com");
	        System.out.println(httpGet.getRequestLine());
	        try {
	            //ִ��get����
	            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
	            //��ȡ��Ӧ��Ϣʵ��
	            HttpEntity entity = httpResponse.getEntity();
	            //��Ӧ״̬
	            System.out.println("status:" + httpResponse.getStatusLine());
	            //�ж���Ӧʵ���Ƿ�Ϊ��
	            if (entity != null) {
	            	HeaderIterator it=httpResponse.headerIterator("Set-Cookie");
	            	while(it.hasNext()){
	            		System.out.println(it.next());
	            	}
	                System.out.println("contentEncoding:" + entity.getContentEncoding());
	                System.out.println("content:" + entity.getContent().toString());
	               // System.out.println("response content:" + EntityUtils.toString(entity));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {                //�ر������ͷ���Դ
	                closeableHttpClient.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

