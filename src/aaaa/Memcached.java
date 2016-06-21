package aaaa;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
* Created by IntelliJ IDEA.
* User: liuzhy
* Date: 2010-12-3
* Time: 16:43:36
*/
public class Memcached {
	    protected static MemCachedClient mcc = new MemCachedClient();

	    static{

	       // 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务，我这里将两个服务设置为一样的，大家不要向我学习，呵呵。
	        String[] servers =
	                {
	                        "172.16.69.54:11211",
	                       // "10.15.0.215:46697",
//	                        "server3.mydomain.com:1624"
	                };

	// 设置服务器权重
	        Integer[] weights = {3, 2};

	        // 创建一个Socked连接池实例
	        SockIOPool pool = SockIOPool.getInstance();

	      // 向连接池设置服务器和权重
	        pool.setServers(servers);
	        pool.setWeights(weights);

	        // set some TCP settings
	        // disable nagle
	        // set the read timeout to 3 secs
	        // and don't set a connect timeout
	        pool.setNagle(false);
	        pool.setSocketTO(3000);
	        pool.setSocketConnectTO(0);

	       // initialize the connection pool
	        pool.initialize();
	    }

	    public static void main(String[] args) {
	        //mcc.set("foo", "This is a test String");
	        String bar = mcc.get("foo").toString();
	        System.out.println(">>> " + bar);
	    }
	}