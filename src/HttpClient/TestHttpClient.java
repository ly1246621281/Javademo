package HttpClient;

/*672530440
博客园首页新闻新随笔联系管理订阅 随笔- 606  文章- 0  评论- 3 
HttpClient4.x 使用cookie保持会话
复制代码
HttpClient4.x可以自带维持会话功能，只要使用同一个HttpClient且未关闭连接，则可以使用相同会话来访问其他要求登录验证的服务（见TestLogin()方法中的“执行get请求”部分）。
如果需要使用HttpClient池，并且想要做到一次登录的会话供多个HttpClient连接使用，就需要自己保存会话信息。因为客户端的会话信息是保存在cookie中的（JSESSIONID），所以只需要将登录成功返回的cookie复制到各个HttpClient使用即可。
使用Cookie的方法有两种，可以自己使用CookieStore来保存（见TestCookieStore()方法），也可以通过HttpClientContext上下文来维持（见TestContext()方法）。
附带HttpClient4.3示例代码 http://www.myexception.cn/program/1459749.html 。
*/


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestHttpClient {

  // 创建CookieStore实例
  static CookieStore cookieStore = null;
  static HttpClientContext context = null;
  String loginUrl = "https://secunia.com/login_box";
  String testUrl = "https://secunia.com/advisories/65475";
  String loginErrorUrl = "http://127.0.0.1:8080/CwlProClient/login/login.jsp";

  @Test
  public void testLogin() throws Exception {
    System.out.println("----testLogin");

    // // 创建HttpClientBuilder
    // HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    // // HttpClient
    // CloseableHttpClient client = httpClientBuilder.build();
    // 直接创建client
    CloseableHttpClient client = HttpClients.createDefault();

    HttpPost httpPost = new HttpPost(loginUrl);
    Map parameterMap = new HashMap();
    parameterMap.put("sLoginUsername", "ly1246621281");
    parameterMap.put("sLoginPassword", "12345678");
    parameterMap.put("action", "login");
    UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(
        getParam(parameterMap), "UTF-8");
    httpPost.setEntity(postEntity);
    System.out.println("request line:" + httpPost.getRequestLine());
    try {
      // 执行post请求
      HttpResponse httpResponse = client.execute(httpPost);
      /*String location = httpResponse.getFirstHeader("Location")
          .getValue();
      if (location != null && location.startsWith(loginErrorUrl)) {
        System.out.println("----loginError");
      }*/
      printResponse(httpResponse);

      // 执行get请求
      System.out.println("----the same client");
      HttpGet httpGet = new HttpGet(testUrl);
      System.out.println("request line:" + httpGet.getRequestLine());
      HttpResponse httpResponse1 = client.execute(httpGet);
      printResponse(httpResponse1);


      // cookie store
      setCookieStore(httpResponse);
      // context
      setContext();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        // 关闭流并释放资源
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void testContext() throws Exception {
    System.out.println("----testContext");
    // 使用context方式
    CloseableHttpClient client = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(testUrl);
    System.out.println("request line:" + httpGet.getRequestLine());
    try {
      // 执行get请求
      HttpResponse httpResponse = client.execute(httpGet, context);
      System.out.println("context cookies:"
          + context.getCookieStore().getCookies());
      printResponse(httpResponse);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        // 关闭流并释放资源
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void testCookieStore() throws Exception {
    System.out.println("----testCookieStore");
    // 使用cookieStore方式
    CloseableHttpClient client = HttpClients.custom()
        .setDefaultCookieStore(cookieStore).build();
    HttpGet httpGet = new HttpGet(testUrl);
    System.out.println("request line:" + httpGet.getRequestLine());
    try {
      // 执行get请求
      HttpResponse httpResponse = client.execute(httpGet);
      System.out.println("cookie store:" + cookieStore.getCookies());
      printResponse(httpResponse);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        // 关闭流并释放资源
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void printResponse(HttpResponse httpResponse)
      throws ParseException, IOException {
    // 获取响应消息实体
    HttpEntity entity = httpResponse.getEntity();
    // 响应状态
    System.out.println("status:" + httpResponse.getStatusLine());
    System.out.println("headers:");
    HeaderIterator iterator = httpResponse.headerIterator();
    while (iterator.hasNext()) {
      System.out.println("\t" + iterator.next());
    }
    // 判断响应实体是否为空
    if (entity != null) {
      String responseString = EntityUtils.toString(entity);
      System.out.println("response length:" + responseString.length());
      System.out.println("response content:"
          + responseString.replace("\r\n", ""));
    }
  }

  public static void setContext() {
    System.out.println("----setContext");
    context = HttpClientContext.create();
    Registry<CookieSpecProvider> registry = RegistryBuilder
        .<CookieSpecProvider> create()
        .register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
        .register(CookieSpecs.BROWSER_COMPATIBILITY,
            new BrowserCompatSpecFactory()).build();
    context.setCookieSpecRegistry(registry);
    context.setCookieStore(cookieStore);
  }

  public static void setCookieStore(HttpResponse httpResponse) {
    System.out.println("----setCookieStore");
    cookieStore = new BasicCookieStore();
    // JSESSIONID
    String setCookie = httpResponse.getLastHeader("Set-Cookie")
        .getValue();
    String JSESSIONID = setCookie.substring("PHPSESSID=".length(),
        setCookie.indexOf(";"));
    System.out.println("JSESSIONID:" + JSESSIONID);
    // 新建一个Cookie
    BasicClientCookie cookie = new BasicClientCookie("PHPSESSID",
        JSESSIONID);
    cookie.setVersion(0);
    cookie.setDomain("127.0.0.1");
    cookie.setPath("/CwlProClient");
    // cookie.setAttribute(ClientCookie.VERSION_ATTR, "0");
    // cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "127.0.0.1");
    // cookie.setAttribute(ClientCookie.PORT_ATTR, "8080");
    // cookie.setAttribute(ClientCookie.PATH_ATTR, "/CwlProWeb");
    cookieStore.addCookie(cookie);
  }

  public static List<NameValuePair> getParam(Map parameterMap) {
    List<NameValuePair> param = new ArrayList<NameValuePair>();
    Iterator it = parameterMap.entrySet().iterator();
    while (it.hasNext()) {
      Entry parmEntry = (Entry) it.next();
      param.add(new BasicNameValuePair((String) parmEntry.getKey(),
          (String) parmEntry.getValue()));
    }
    return param;
  }
}
/*复制代码
 

好文要顶 关注我 收藏该文  
672530440@qq
关注 - 3
粉丝 - 17
+加关注
0 0
(请您对文章做出评价)
« 上一篇：window.location.href = basePath + "paper/deleteExpertComment.action?expertId="+$(this).prev().val();
» 下一篇：Spring整合Quartz定时发送邮件
posted @ 2014-05-28 17:36 672530440@qq 阅读(13946) 评论(0) 编辑 收藏
刷新评论刷新页面返回顶部
努力加载评论框中...
最新IT新闻:
· 科学家正在研究猫是否也有自己的方言
· 网友亲历诈骗！安全专家详解：一个验证码如何让你倾家荡产
· MVPM：最小可行产品经理
· 都说跨境电商将被“血洗”，这位从业者却不这么认为
· 外卖O2O是否风口已过？
» 更多新闻...
最新知识库文章:
· 我是一个线程
· 为什么未来是全栈工程师的世界？
· 程序bug导致了天大的损失，要枪毙程序猿吗？
· 如何运维千台以上游戏云服务器
· 架构漫谈（一）：什么是架构？
» 更多知识库文章...
昵称：672530440@qq
园龄：3年3个月
粉丝：17
关注：3
+加关注
<	2016年4月	>
日	一	二	三	四	五	六
27	28	29	30	31	1	2
3	4	5	6	7	8	9
10	11	12	13	14	15	16
17	18	19	20	21	22	23
24	25	26	27	28	29	30
1	2	3	4	5	6	7
Copyright ©2016 672530440@qq*/