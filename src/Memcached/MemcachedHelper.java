package Memcached;

import java.util.Date;
import java.util.Map;
 
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
 
 
public class MemcachedHelper {
 
    private static MemCachedClient mcc = new MemCachedClient();
     
    static {
        //����Socket���ӳ�ʵ��
        SockIOPool spool = SockIOPool.getInstance();        
        String[] servers = {"127.0.0.1:11211"};
        Integer[] weights = {3};        
        //���÷�������Ϣ
        spool.setServers(servers);
        spool.setWeights(weights);      
        spool.setFailover(true);        
        //���ó�ʼ����������С������������Լ������ʱ��
        spool.setInitConn(5);
        spool.setMinConn(5);
        spool.setMaxConn(250);
        spool.setMaxIdle(1000 * 60 * 60 * 6);          
        //�������߳�˯��ʱ��
        spool.setMaintSleep(30);           
        //����TCP���������ӳ�ʱ��
        spool.setNagle(false);
        spool.setSocketTO(3000);
        spool.setSocketConnectTO(0);
        spool.setAliveCheck(true);         
        //��ʼ�����ӳ�
        spool.initialize(); 
    }   
     
    protected MemcachedHelper(){
    }
     
    protected static MemcachedHelper instance = new MemcachedHelper();
     
    /**
     * Ϊ�ܱ����Ķ����ṩһ�������ķ��ʷ���
     */
    public static MemcachedHelper getInstance () {
       return instance;
    }
     
    /**
     * ����һ����¼�������������
     * @param key
     * @param value
     * @return
     */
    public boolean add(String key,Object value) {
       return mcc.add(key, value);
    }
    /**
     * ����һ����¼������������������ù���ʱ�䣬��λΪ��
     * @param key
     * @param value
     * @param expiry
     * @return
     */
    public boolean add (String key,Object value,Date expiry) {
       return mcc.add(key, value,expiry);
    }
    /**
     * ����KEY�滻����������е�����
     * @param key
     * @param value
     * @return
     */
    public boolean replace (String key,Object value) {
       return mcc.replace(key, value);
    }
     
    public boolean replace (String key,Object value,Date expiry) {   
       return mcc.replace(key, value, expiry);
    }
    /**
     * ��KEY������ʱ��������ӵ������������
     * ��KEY����ʱ���滻ԭ��������
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        return mcc.set(key, value);
    }
     
    public boolean set(String key,Object value,Date expiry){
        return mcc.set(key, value,expiry);
    }    
   
    /**
     * ����KEYɾ������������е�����
     * @param key
     * @return
     */
    public boolean delete(String key){
        return mcc.delete(key);
    }   
    /**
     * ����ָ����KEY��ȡ����
     */
    public Object get(String key) {
       return mcc.get(key);
    }
     
    /**
     * ������ȡ���KEY������
     * @param keys
     * @return
     */
    public Map<String,Object> getMulti(String[] keys){
        return mcc.getMulti(keys);
    }
     
    /**
     * �ж�ָ����KEY�Ƿ��Ѿ�����
     * @param key
     * @return
     */
    public boolean keyExists(String key){
        return mcc.keyExists(key);
    }
}