package HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import sun.net.www.http.HttpClient;

public class Login_sc {
	/** 
	 *最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面
	  *@authorLiudong
	*/
	  // 创建CookieStore实例
	static CookieStore cookieStore = null;
	private static CloseableHttpClient httpclient;
	private static HttpPost httppost;
	private static HttpGet httpget;
	private static String login_success="https://secunia.com/advisories/65475/";
	public Login_sc(){
		httpclient=HttpClientBuilder.create().build();
		httppost=new HttpPost("https://secunia.com/login_box");
	}
	public CookieStore LoginIn(String name,String password,String action) throws Exception{
		//打包将要传入的参数
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("action", action));
		params.add(new BasicNameValuePair("sLoginUsername", name));
		params.add(new BasicNameValuePair("sLoginPassword", password));
		UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"UTF-8");
//		params.add(new BasicNameValuePair("submit", "Login"));
		httppost.setEntity(entity);
		 
		try{
			//提交登录数据
			HttpResponse re=httpclient.execute(httppost);
			System.out.println(re.getStatusLine());
			HttpEntity httpentity=re.getEntity();
//			System.out.println(EntityUtils.toString(httpentity));
			HeaderIterator headers=re.headerIterator();
			while(headers.hasNext()){
				System.out.println(headers.next());
			}
			String setCookie=re.getLastHeader("Set-Cookie").getValue();
			String PHPSESSID = setCookie.substring("PHPSESSID=".length(),
			        setCookie.indexOf(";"));
			System.out.println("PHPSESSID:" + PHPSESSID);
			
			// 新建一个Cookie
		    BasicClientCookie cookie = new BasicClientCookie("PHPSESSID",
		    		PHPSESSID);
		    cookieStore = new BasicCookieStore();
		    cookie.setVersion(0);
		    cookie.setDomain("secunia.com");
		    cookie.setPath("/");
		    // cookie.setAttribute(ClientCookie.VERSION_ATTR, "0");
		    // cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "127.0.0.1");
		    // cookie.setAttribute(ClientCookie.PORT_ATTR, "8080");
		    // cookie.setAttribute(ClientCookie.PATH_ATTR, "/CwlProWeb");
		    cookieStore.addCookie(cookie);
			/*//获得跳转的网址
			Header locationHeader= re.getFirstHeader("Location");
			if(locationHeader == null){
				System.out.println("登陆不成功，请稍后再试~");
				return;
			}else{
				System.out.println("locationHeader:"+locationHeader.getName()+":"+locationHeader.getValue());
				login_success=locationHeader.getValue();
				System.out.println("成功后跳转到的网页网址："+login_success);
				
				}*/
			}catch(ClientProtocolException e){
				e.printStackTrace();
			}finally{
				httppost.abort();
			}
			return cookieStore;
		}
		public static void PrintText() throws IOException{
			System.out.println("================================================");
			httpget=new HttpGet(login_success);
			HttpResponse re2=null;
			try{
				re2=httpclient.execute(httpget);
				//输出登录成功后的页面
			
				HeaderIterator headers=re2.headerIterator();
				while(headers.hasNext()){
					System.out.println(headers.next());
				}	
				String str=EntityUtils.toString(re2.getEntity());
				//System.out.println(str);
				System.out.println("get -cookies :"+re2.getLastHeader("Set-Cookie"));
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}finally{
				
				httpget.abort();
			//	httpclient.close();
			}
		}
	
		public static void main(String[] args) throws Exception{
			String name="ly1246621281",password="12345678";
			String action="login";
			Login_sc ls=new Login_sc();
			ls.LoginIn(name,password,action);
			PrintText();
			testCookieStore();
		}
		
		  public static void testCookieStore() throws Exception {
		    System.out.println("-----------------------------testCookieStore");
		    // 使用cookieStore方式
		    /*CloseableHttpClient client = HttpClients.custom()
		        .setDefaultCookieStore(cookieStore).build();*/
		    HttpGet httpGet = new HttpGet(login_success);
		    System.out.println("request line:" + httpGet.getRequestLine());
		    try {
		      // 执行get请求
		      HttpResponse httpResponse = httpclient.execute(httpGet);
		      System.out.println("cookie store:" + cookieStore.getCookies());
		      String str=EntityUtils.toString(httpResponse.getEntity());
		      System.out.println("get -cookies :"+httpResponse.getLastHeader("Set-Cookie"));
		      System.out.println(str);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        // 关闭流并释放资源
		        httpclient.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		    }
		  }
	}


