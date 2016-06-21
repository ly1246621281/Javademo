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

	       // ���û���������б���ʹ�÷ֲ�ʽ�����ʱ������ָ��������������������Ӧ������Ϊ�����ͬ�ķ��������ｫ������������Ϊһ���ģ���Ҳ�Ҫ����ѧϰ���Ǻǡ�
	        String[] servers =
	                {
	                        "172.16.69.54:11211",
	                       // "10.15.0.215:46697",
//	                        "server3.mydomain.com:1624"
	                };

	// ���÷�����Ȩ��
	        Integer[] weights = {3, 2};

	        // ����һ��Socked���ӳ�ʵ��
	        SockIOPool pool = SockIOPool.getInstance();

	      // �����ӳ����÷�������Ȩ��
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